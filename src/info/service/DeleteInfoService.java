package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import member.model.Members;
import reply.dao.ReplyDao;
import auth.service.Users;
import info.dao.InfoContentDao;
import info.dao.InfoDao;
import info.dao.InfoSubDao;
import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;
import member.dao.MemberDaos;


public class DeleteInfoService {
	private MemberDaos memberDaos = new MemberDaos();
	private InfoDao infoDao = new InfoDao();
	private InfoContentDao contentDao = new InfoContentDao();
	private InfoSubDao subDao = new InfoSubDao();
	private ReplyDao replyDao = new ReplyDao();
	public void delete(int no, Users authUser, String password) {
		Connection con = ConnectionProvider1.getConnection();
		
		try {
			con.setAutoCommit(false);
			Members members = memberDaos.selectById(con, authUser.getId());
			
			//같지 않으면 exception
			System.out.println(members.getPassword());
			System.out.println(password);
			if(!members.getPassword().equals(password)) {
				throw new PermissionDeniedException();
			}
			// infodao.delete ,contentDao delete
			replyDao.delete3(con, no);
			subDao.delete(con, no);
			contentDao.delete(con, no);
			infoDao.delete(con, no);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcUtil.close(con);
			throw new RuntimeException(e);
		}
	}
}
