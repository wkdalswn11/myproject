package info.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Users;
import info.dao.InfoSubDao;
import info.model.Writer;
import info.service.GoodService;
import info.service.WriteRequest;
import info.service.WriterInfoService;
import mvc.command.CommandHandler;


public class WriterInfoHandler implements CommandHandler {
	private static final String FORM_VIEW = "newInfoForm";
	private WriterInfoService writerService = new WriterInfoService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		
		
		
		Users users = (Users) req.getSession(false).getAttribute("authUser");
		
		WriteRequest writeReq = createWriteRequest(users, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newInfoNo = writerService.write(writeReq);
		req.setAttribute("newInfoNo", newInfoNo);
		
		res.sendRedirect("list.do");
		
		return null;
	}

	private WriteRequest createWriteRequest(Users users, HttpServletRequest req) {
		
		return new WriteRequest(
				new Writer(users.getId(), users.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}
}
