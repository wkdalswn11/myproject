package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import info.model.InfoSub;
import jdbc.JdbcUtil;

public class InfoSubDao {
	
	public void hateAdd(Connection con, int infoNum) throws SQLException {
		String sql = "UPDATE info_sub "
				+ "SET hate = hate + 1 "
				+ "WHERE info_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, infoNum);
			
			pstmt.executeUpdate();
		}
	}

	public void goodAdd(Connection con, int infoNum) throws SQLException {
		String sql = "UPDATE info_sub "
				+ "SET good = good+1 "
				+ "WHERE info_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, infoNum);
			
			pstmt.executeUpdate();
		}
		
	}
	
	public void insert(Connection con, int good) throws SQLException {
		String sql = "INSERT INTO info_sub "
				+ "(info_no , good, hate) "
				+ "VALUES (?, 0, 0) ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, good);
			
			pstmt.executeUpdate();
		}
	}

	/*
	 * public List<InfoSub> listInfoSub(Connection con, int infoNum) throws
	 * SQLException { String sql = "SELECT info_no, good, hate " + "FROM Info_sub "
	 * + "WHERE info_no = ? ";
	 * 
	 * List<InfoSub> list = new ArrayList<>();
	 * 
	 * try (PreparedStatement pstmt = con.prepareStatement(sql)) { pstmt.setInt(1,
	 * infoNum);
	 * 
	 * ResultSet rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { InfoSub s = new InfoSub(); s.setId(rs.getInt(1));
	 * s.setGood(rs.getInt(2)); s.setHate(rs.getInt(3));
	 * 
	 * list.add(s); } } return list; }
	 */
	public InfoSub selectHate(Connection con, int infoNum) throws SQLException {
		String sql = "SELECT * FROM info_sub "
				+ "WHERE info_no = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
	try  { 
		pstmt = con.prepareStatement(sql) ;
		pstmt.setInt(1, infoNum);
		
		rs = pstmt.executeQuery();
		InfoSub sub = null;
		if (rs.next()) {
			sub = convertSub(rs);
		}
		return sub;
		
		
		
	} finally {
		JdbcUtil.close(rs, pstmt);
	}
		
	}
	
	public InfoSub selectGood(Connection con, int infoNum) throws SQLException {
		String sql = "SELECT * FROM info_sub "
				+ "WHERE info_no = ? ";
		PreparedStatement pstmt = null;
			ResultSet rs = null;
		
		try  { 
			pstmt = con.prepareStatement(sql) ;
			pstmt.setInt(1, infoNum);
			
			rs = pstmt.executeQuery();
			InfoSub sub = null;
			if (rs.next()) {
				sub = convertSub(rs);
			}
			return sub;
			
			
			
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
	}

	private InfoSub convertSub(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new InfoSub(rs.getInt("info_no"),
				rs.getInt("good"),
				rs.getInt("hate"));
	}

	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE info_sub WHERE info_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
		
	}

	
	
	
}
