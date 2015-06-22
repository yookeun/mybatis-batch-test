
/*
 *  책 테이블 
 */
CREATE TABLE test_book
(
	bookID INT NOT NULL  AUTO_INCREMENT,
	bookName VARCHAR(100) NOT NULL,
	originPrice DOUBLE NOT NULL,	
	registDate DATETIME NOT NULL,
	PRIMARY KEY(bookID)	
);

/** 
 * test_book 백업테이블 
 */
CREATE TABLE test_book_backup
(
	backID INT NOT NULL AUTO_INCREMENT,
	bookID INT NOT NULL ,
	bookName VARCHAR(100) NOT NULL,
	originPrice DOUBLE NOT NULL,	
	registDate DATETIME NOT NULL,
	PRIMARY KEY(backID),
	INDEX(bookID)
);

/**
 * 인서트 프로시저 
 */
DELIMITER $$
DROP PROCEDURE IF EXISTS INSERT_TEST_BOOK$$
CREATE PROCEDURE INSERT_TEST_BOOK(in _count INT, originPrice double)
BEGIN	
	DECLARE x INT;	
	SET x = 1;
	WHILE x <= _count DO		
		INSERT INTO test_book(bookName,  originPrice,  registDate) 
		VALUE(concat("a","-",x),  originPrice, NOW());
		SET x = x + 1;
    END WHILE;
	SELECT COUNT(*) FROM test_book;
END$$
DELIMITER ;


#10만건 입력 
CALL INSERT_TEST_BOOK(100000,  1000);


