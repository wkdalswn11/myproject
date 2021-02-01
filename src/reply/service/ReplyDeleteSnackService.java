package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import reply.dao.ReplyDao;

public class ReplyDeleteSnackService {
	private ReplyDao dao = new ReplyDao();
	
	public void delete2(String userid, int id) throws SQLException {
		try (Connection con = ConnectionProvider1.getConnection()) {
			dao.delete2(con, userid, id);
		}	catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
