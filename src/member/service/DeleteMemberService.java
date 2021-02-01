package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.Users;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import member.dao.MemberDaos;
import member.model.Members;

public class DeleteMemberService {
	private MemberDaos memberDaos = new MemberDaos();
	
	public void deleteMember(Users users, String name, String password) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Members members = memberDaos.selectById(con, users.getId());
			if (members == null) {
				throw new MemberNotFoundException();
			} 
			if (!members.matchPassword(password)) {
				throw new InvalidPasswordException();
			}
			
			memberDaos.delete(con, users.getId());
			con.commit();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
