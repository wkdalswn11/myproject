package snack.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider1;
import mvc.command.CommandHandler;
import snack.service.ListSnackService;
import snack.service.SearchSnackService;
import snack.service.SnackPage;

public class ListSnackHandler implements CommandHandler {
	private ListSnackService listSvc = new ListSnackService();
	private SearchSnackService searchSvc = new SearchSnackService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		String field = req.getParameter("field");
		String search = req.getParameter("search");
		int pageNo = 1;
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		if (search != null && field != null) {
			try (Connection con = ConnectionProvider1.getConnection()) {
				
				SnackPage snackPage1 = searchSvc.getSnackPage2(pageNo, field, search);
				req.setAttribute("snackPage", snackPage1);
				return "listSnack";
			}
		}
		
		SnackPage snackPage = listSvc.getSnackPage(pageNo);
		req.getSession().setAttribute("snackPage", snackPage);
		/*
		 * req.setAttribute("snackPage", snackPage);
		 */
		return "listSnack";
	}
}
