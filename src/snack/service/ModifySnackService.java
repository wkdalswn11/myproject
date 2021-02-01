package snack.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.service.PermissionDeniedException;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import snack.dao.SnackContentDao;
import snack.dao.SnackDao;
import snack.model.Snack;

public class ModifySnackService {
	private SnackDao dao = new SnackDao();
	private SnackContentDao contentDao = new SnackContentDao();
	
	public void modify(ModifySnackRequest modReq) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Snack snack = dao.selectByid(con, modReq.getSnackNo());
			if (snack == null) {
				throw new SnackNotFoundException();
			}
			if (!canModify(modReq.getUserId(), snack)) {
				throw new PermissionDeniedException();
			}
			
			dao.update(con, modReq.getSnackNo(), modReq.getTitle());
			
			contentDao.update(con, modReq.getSnackNo(), modReq.getContent());
			
			con.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			e.printStackTrace();
			JdbcUtil.rollback(con);
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}

	private boolean canModify(String userId, Snack snack) {
		return snack.getWriter().getId().equals(userId);
	}
}
