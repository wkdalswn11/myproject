package snack.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.InfoContentNotFoundException;
import info.service.InfoNotFoundException;
import mvc.command.CommandHandler;
import reply.model.Reply;
import snack.model.Snack;
import snack.service.ReadSnackService;
import snack.service.ReplySnackService;
import snack.service.SnackData;

public class ReadSnackHandler implements CommandHandler {
	private ReadSnackService readSvc = new ReadSnackService();
	private ReplySnackService replySvc = new ReplySnackService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		SnackData snackData = null;
		Snack snack = null;
		String no = req.getParameter("no");
		int snackNum = Integer.parseInt(no);
		String oper = req.getParameter("oper");
		
		if (oper == null) {
			snackData = readSvc.getSnack(snackNum, true);
			snack = readSvc.addGood(snackNum); 
			List<Reply> replyList = replySvc.getReplyList(snackNum);
			req.setAttribute("snackData", snackData);
			req.setAttribute("snack", snack);
			req.setAttribute("replyList", replyList);
		}
		
		if (oper != null && oper.equals("like")) {
			
			readSvc.add(snackNum);
			snack = readSvc.addGood(snackNum);
			snackData = readSvc.getSnack(snackNum, false);
			List<Reply> replyList = replySvc.getReplyList(snackNum);
			req.setAttribute("snackData", snackData);
			req.setAttribute("snack", snack);
			req.setAttribute("replyList", replyList);
		}
		else if (oper != null && oper.equals("hate")) {
			readSvc.hateadd(snackNum);
			snack = readSvc.addGood(snackNum); 
			snackData = readSvc.getSnack(snackNum, false);
			List<Reply> replyList = replySvc.getReplyList(snackNum);
			req.setAttribute("snackData", snackData);
			req.setAttribute("snack", snack);
			req.setAttribute("replyList", replyList);
		}
		
		
		return "readSnack";
		
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String noVal = req.getParameter("no");
		int snackNum = Integer.parseInt(noVal);
		
		try {
			List<Reply> replyList = replySvc.getReplyList(snackNum);
			req.setAttribute("replyList", replyList);
			return "readSnack";
		} catch (InfoNotFoundException | InfoContentNotFoundException e) {
			// req.getServletContext().log("no article", e);
			System.out.println("게시물이 없습니다.");
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
