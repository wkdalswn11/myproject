package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Members;

public class MemberDaos {

	public Members selectById(Connection con, String id) throws SQLException{
		
		Members members = null;
		
		String sql = "SELECT memberid, password, confirmPassword, name, nickname "
				+ ", birth, regdate "
				+ "FROM members "
				+ "WHERE memberid=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				members = new Members();
				members.setId(rs.getString(1));
				members.setPassword(rs.getString(2));
				members.setConfirmPassword(rs.getString(3));
				members.setName(rs.getString(4));
				members.setNickname(rs.getString(5));
				members.setBirth(rs.getString(6));
				members.setRegdate(rs.getTimestamp(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		
		return members;
	}

	public void insert(Connection con, Members members) throws SQLException {
		String sql = "INSERT INTO members "
				+ "(memberid, password, confirmPassword , name, nickname, birth, regdate) "
				+ "VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), SYSDATE) ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, members.getId());
			pstmt.setString(2, members.getPassword());
			pstmt.setString(3, members.getConfirmPassword());
			pstmt.setString(4, members.getName());
			pstmt.setString(5, members.getNickname());
			pstmt.setString(6, members.getBirth());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}

	public void update(Connection con, Members members) throws SQLException {
		String sql = "UPDATE members "
				+ "SET password = ? "
				+ "WHERE memberid=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, members.getPassword());
			pstmt.setString(2, members.getId());
		 
			pstmt.executeUpdate();
		}
		
	}
	public void update2(Connection con, Members members) throws SQLException {
		String sql = "UPDATE members "
				+ "SET confirmPassword = ? "
				+ "WHERE memberid=? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, members.getConfirmPassword());
			pstmt.setString(2, members.getId());
		 
			pstmt.executeUpdate();
		}
		
	}

	public Members findPw(Connection con, String name, String id) throws SQLException {
		String sql = "SELECT memberid, password "
				+ "FROM members "
				+ "WHERE name = ? and memberid = ? ";
		Members members = null;
		ResultSet rs = null;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				members = new Members();
				members.setId(rs.getString(1));
				members.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(rs);
		}

		return members;
	}

	public void delete(Connection con, String id) throws SQLException {
		String sql = "DELETE FROM members "
				+ "WHERE memberid = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		}
				
		
	}

	public Members findId(Connection con, String name, String birth) throws SQLException{
		String sql = "SELECT memberid "
				+ "FROM members "
				+ "WHERE birth = TO_DATE(? , 'YYYY-MM-DD') ";
		Members members = null;
		 ResultSet rs = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, birth);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				members = new Members();
				members.setId(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return members;
	}
	
}
