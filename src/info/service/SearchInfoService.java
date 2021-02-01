package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import info.dao.InfoDao;
import info.dao.InfoSubDao;
import info.model.Info;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class SearchInfoService {
	
	
	private InfoDao infoDao = new InfoDao();
	private int size = 10;
	
	public InfoPage getInfoPage2(int pageNum, String searchField, String searchKeyword) {
		Connection con = null;
		
		try { 
			con = ConnectionProvider1.getConnection();
			
			int total = infoDao.selectCount2(con, searchField, searchKeyword);
			List<Info> content = infoDao.search(con, searchField, searchKeyword);
		
			return new InfoPage(total, pageNum, content, size);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
