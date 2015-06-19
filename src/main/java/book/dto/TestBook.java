package book.dto;

import java.io.Serializable;

/**
 * 테이블 : test_book, sell_test_book_novel, sell_test_book_business, sell_test_book_art 테이블 엔티티 
 * @author ykkim
 *
 */
@SuppressWarnings("serial")
public class TestBook implements Serializable {
	
	private int bookID;				//고유키
	private String bookName;	//책명	
	private String bookAuthor;	//작가
	private String bookType;	//1: 소설, 2: 비즈니스, 3: 예술
	private double originPrice;	//원래가격
	private double sellPrice;		//팔가격 
	private String processYN;	//처리여부 : 해당되는 테이블로 처리되면 Y 
	private String registDate;	//등록일 
	private String bookTable;	//결과에 넣을 테이블명 
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public double getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getProcessYN() {
		return processYN;
	}
	public void setProcessYN(String processYN) {
		this.processYN = processYN;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getBookTable() {
		return bookTable;
	}
	public void setBookTable(String bookTable) {
		this.bookTable = bookTable;
	}	
	
}
