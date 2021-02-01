package image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import image.model.Image;
import jdbc.JdbcUtil;

public class imageDao {

	public int getMaxNum(Connection con) {
		String sql = "SELECT nvl(max(num),0) FROM image";

		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				maxNum = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return maxNum;

	}

	public void insertData(Connection con, Image image) {
		String sql = "INSERT INTO image (num, subject, saveFileName) " + "VALUES (?,?,?)";

		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, image.getNum());
			pstmt.setString(2, image.getSubject());
			pstmt.setString(3, image.getSaveFileName());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public List<Image> getList(Connection con, int start, int end) {
		String sql = "SELECT * FROM (SELECT ROWNUM rnum,num,subject,saveFileName " + "FROM image ORDER BY num DESC) "
				+ "WHERE rnum >= ? and rnum <= ? ";

		List<Image> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Image image = new Image();
				image.setNum(rs.getInt("num"));
				image.setSubject(rs.getString("subject"));
				image.setSaveFileName(rs.getString("saveFileName"));
				list.add(image);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return list;
	}

	public Image getReadData(Connection con, int num) {
		String sql = "SELECT num,subject,saveFileName FROM image WHERE num = ? ";

		Image image = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				image = new Image();
				image.setNum(rs.getInt("num"));
				image.setSubject(rs.getString("subject"));
				image.setSaveFileName(rs.getString("saveFileName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return image;
	}

	public void deleteData(Connection con, int num) {
		String sql = "DELETE image WHERE num = ? ";

		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public int getDataCount(Connection con) {
		String sql = "SELECT nvl(count(*),0) FROM image ";
		int totalDataCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalDataCount = rs.getInt(1);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs,pstmt);
		}
		return totalDataCount;
	}
}












