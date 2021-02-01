package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoSubDao;
import info.model.InfoSub;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class GoodAddService {
	private InfoSubDao infoDao = new InfoSubDao();
	
	public InfoSub add(int infoNum) {
		
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			
			infoDao.goodAdd(con, infoNum);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return null;
	}
}
