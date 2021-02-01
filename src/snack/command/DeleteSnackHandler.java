package snack.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Users;
import info.service.PermissionDeniedException;
import mvc.command.CommandHandler;
import snack.service.DeleteSnackService;
import snack.service.ReadSnackService;
import snack.service.SnackData;


public class DeleteSnackHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteSnackForm";
	
	private ReadSnackService readSvc = new ReadSnackService();
	private DeleteSnackService deleteSvc = new DeleteSnackService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return processGet(req,res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processPost(req,res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processGet(HttpServletRequest req, HttpServletResponse res) {
		
		return FORM_VIEW;
	}

	private String processPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String , Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		Users authUser = (Users) req.getSession().getAttribute("authUser");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		 
		SnackData snackData = readSvc.getSnack(no, false);
		
		if (!authUser.getId().equals(snackData.getSnack().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteSvc.delete(no, authUser, password);
		} catch ( PermissionDeniedException e) {
			errors.put("invalidePassword", true);
			return FORM_VIEW;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		res.sendRedirect("slist.do");
		return null;
	}
	
}
