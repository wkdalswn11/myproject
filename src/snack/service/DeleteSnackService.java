package snack.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.Users;
import info.service.PermissionDeniedException;
import jdbc.ConnectionProvider1;
import member.dao.MemberDaos;
import member.model.Members;
import snack.dao.SnackContentDao;
import snack.dao.SnackDao;

public class DeleteSnackService {
	private MemberDaos memberDaos = new MemberDaos();
	private SnackDao dao = new SnackDao();
	private SnackContentDao contentDao = new SnackContentDao();
	
	public void delete(int no, Users authUser, String password) throws Exception {
		
		try (Connection con = ConnectionProvider1.getConnection()) {
			
			con.setAutoCommit(false);
			Members members = memberDaos.selectById(con, authUser.getId());
			
			if (!members.getPassword().equals(password)) {
				throw new PermissionDeniedException();
			}
			
			contentDao.delete(con, no);
			dao.delete(con, no);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
