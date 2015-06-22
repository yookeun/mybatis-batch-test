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
	private double originPrice;	//원래가격	
	private String registDate;	//등록일	 
	
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
	
	public double getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}
	
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}	
	
}
