package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import member.dao.MemberDaos;
import member.model.Members;

public class JoinService {
	private MemberDaos memberDaos = new MemberDaos();
	
	Connection con = null;
	
	public void join(JoinRequest joinReq) {
		
		try { 
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Members m = memberDaos.selectById(con, joinReq.getId());
			
			if (m != null) {
				throw new DuplicateIdException();
			}
			
			Members members = new Members();
			members.setId(joinReq.getId());
			members.setPassword(joinReq.getPassword());
			members.setConfirmPassword(joinReq.getConfirmPassword());
			members.setName(joinReq.getName());
			members.setNickname(joinReq.getNickname());
			members.setBirth(joinReq.getBirth());
			
			
			memberDaos.insert(con, members);
			
			con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(con);
		}
	}
}
