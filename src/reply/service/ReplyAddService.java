package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import reply.dao.ReplyDao;

public class ReplyAddService {
	private ReplyDao dao = new ReplyDao();
	
	public void add(String userid, int infoNum, String body) {
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			dao.insert(con, userid, infoNum, body);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			
			JdbcUtil.close(con);
		}
	}
}
