package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.Users;
import jdbc.ConnectionProvider1;
import member.dao.MemberDaos;
import member.model.Members;

public class FindPwService {
	private MemberDaos memberDaos = new MemberDaos();
	
	public Users find(String id, String name) throws SQLException {
		 
		try(Connection con = ConnectionProvider1.getConnection()) {
			Members members = memberDaos.findPw(con, id, name);
			if(members == null) {
				throw new NotFoundMemberException();
			}
				Users u = new Users(members.getId(), members.getName(), members.getPassword());
				
				return u;
				/*
				 * System.out.println(members.getPassword()); return new Users(members.getId(),
				 * members.getPassword(), members.getName());
				 */
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
