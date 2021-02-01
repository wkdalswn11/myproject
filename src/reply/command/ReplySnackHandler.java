package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.Users;
import mvc.command.CommandHandler;
import reply.service.ReplySnackAddService;

public class ReplySnackHandler implements CommandHandler{
	private ReplySnackAddService replyAddSvc = new ReplySnackAddService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Users authUser = (Users) session.getAttribute("authUser");
		
		int snackNum = Integer.valueOf(req.getParameter("no"));
		String userid = authUser.getId();
		String body = req.getParameter("body");
		replyAddSvc.add2(userid, snackNum, body);
		
		res.sendRedirect(req.getContextPath() + "/sread.do?no="+ snackNum);
		return null;
	}
}
