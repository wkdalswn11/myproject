package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import member.dao.MemberDaos;
import member.model.Members;

public class ChangePasswordService1 {
	private MemberDaos memberDaos = new MemberDaos();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection con = null;
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Members members = memberDaos.selectById(con, userId);
			if(members == null) {
				throw new MemberNotFoundException();
			}
			if(!members.matchPassword(curPwd) ) {
				throw new InvalidPasswordException();
			}
			members.changePassword(newPwd);
			memberDaos.update(con, members);
			memberDaos.update2(con, members);
			con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
	}
}
