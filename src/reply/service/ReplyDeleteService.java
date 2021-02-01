package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import reply.dao.ReplyDao;

public class ReplyDeleteService {
	private ReplyDao dao = new ReplyDao();
	
	public void delete(String userid, int id) {
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			dao.delete(con, userid, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
