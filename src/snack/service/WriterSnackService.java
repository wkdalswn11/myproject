package snack.service;

import java.sql.Connection;
import java.sql.SQLException;


import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import snack.dao.SnackContentDao;
import snack.dao.SnackDao;
import snack.model.Snack;
import snack.model.SnackContent;

public class WriterSnackService {
	private SnackDao dao = new SnackDao();
	private SnackContentDao contentDao = new SnackContentDao();
	
	public Integer write(SnackWriteRequest req) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Snack snack = toSnack(req);
			Snack savedSnack = dao.insert(con, snack);
			
			if (savedSnack==null) {
				throw new RuntimeException("fail to insert Snack");
			}
			
			SnackContent content = new SnackContent(savedSnack.getNumber(),
					req.getContent());
			SnackContent savedContent = contentDao.insert(con, content);
			
			if (savedContent == null) {
				throw new RuntimeException("fail to insert Snack_content");
			}
			
			con.commit();
			
			return savedSnack.getNumber();
		}catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(con);
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}

	private Snack toSnack(SnackWriteRequest req) {
		
		return new Snack(null, req.getWriter(), req.getTitle(), null, null, 0, 0, 0);
	}
}
