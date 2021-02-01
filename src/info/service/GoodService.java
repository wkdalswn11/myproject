package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoSubDao;
import info.model.InfoSub;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;



public class GoodService {
	private InfoSubDao subDao = new InfoSubDao();
	
	public InfoSub add2(int infoNum) {
		Connection con = ConnectionProvider1.getConnection();
		 InfoSub sub = null;
		try {
			sub = subDao.selectGood(con, infoNum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return new InfoSub(sub.getId(), sub.getGood(), sub.getHate());	
	}
}
