package member.command;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import auth.service.Users;
import member.service.FindPwService;
import member.service.NotFoundMemberException;
import mvc.command.CommandHandler;

public class findPwHandler implements CommandHandler {
	private static final String FORM_VIEW = "findPwForm";
	private FindPwService findPwSvc = new FindPwService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		String name = req.getParameter("name").trim();
		String id = req.getParameter("id").trim();
		
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(name == null || name.isEmpty()) {
			errors.put("name", Boolean.TRUE);
		}
		if(id == null || name.isEmpty()) {
			errors.put("id", Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			Users users = findPwSvc.find(name, id);
			
			req.getSession().setAttribute("users", users);
			
			return "findPwSub";
		} catch (NotFoundMemberException e) {
			errors.put("noMember", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
