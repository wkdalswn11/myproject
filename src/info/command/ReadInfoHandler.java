package info.command;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import info.model.InfoSub;
import info.service.GoodAddService;
import info.service.GoodService;
import info.service.HateAddService;
import info.service.InfoContentNotFoundException;
import info.service.InfoData;
import info.service.InfoNotFoundException;
import info.service.ReadInfoService;
import mvc.command.CommandHandler;
import reply.model.Reply;
import reply.service.ReplyService;

public class ReadInfoHandler implements CommandHandler {
	private ReadInfoService readService = new ReadInfoService();
	private GoodAddService addService = new GoodAddService();
	private GoodService goodSvc = new GoodService();
	private HateAddService hateAddSvc = new HateAddService();
	private ReplyService replySvc = new ReplyService();

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
	// post
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		InfoData infoData = null;
		String no = req.getParameter("no");
		int infoNum = Integer.parseInt(no);
		String oper = req.getParameter("oper");
		
		if (oper == null) {
			infoData = readService.getInfo(infoNum, true);
			InfoSub infosub = goodSvc.add2(infoNum);
			List<Reply> replyList = replySvc.getReplyList(infoNum);
			req.setAttribute("infoSub", infosub);
			req.setAttribute("infoData", infoData);
			req.setAttribute("replyList", replyList);
		}
		
		if (oper != null && oper.equals("like")) {
			
			
			addService.add(infoNum); // +1 증가 좋아요
			InfoSub infosub = goodSvc.add2(infoNum);
			infoData = readService.getInfo(infoNum, false);
			List<Reply> replyList = replySvc.getReplyList(infoNum);
			req.setAttribute("infoSub", infosub);
			req.setAttribute("infoData", infoData);
			req.setAttribute("replyList", replyList);
		}
		else if (oper != null && oper.equals("hate")) {
			hateAddSvc.Hateadd(infoNum); // +1 증가 싫어요
			InfoSub infosub = goodSvc.add2(infoNum);
			infoData = readService.getInfo(infoNum, false);
			List<Reply> replyList = replySvc.getReplyList(infoNum);
			req.setAttribute("infoSub", infosub);
			req.setAttribute("infoData", infoData);
			req.setAttribute("replyList", replyList);
			
		}
			
		
		
		return "readInfo";
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String noVal = req.getParameter("no");
		int InfoNum = Integer.parseInt(noVal);
		
		try {
			List<Reply> replyList = replySvc.getReplyList(InfoNum);
			req.setAttribute("replyList", replyList);
			return "readInfo";
		} catch (InfoNotFoundException | InfoContentNotFoundException e) {
			// req.getServletContext().log("no article", e);
			System.out.println("게시물이 없습니다.");
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}		
		
		
		
	}
}

