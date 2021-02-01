package snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import snack.model.SnackContent;

public class SnackContentDao {

	public SnackContent insert(Connection con, SnackContent content) throws SQLException {
		String sql = "INSERT INTO snack_content "
				+ "(snack_no, content) "
				+ "VALUES (?, ?) ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				return content;
			} else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}

	public SnackContent selectByid(Connection con, int snackNum) throws SQLException {
		String sql = "SELECT * FROM snack_content WHERE snack_no = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, snackNum);
			
			rs = pstmt.executeQuery();
			SnackContent content = null;
			if(rs.next()) {
				content = new SnackContent(rs.getInt("snack_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
				
	}

	public void update(Connection con, Integer snackNo, String content) throws SQLException {
		String sql = "UPDATE snack_content "
				+ "SET content = ? "
				+ "WHERE snack_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, content);
			pstmt.setInt(2, snackNo);
			
			pstmt.executeUpdate();
		}
		
	}

	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE snack_content WHERE snack_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
		
	}

}













