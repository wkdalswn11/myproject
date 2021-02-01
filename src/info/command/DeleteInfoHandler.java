package info.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Users;
import info.service.DeleteInfoService;
import info.service.InfoData;
import info.service.PermissionDeniedException;
import info.service.ReadInfoService;
import mvc.command.CommandHandler;

public class DeleteInfoHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteInfoForm";
	
	private ReadInfoService readSvc = new ReadInfoService();
	private DeleteInfoService deleteSvc = new DeleteInfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return getProcess(req,res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return postProcess(req,res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String getProcess(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}


	private String postProcess(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		Users authUser = (Users) req.getSession().getAttribute("authUser");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		
		
		InfoData infoData = readSvc.getInfo(no, false);
		
		if (!authUser.getId().equals(infoData.getInfo().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			
			deleteSvc.delete(no, authUser, password);
		} catch (PermissionDeniedException e) {
			errors.put("invalidePassword", true);
			return FORM_VIEW;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		res.sendRedirect(req.getContextPath() + "/list.do");
		return null;
	}
	
	
}
