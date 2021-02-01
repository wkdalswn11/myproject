package member.command;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.Users;
import member.service.DeleteMemberService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class DeleteMemberHandler implements CommandHandler{
	private static final String FORM_VIEW = "deleteMemberForm";
	private DeleteMemberService deleteMemberSvc = new DeleteMemberService();
	
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
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (password == null || password.isEmpty()) {
			errors.put("password", true);
		}
		if (name == null || name.isEmpty()) {
			errors.put("name", true);
		}
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("authUser");
		
		try {
			deleteMemberSvc.deleteMember(users, name, password);
			
			session.invalidate();
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return null;
			
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			errors.put("notMatchPassword", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		
	}
}
