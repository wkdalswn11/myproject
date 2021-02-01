package image.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import image.dao.imageDao;
import jdbc.ConnectionProvider1;
import mvc.command.CommandHandler;

public class imageHandler implements CommandHandler{
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return getProcess(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return postProcess(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String postProcess(HttpServletRequest req, HttpServletResponse res) {
		Connection con = ConnectionProvider1.getConnection();
		return null;
	}

	private String getProcess(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
}
