package info.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.model.InfoSub;
import info.service.GoodAddService;
import info.service.GoodService;
import mvc.command.CommandHandler;

public class LoveInfoHandler implements CommandHandler { 
	private GoodAddService addService = new GoodAddService();
	private GoodService goodSvc = new GoodService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String no =  req.getParameter("no");
		int infoNum = Integer.parseInt(no);
		
		
		

		goodSvc.add2(infoNum); //insert
		
		
		addService.add(infoNum); // +1 증가
		
		//req.getSession().setAttribute("infoSub", infoSub);
		//req.setAttribute("infoSub", infoSub);
		
		res.sendRedirect(req.getContextPath() + "/read.do?no=" + no);		
		return null;
		
	} 
 }

 
