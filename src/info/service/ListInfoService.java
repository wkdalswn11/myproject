package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import info.dao.InfoDao;
import info.dao.InfoSubDao;
import info.model.Info;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class ListInfoService {
	
	
	private InfoDao infoDao = new InfoDao();
	private int size = 10;
	
	public InfoPage getInfoPage(int pageNum) {
		Connection con = null;
		
		try  {

			con = ConnectionProvider1.getConnection();
			int total = InfoDao.selectCount(con);
			List<Info> content = infoDao.select(con, pageNum, size);
			
			return new InfoPage(total, pageNum, content, size);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
	
	
}
