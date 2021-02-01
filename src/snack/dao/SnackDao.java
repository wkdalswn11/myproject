package snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.model.Writer;
import jdbc.JdbcUtil;
import snack.model.Snack;

public class SnackDao {

	public int selectCount(Connection con) throws SQLException {
		String sql = "SELECT COUNT(*) FROM snack ";

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs, stmt);
		}

	}

	public List<Snack> select(Connection con, int pageNum, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT rn, snack_no, writer_id, writer_name, title, regdate, " + "moddate, read_cnt, good, hate "
				+ "FROM (SELECT snack_no, writer_id, writer_name, title, regdate, " + "moddate, read_cnt, good, hate, ROW_NUMBER() "
				+ "OVER (ORDER BY good - hate DESC) rn FROM snack ) WHERE rn BETWEEN ? AND ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (pageNum - 1) * size + 1);
			pstmt.setInt(2, pageNum * size);
			rs = pstmt.executeQuery();
			List<Snack> list = new ArrayList<>();
			while (rs.next()) {
				list.add(convertSnack(rs));
			}
			return list;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}

	}

	private Snack convertSnack(ResultSet rs) throws SQLException {
		return new Snack(rs.getInt("snack_no"),
				new Writer(
						rs.getString("writer_id"),
						rs.getString("writer_name")),
				rs.getString("title"),
				rs.getTimestamp("regdate"),
				rs.getTimestamp("moddate"),
				rs.getInt("read_cnt"),
				rs.getInt("good"),
				rs.getInt("hate"));
	}

	public Snack insert(Connection con, Snack snack) throws SQLException {
		String sql = "INSERT INTO snack "
				+ "(writer_id, writer_name, title, regdate, moddate, read_cnt, good, hate) "
				+ "VALUES (?, ?, ?, SYSDATE, SYSDATE, 0, 0 , 0) ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql, new String[] {"snack_no", "regdate", "moddate"});
			
			pstmt.setString(1, snack.getWriter().getId());
			pstmt.setString(2, snack.getWriter().getName());
			pstmt.setString(3, snack.getTitle());
			
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
				
				return new Snack(key, snack.getWriter(), snack.getTitle(), regdate, moddate,0,0,0 );
			} else {
				return null;
			} 
				
		}finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	public Snack selectByid(Connection con, int snackNum) throws SQLException {
		String sql = "SELECT * FROM snack WHERE snack_no = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, snackNum);
			
			rs = pstmt.executeQuery();
			
			Snack snack = null;
			if (rs.next()) {
				snack = convertSnack(rs);
			}
			return snack;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		
	}

	public void increaseReadCnt(Connection con, int snackNum) throws SQLException {
		String sql = "UPDATE snack "
				+ "SET read_cnt = read_cnt + 1 "
				+ "WHERE snack_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, snackNum);
			pstmt.executeUpdate();
		}
		
	}

	public Snack selectGood(Connection con, int snackNum) throws SQLException {
		String sql = "SELECT * FROM snack "
				+ "WHERE snack_no = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, snackNum);
			
			rs = pstmt.executeQuery();
			Snack snack = null;
			if (rs.next()) {
				snack = convertSnack(rs);
			}
			return snack;
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		
	}

	public void goodAdd(Connection con, int snackNum) throws SQLException {
		String sql = "UPDATE snack "
				+ "SET good = good + 1 "
				+ "WHERE snack_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, snackNum);
			
			pstmt.executeUpdate();
		}
		
	}

	public void hateAdd(Connection con, int snackNum) throws SQLException {
		String sql = "UPDATE snack "
				+ "SET hate = hate + 1 "
				+ "WHERE snack_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, snackNum);
			
			pstmt.executeUpdate();
		}
	}

	public void update(Connection con, Integer snackNo, String title) throws SQLException {
		String sql = "UPDATE snack "
				+ "SET title = ? , moddate = SYSDATE "
				+ "WHERE snack_no = ? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setInt(2, snackNo);
			
			pstmt.executeUpdate();
		}
	}

	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE snack WHERE snack_no = ? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
		
	}

	public int selectCount2(Connection con, String searchField, String searchKeyword) throws SQLException {
		String sql = "SELECT COUNT(*) FROM snack "
				+ "WHERE " + searchField +" LIKE '%" + searchKeyword + "%'";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(stmt, rs);
		}
		return 0;
	}

	public List<Snack> search(Connection con, String searchField, String searchKeyword) throws SQLException {
		String sql = "SELECT * FROM snack "
				+ "WHERE UPPER(" + searchField + ") LIKE UPPER('%" + searchKeyword + "%') "
						+ "ORDER BY good - hate DESC ";
		
		ResultSet rs = null;
		Statement stmt = null;
		List<Snack> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(convertSnack(rs));
			}
			return list;
		} finally {
			JdbcUtil.close(rs, stmt);
		}
		
	}

	

}












