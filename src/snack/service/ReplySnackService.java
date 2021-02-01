package snack.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider1;
import reply.dao.ReplyDao;
import reply.model.Reply;

public class ReplySnackService {
	private ReplyDao dao = new ReplyDao();

	public List<Reply> getReplyList(int snackNum) {
		List<Reply> list;
		try (Connection con = ConnectionProvider1.getConnection()) {

			list = dao.listReply2(con, snackNum);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}
}
