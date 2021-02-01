package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.Users;
import mvc.command.CommandHandler;
import reply.service.ReplyDeleteSnackService;

public class ReplyDeleteSnackHandler implements CommandHandler{
	private ReplyDeleteSnackService deleteSvc = new ReplyDeleteSnackService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("authUser");
		
		String userId = users.getId();
		int infoNo = Integer.parseInt(req.getParameter("no"));
		int infoNum = Integer.parseInt(req.getParameter("num"));
		
		deleteSvc.delete2(userId, infoNum);
		
		res.sendRedirect(req.getContextPath() + "/sread.do?no=" + infoNo);
		return null;
	}
}
