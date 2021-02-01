package info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import info.dao.InfoContentDao;
import info.dao.InfoDao;
import info.model.Info;
import info.model.InfoContent;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class ReadInfoService {
	private InfoDao infoDao = new InfoDao();
	private InfoContentDao contentDao = new InfoContentDao();
	
	public InfoData getInfo(int infoNum, boolean increaseReadCount) {
		Connection con = null;
		try {
			con = ConnectionProvider1.getConnection();
			Info info = infoDao.selectByid(con, infoNum);
			
			if(info == null) {
				throw new InfoNotFoundException();
			}
			
			InfoContent content = contentDao.selectByid(con, infoNum);
			
			if(content == null) {
				throw new InfoContentNotFoundException();
			}
			
			if (increaseReadCount) {
				infoDao.increaseReadCount(con, infoNum);
			}
			return new InfoData(info, content);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		
	}
}


