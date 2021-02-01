package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.model.Info;
import info.model.Writer;
import info.service.InfoData;
import jdbc.JdbcUtil;

public class InfoDao {

	public Info insert(Connection con, Info info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO info " + "(writer_id, writer_name, title, regdate, moddate, read_cnt, "
				+ "love, hate) " + "VALUES (?, ?, ?, SYSDATE, SYSDATE, 0, 0, 0) ";

		try {
			pstmt = con.prepareStatement(sql, new String[] { "info_no", "regdate", "moddate" });

			pstmt.setString(1, info.getWriter().getId());
			pstmt.setString(2, info.getWriter().getName());
			pstmt.setString(3, info.getTitle());

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				rs = pstmt.getGeneratedKeys();
				int key = 0;
				Date regdate = null;
				Date moddate = null;

				if (rs.next()) {
					key = rs.getInt(1);
					regdate = rs.getTimestamp(2);
					moddate = rs.getTimestamp(3);
				}

				return new Info(key, info.getWriter(), info.getTitle(), regdate, moddate, 0, 0, 0);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	public Info selectByid(Connection con, int no) throws SQLException {
		String sql = "SELECT * FROM info " + "WHERE info_no = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			Info info = null;
			if (rs.next()) {
				info = convertInfo(rs);
			}
			return info;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}

	}

	private Info convertInfo(ResultSet rs) throws SQLException {

		return new Info(rs.getInt("info_no"), new Writer(rs.getString("writer_id"), rs.getString("writer_name")),
				rs.getString("title"), rs.getTimestamp("regdate"), rs.getTimestamp("moddate"), rs.getInt("read_cnt"),
				rs.getInt("love"), rs.getInt("hate"));
	}

	public void increaseReadCount(Connection con, int infoNum) throws SQLException {
		
		String sql = "UPDATE info " + "SET read_cnt = read_cnt + 1 " + "WHERE info_no = ? ";
		
		
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, infoNum);
			pstmt.executeUpdate();
		}
		
		


	}

	public static int selectCount(Connection con) throws SQLException {

		String sql = "SELECT COUNT(*) FROM info ";

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		

		}finally {
			JdbcUtil.close(stmt, rs);
		}
	}

	public List<Info> select(Connection con, int pageNum, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT rn, info_no, writer_id, writer_name, title, regdate, moddate, "
				+ "read_cnt, love, hate "
				+ "FROM (SELECT info_no, writer_id, writer_name, title, regdate, moddate, "
				+ "read_cnt, love, hate, ROW_NUMBER() "
				+ "OVER (ORDER BY read_cnt DESC) rn FROM info ) "
				+ "WHERE rn BETWEEN ? AND ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1) * size + 1);
			pstmt.setInt(2, pageNum * size);
			rs = pstmt.executeQuery();
			List<Info> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertInfo(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		
	}

	public void increaseLoveCount(Connection con, int num) throws SQLException {
		String sql = "UPDATE info "
				+ "SET love = love + 1 "
				+ "WHERE info_no = ?";
		
			
			
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, num);
			
			  pstmt.executeUpdate();		
			}
		
		
	}
	
	public void selectLove(Connection con, int num) throws SQLException {
		String sql = "SELECT love FROM info WHERE info_no =? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		}
	}

	public int update(Connection con, Integer infoNo, String title) throws SQLException {
			String sql = "UPDATE info "
					+ "SET title = ?, moddate = SYSDATE "
					+ "WHERE info_no = ? ";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, title);
				pstmt.setInt(2, infoNo);
				
				int cnt = pstmt.executeUpdate();
				return cnt;
			}
	}

	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE info WHERE info_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
		
	}

	public List<Info> search(Connection con, String searchField, String searchKeyword) throws SQLException {
		String sql = "SELECT * FROM info "
				+ "WHERE UPPER("+ searchField +") LIKE UPPER('%"+searchKeyword+"%') "
						+ "ORDER BY read_cnt DESC";
		
			ResultSet rs = null;
			Statement stmt = null;
			List<Info> list = new ArrayList<>();
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					
					list.add(convertInfo(rs));
				}
				return list;
			} finally {
				JdbcUtil.close(rs, stmt);
			}
		
	}

	public int selectCount2(Connection con, String searchField, String searchKeyword) throws SQLException {
		String sql = "SELECT COUNT(*) FROM info "
				+ "WHERE "+ searchField +" LIKE '%"+searchKeyword+"%'";
		
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
				
			}
					
			
		} finally {
			JdbcUtil.close(stmt, rs);
		}
		return 0;
		
	}
	
}
