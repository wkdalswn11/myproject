package snack.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider1;

import snack.dao.SnackDao;
import snack.model.Snack;

public class ListSnackService {
	private SnackDao dao = new SnackDao();
	private int size = 10;
	
	public SnackPage getSnackPage(int pageNum) throws SQLException  {
		try (Connection con = ConnectionProvider1.getConnection()) {
			int total = dao.selectCount(con);
			List<Snack> content = dao.select(con, pageNum, size);
			
			return new SnackPage(total, pageNum, size, content);		
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}
