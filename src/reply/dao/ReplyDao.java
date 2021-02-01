package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import reply.model.Reply;

public class ReplyDao {

	public void insert(Connection con, String userid, int infoNum, String body) throws SQLException {
		String sql = "INSERT INTO info_reply "
				+ "(memberid, info_no, body , regdate, moddate) "
				+ "VALUES( ?, ?, ?, SYSDATE, SYSDATE ) ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, userid);
			pstmt.setInt(2, infoNum);
			pstmt.setString(3, body);
			
			pstmt.executeUpdate();
		}
	}

	public List<Reply> listReply(Connection con, int infoNum) throws SQLException {
		String sql = "SELECT replyid, memberid, info_no, body, "
				+ "regdate, moddate "
				+ "FROM info_reply "
				+ "WHERE info_no = ? "
				+ "ORDER BY replyid DESC ";
		ResultSet rs = null;
		
		List<Reply> list = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, infoNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt(1));
				r.setMemberId(rs.getString(2));
				r.setInfoNum(rs.getInt(3));
				r.setBody(rs.getString(4));
				r.setRegdate(rs.getTimestamp(5));
				r.setModdate(rs.getTimestamp(6));
				
				list.add(r);
			}
		}
		return list;
	}

	public void delete(Connection con, String userid, int id) throws SQLException {
		String sql = "DELETE info_reply WHERE replyid = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			
			pstmt.executeQuery();
		}
		
	}
	public void delete3(Connection con, int id) throws SQLException {
		String sql = "DELETE info_reply WHERE info_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			
			pstmt.executeQuery();
		}
		
	}

	public List<Reply> listReply2(Connection con, int snackNum) throws SQLException {
		String sql = "SELECT replyid, memberid, snack_no, body, regdate, moddate "
				+ "FROM snack_reply "
				+ "WHERE snack_no = ? "
				+ "ORDER BY replyid DESC ";
		
		List<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, snackNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt(1));
				r.setMemberId(rs.getString(2));
				r.setInfoNum(rs.getInt(3));
				r.setBody(rs.getString(4));
				r.setRegdate(rs.getTimestamp(5));
				r.setModdate(rs.getTimestamp(6));
				
				list.add(r);
			}
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return list;
		
		
	}

	public void insert2(Connection con, String userid, int snackNum, String body) throws SQLException {
		String sql = "INSERT INTO snack_reply "
				+ "(memberid, snack_no, body, regdate, moddate) "
				+ "VALUES (?, ?, ?, SYSDATE, SYSDATE) ";
			
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, userid);
			pstmt.setInt(2, snackNum);
			pstmt.setString(3, body);
			
			pstmt.executeUpdate();
		}
		
	}
	
	public void delete2(Connection con, String userid, int id) throws SQLException {
		String sql = "DELETE snack_reply WHERE replyid = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			
			pstmt.executeQuery();
		}
		
	}
	
	
}









