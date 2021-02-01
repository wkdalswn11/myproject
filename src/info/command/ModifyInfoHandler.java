package info.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Users;
import info.service.InfoData;
import info.service.InfoNotFoundException;
import info.service.ModifyRequest;
import info.service.ModifyService;
import info.service.PermissionDeniedException;
import info.service.ReadInfoService;
import mvc.command.CommandHandler;

public class ModifyInfoHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "modifyForm";
	private ReadInfoService readInfoSvc = new ReadInfoService();
	private ModifyService modifySVc = new ModifyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			
			InfoData infoData = readInfoSvc.getInfo(no, false);
			Users authUser = (Users) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, infoData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			ModifyRequest modReq = new ModifyRequest(
					authUser.getId(), 
					no, 
					infoData.getInfo().getTitle(), 
					infoData.getContent());
			
			req.setAttribute("modReq", modReq);
			return FORM_VIEW;
		} catch (InfoNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private boolean canModify(Users authUser, InfoData infoData) {
		String wrtierId = infoData.getInfo().getWriter().getId();
		return authUser.getId().equals(wrtierId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Users authUser = (Users) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		ModifyRequest modReq = new ModifyRequest(
				authUser.getId(), 
				no, 
				req.getParameter("title"), 
				req.getParameter("content"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			modifySVc.modify(modReq);
			res.sendRedirect(req.getContextPath() + "/read.do?no=" + no);
			return null;
		}catch (InfoNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		
	}

	
}
