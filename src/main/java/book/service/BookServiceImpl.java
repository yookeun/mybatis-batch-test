package book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.dao.BookDAO;
import book.dto.TestBook;

@Service
public class BookServiceImpl  implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	@Override
	public List<TestBook> selectListTestBook(Map<String, Object> map) {		
		return bookDAO.selectListTestBook(map);
	}

	@Override
	public void updateBatch1(List<TestBook> list) {
		bookDAO.updateBatch1(list);
	}

	@Override
	public void updateBatch2(Map<String, Object> map) {
		bookDAO.updateBatch2(map);
	}	

	@Override
	public void insertBatch1(List<TestBook> list) {
		bookDAO.insertBatch1(list);
	}

	@Override
	public void insertBatch2(Map<String, Object> map) {
		bookDAO.insertBatch2(map);
	}	
}
