package book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book.dto.TestBook;


@Component
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TestBook> selectListTestBook(Map<String, Object> map) {		
		return sqlSession.selectList("TestBook.selectListTestBook", map);
	}

	@Override
	public void updateBatch1(List<TestBook> list) {
		for (TestBook testBook : list) {
			sqlSession.update("TestBook.updateBatch1", testBook);
		}		
	}

	@Override
	public void updateBatch2(Map<String, Object> map) {
		sqlSession.update("TestBook.updateBatch2", map);
	}

	@Override
	public void insertBatch1(List<TestBook> list) {
		for (TestBook testBook : list) {
			sqlSession.update("TestBook.insertBatch1", testBook);
		}		
	}

	@Override
	public void insertBatch2(Map<String, Object> map) {
		sqlSession.update("TestBook.insertBatch2", map);
	}
	
}
