package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import reply.dao.ReplyDao;

public class ReplySnackAddService {
	private ReplyDao dao = new ReplyDao();
	
	public void add2(String userid, int snackNum, String body) {
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			dao.insert2(con, userid, snackNum, body);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
