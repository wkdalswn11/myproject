package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider1;
import member.dao.MemberDaos;
import member.model.Members;

public class LoginService {
	private MemberDaos memberDaos = new MemberDaos();
	
	public Users login(String id, String password) {
		
		try(Connection con = ConnectionProvider1.getConnection()) {
		Members members = memberDaos.selectById(con, id);
		
		if(members == null) {
			throw new LoginFailException();
		}
		if(!members.matchPassword(password)) {
			throw new LoginFailException();
		}
		 return new Users(members.getId(), members.getName(), members.getPassword());
	} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
}
	
