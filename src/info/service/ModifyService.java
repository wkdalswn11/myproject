package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoContentDao;
import info.dao.InfoDao;
import info.model.Info;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class ModifyService {
	private InfoDao infoDao = new InfoDao();
	private InfoContentDao contentDao = new InfoContentDao();
	
	public void modify(ModifyRequest modReq) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Info info = infoDao.selectByid(con, modReq.getInfoNo());
			if (info == null) {
				throw new InfoNotFoundException();
			}
			if (!canModify(modReq.getUserId(), info)) {
				throw new PermissionDeniedException();
			}
			infoDao.update(con, modReq.getInfoNo(), modReq.getTitle());
			
			contentDao.Update(con, modReq.getInfoNo(), modReq.getContent());
			
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

	private boolean canModify(String userId, Info info) {
		return info.getWriter().getId().equals(userId);
	}
}
