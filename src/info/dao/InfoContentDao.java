package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.model.InfoContent;
import jdbc.JdbcUtil;

public class InfoContentDao {

	public InfoContent insert(Connection con, InfoContent content) throws SQLException {
		String sql = "INSERT INTO info_content " + "(info_no, content) VALUES (? , ?) ";

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
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public InfoContent selectByid(Connection con, int infoNum) throws SQLException {
		String sql = "SELECT * FROM info_content WHERE info_no = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, infoNum);

			rs = pstmt.executeQuery();
			InfoContent content = null;
			if (rs.next()) {
				content = new InfoContent(rs.getInt("info_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}

	}

	public int Update(Connection con, Integer infoNo, String content) throws SQLException {
		String sql = "UPDATE info_content "
				+ "SET content = ? "
				+ "WHERE info_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, content);
			pstmt.setInt(2, infoNo);
			
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		}
		
		
	}

	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE info_content WHERE info_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
		
	}

}
