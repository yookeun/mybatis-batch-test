package book.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import book.controller.BookController;


@Component
@SuppressWarnings("resource")
public class BatchTestMain {

	private static final String[] SPRING_CONFIG_XML = new String[] {"applicationContext.xml"};	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML);		
		BatchTestMain main = ctx.getBean(BatchTestMain.class);
		
		// sqlSession 배치 처리 
		//main.executeUpdateBatch("1");
		//main.executeInsertBatch("1");
		
		//foreach 배치 처리 
		//main.executeUpdateBatch("2");		
		main.executeInsertBatch("2");
	}
	
	@Autowired
	private BookController bookController;
	
	
	/**
	 * 배치처리 시작 
	 * @param batchType
	 */
	private void executeUpdateBatch(String batchType) {
		long startTime = System.currentTimeMillis();	
		bookController.executeUpdateBatch(batchType);
		long endTime = System.currentTimeMillis();	
		long resutTime = endTime - startTime;
		String batchTypeDesc = "";
		if (batchType.equals("1")) {
			batchTypeDesc = "[sqlSession batch]";
		} else {
			batchTypeDesc = "[foreach batch]";
		}		
		System.out.println(batchTypeDesc + " 소요시간  : " + resutTime/1000 + "(ms)");
	}

	/**
	 * 배치처리 시작 
	 * @param batchType
	 */
	private void executeInsertBatch(String batchType) {
		long startTime = System.currentTimeMillis();	
		bookController.executeInsertBatch(batchType);
		long endTime = System.currentTimeMillis();	
		long resutTime = endTime - startTime;
		String batchTypeDesc = "";
		if (batchType.equals("1")) {
			batchTypeDesc = "[sqlSession batch]";
		} else {
			batchTypeDesc = "[foreach batch]";
		}		
		System.out.println(batchTypeDesc + " 소요시간  : " + resutTime/1000 + "(ms)");
	}

}
