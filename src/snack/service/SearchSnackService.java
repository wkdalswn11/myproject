package snack.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider1;
import snack.dao.SnackDao;
import snack.model.Snack;

public class SearchSnackService {
	private SnackDao dao = new SnackDao();
	private int size = 10;
	
	public SnackPage getSnackPage2(int no , String searchField, String searchKeyword) {
		try (Connection con = ConnectionProvider1.getConnection()) {
			int total = dao.selectCount2(con, searchField, searchKeyword);
			List<Snack> content = dao.search(con, searchField, searchKeyword);
			
			return new SnackPage(total, no, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
