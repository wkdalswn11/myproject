package snack.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.Users;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import snack.dao.SnackContentDao;
import snack.dao.SnackDao;
import snack.model.Snack;
import snack.model.SnackContent;

public class ReadSnackService {
	private SnackDao dao =  new SnackDao();
	private SnackContentDao contentDao = new SnackContentDao();
	
	public SnackData getSnack(int SnackNum, boolean increaseReadCnt) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			Snack snack = dao.selectByid(con, SnackNum);
			
			if (snack == null) {
				throw new SnackNotFoundException();
			}
			
			SnackContent content = contentDao.selectByid(con, SnackNum);
			
			if (content == null) {
				throw new SnackContentNotFoundException();
			}
			
			if (increaseReadCnt) {
				dao.increaseReadCnt(con, SnackNum);
			}
			return new SnackData(snack, content);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(con);
		}
	}
	
	public Snack addGood(int snackNum) {
		Connection con = ConnectionProvider1.getConnection();
		Snack snack = null;
		
		try { 
			snack = dao.selectGood(con, snackNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		
		return snack;
	}

	public Snack add(int snackNum) {
		
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			dao.goodAdd(con, snackNum);
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return null;
		
	}

	public Snack hateadd(int snackNum) {
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			dao.hateAdd(con, snackNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return null;
				
		
		
	}
}
