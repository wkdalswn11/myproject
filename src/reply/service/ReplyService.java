package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import reply.dao.ReplyDao;
import reply.model.Reply;

public class ReplyService {
	private ReplyDao dao = new ReplyDao();
	
	public List<Reply> getReplyList(int infoNum) {
		Connection con = ConnectionProvider1.getConnection();
		
		List<Reply> list;
		
		try {
			list = dao.listReply(con, infoNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		return list;
	}
}
