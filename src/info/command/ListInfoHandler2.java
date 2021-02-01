package info.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.InfoPage;
import info.service.ListInfoService2;
import mvc.command.CommandHandler;

public class ListInfoHandler2 implements CommandHandler{
	private ListInfoService2 listService = new ListInfoService2();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		
		int pageNo = 1;
		
		if (pageNoVal != null ) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		
		
		
		InfoPage infoPage = listService.getInfoPage2(pageNo);
		
		
		 req.setAttribute("infoPage" , infoPage); 
		
		return "index";
	}
}
