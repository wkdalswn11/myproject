package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class ListInfoService2 {
	private InfoDao dao = new InfoDao();
	private int size = 5;
	
	public InfoPage getInfoPage2(int pageNum) {
		Connection con = null;
		
		try { 
			con = ConnectionProvider1.getConnection();
			int total = InfoDao.selectCount(con);
			List<Info> content = dao.select(con, pageNum, size);
			
			return new InfoPage(total, pageNum, content, size);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
