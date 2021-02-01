package snack.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import auth.service.Users;
import info.service.InfoNotFoundException;
import info.service.PermissionDeniedException;
import javafx.scene.control.Alert;
import mvc.command.CommandHandler;
import snack.service.ModifySnackRequest;
import snack.service.ModifySnackService;
import snack.service.ReadSnackService;
import snack.service.SnackData;

public class ModifySnackHandler implements CommandHandler {
	private static final String FORM_VIEW = "modifySnackForm";
	private ReadSnackService readSvc = new ReadSnackService();
	private ModifySnackService modifySvc = new ModifySnackService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processGet(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processPost(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
	 try {	
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		SnackData snackData = readSvc.getSnack(no, false);
		Users authUser = (Users) req.getSession().getAttribute("authUser");
		if (!canModify(authUser, snackData)) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		ModifySnackRequest modReq = new ModifySnackRequest(authUser.getId(), 
				no, 
				snackData.getSnack().getTitle(), 
				snackData.getContent());
		
		req.setAttribute("modReq", modReq);
		return FORM_VIEW;
	 } catch (InfoNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	} 
	
	private boolean canModify(Users authUser, SnackData snackData) {
		String writerId = snackData.getSnack().getWriter().getId();
		return authUser.getId().equals(writerId);
	}

	private String processPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Users authUser = (Users) req.getSession(false).getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		ModifySnackRequest modReq = new ModifySnackRequest(authUser.getId(), 
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
			modifySvc.modify(modReq);
			res.sendRedirect("slist.do");
			
			return null;
		} catch (InfoNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
	}

	

}
