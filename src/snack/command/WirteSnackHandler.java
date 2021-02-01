package snack.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Users;
import info.model.Writer;

import mvc.command.CommandHandler;
import snack.service.SnackWriteRequest;
import snack.service.WriterSnackService;

public class WirteSnackHandler implements CommandHandler {
	private static final String FORM_VIEW = "newSnackForm";
	private WriterSnackService writerSnackSvc = new WriterSnackService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		Users users = (Users) req.getSession(false).getAttribute("authUser");
		
		SnackWriteRequest snackWriteReq = createWriteRequest(users, req);
		snackWriteReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newSanckNo = writerSnackSvc.write(snackWriteReq);
		req.setAttribute("newSanckNo", newSanckNo);
		
		res.sendRedirect("slist.do");
		
		return null;
		
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		
		return FORM_VIEW;
	}
	
	
	private SnackWriteRequest createWriteRequest(Users users, HttpServletRequest req) {

		return new SnackWriteRequest(
				new Writer(users.getId(), users.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}
}
