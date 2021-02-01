package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoContentDao;
import info.dao.InfoDao;
import info.dao.InfoSubDao;
import info.model.Info;
import info.model.InfoContent;

import jdbc.ConnectionProvider1;
import jdbc.JdbcUtil;

public class WriterInfoService {
	private InfoDao infoDao = new InfoDao();
	private InfoContentDao contentDao = new InfoContentDao();
	private InfoSubDao subDao = new InfoSubDao();
	
	
	public Integer write(WriteRequest req) {
		Connection con = null;
		
		
		try {
			con = ConnectionProvider1.getConnection();
			con.setAutoCommit(false);
			
			Info info = toInfo(req);
			Info savedInfo = infoDao.insert(con, info);
			
			if (savedInfo == null) {
				throw new RuntimeException("fail to insert Info");
			}
			
			InfoContent content = new InfoContent(
					savedInfo.getNumber(),
					req.getContent()
					);
			InfoContent savedContent = contentDao.insert(con, content);
			subDao.insert(con, content.getNumber());
			if (savedContent == null) {
				throw new RuntimeException("fali to insert info_content");
			}
			
			con.commit();
			
			return savedInfo.getNumber();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(con);
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}

	private Info toInfo(WriteRequest req) {
		
		return new Info(null, req.getWriter(), req.getTitle(), null, null, 0, 0, 0);
	}
}
