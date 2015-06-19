package book.dao;

import java.util.List;
import java.util.Map;

import book.dto.TestBook;

public interface BookDAO {

	/**
	 * test_book_origin 테이블의 건수를 limit로 잘라서 가져온다.
	 * @param map
	 * @return
	 */
	public List<TestBook> selectListTestBook(Map<String, Object> map);	
	
	/**
	 * sqlSession 을 반복처리하는 배치매소드 
	 * @param testBookList
	 */
	public void updateBatch1(List<TestBook> mapList);
	
	
	/**
	 * xml에서  foreach로 처리한 배치매소드 
	 * @param map
	 */
	public void updateBatch2(Map<String, Object> map);
	
	
	
	/**
	 * sqlSession 을 반복처리하는 배치매소드 
	 * @param testBookList
	 */
	public void insertBatch1(List<TestBook> mapList);
	
	
	/**
	 * xml에서  foreach로 처리한 배치매소드 
	 * @param map
	 */
	public void insertBatch2(Map<String, Object> map);	
	
	
}
