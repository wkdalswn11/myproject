package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.Users;
import mvc.command.CommandHandler;
import reply.service.ReplyAddService;

public class ReplyHandler implements CommandHandler { 
	private ReplyAddService replyAddSvc = new ReplyAddService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("authUser");
		
		int infoNum = Integer.valueOf(req.getParameter("num"));
		String userid = users.getId();
		String body = req.getParameter("body");
		replyAddSvc.add(userid, infoNum, body);
		
		res.sendRedirect(req.getContextPath() + "/read.do?no="+ infoNum);
		return null;
	}

}
