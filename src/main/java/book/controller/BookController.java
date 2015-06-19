package book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import book.dto.TestBook;
import book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookSerive;

	
	/**
	 * 배치업데이트 
	 * @param batchType
	 */
	public void executeUpdateBatch(String batchType) {
		List<TestBook> list = null;
		Map<String, Object> map = null;
		int start = 0;
		final int LIMIT = 500;
		Map<String, Object> paramMap = null;
		
		try {
			while (true) {
				map = new HashMap<String, Object>();
				map.put("start", start);
				map.put("limit", LIMIT);
				list = bookSerive.selectListTestBook(map);
				start += list.size();
				
				//더이상 가져올 것이 없다면 빠져나간다. 
				if (list == null || list.size() == 0) {
					System.out.println("All finished");
					break;
				} 
				//sqlSession 배치라면 
				if (batchType.equals("1")) {
					bookSerive.updateBatch1(list);
				} 
				//xml의 foreach  배치라면 
				else if (batchType.equals("2")) {
					paramMap = new HashMap<String, Object>();
					paramMap.put("list", list);
					bookSerive.updateBatch2(paramMap);
				}				
			} //end while 							
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (list != null) list.clear();
		}		
	}
	
	/**
	 * 배치인서트  
	 * @param batchType
	 */
	public void executeInsertBatch(String batchType) {
		List<TestBook> list = null;
		Map<String, Object> map = null;
		int start = 0;
		final int LIMIT = 500;
		Map<String, Object> paramMap = null;
		
		try {
			while (true) {
				map = new HashMap<String, Object>();
				map.put("start", start);
				map.put("limit", LIMIT);
				list = bookSerive.selectListTestBook(map);
				start += list.size();
				
				//더이상 가져올 것이 없다면 빠져나간다. 
				if (list == null || list.size() == 0) {
					System.out.println("All finished");
					break;
				} 
				//sqlSession 배치라면 
				if (batchType.equals("1")) {
					bookSerive.insertBatch1(list);
				} 
				//xml의 foreach  배치라면 
				else if (batchType.equals("2")) {
					paramMap = new HashMap<String, Object>();
					paramMap.put("list", list);
					bookSerive.insertBatch2(paramMap);
				}				
			} //end while 							
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (list != null) list.clear();
		}		
	}
	
}
 