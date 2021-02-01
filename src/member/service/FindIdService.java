package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.Users;
import jdbc.ConnectionProvider1;
import member.dao.MemberDaos;
import member.model.Members;

public class FindIdService {
	private MemberDaos memberDaos = new MemberDaos();

	public Users find(String name, String birth) throws SQLException {
		try (Connection con = ConnectionProvider1.getConnection()) {
			Members members = memberDaos.findId(con, name, birth);
			if (members == null) {
				throw new MemberNotFoundException();
			}
			Users users = new Users(members.getId(), members.getName(), members.getNickname());
			return users;
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}
}
