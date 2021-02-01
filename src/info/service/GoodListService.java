package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import info.dao.InfoSubDao;
import info.model.InfoSub;
import jdbc.ConnectionProvider1;

public class GoodListService {
	private InfoSubDao infoSubDao = new InfoSubDao();
	
	/*public List<InfoSub> getGoodList(int infoNum) {
		Connection con = ConnectionProvider1.getConnection();
		
		List<InfoSub> list;
		try {
			list = infoSubDao.listInfoSub(con, infoNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	} */
}
