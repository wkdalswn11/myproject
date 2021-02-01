package info.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import info.service.GoodService;
import info.service.InfoPage;
import info.service.ListInfoService;
import info.service.SearchInfoService;
import jdbc.ConnectionProvider1;
import mvc.command.CommandHandler;

public class ListInfoHandler implements CommandHandler{
	private ListInfoService listService = new ListInfoService();
	private SearchInfoService searchSvc = new SearchInfoService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		String field = req.getParameter("field");
		String search = req.getParameter("search");
		int pageNo = 1;
		
		if (pageNoVal != null ) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		if (search != null && field != null) {
			try (Connection con = ConnectionProvider1.getConnection()) {
				
				
				InfoPage infoPage1 =  searchSvc.getInfoPage2(pageNo, field, search);
				req.setAttribute("infoPage", infoPage1);
				return "listInfo";
			}
		}
		
		InfoPage infoPage = listService.getInfoPage(pageNo);
		
		req.getSession().setAttribute("infoPage", infoPage);
		/* req.setAttribute("infoPage" , infoPage); */
		
		return "listInfo";
	}

}
