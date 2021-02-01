package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.Users;
import info.service.ReadInfoService;
import mvc.command.CommandHandler;
import reply.service.ReplyDeleteService;

public class ReplyDeleteHandler implements CommandHandler { 
	private ReplyDeleteService deleteSvc = new ReplyDeleteService();
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("authUser");
		
		String userId = users.getId();
		int infoNo = Integer.parseInt(req.getParameter("num"));
		int infoNum = Integer.parseInt(req.getParameter("no"));
		deleteSvc.delete(userId, infoNo);
		
		res.sendRedirect(req.getContextPath() + "/read.do?no=" + infoNum);
		return null;
	}
}
