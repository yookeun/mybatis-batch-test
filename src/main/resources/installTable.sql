
/*
 * 창고에 있는 책들 
 * bookType = 1: 소설, 2: 비즈니스, 3: 예술
 * processYN = 레코드 처리여부 (Y: 처리됨, N: 미처리)
 */
CREATE TABLE test_book_origin
(
	bookID INT NOT NULL  AUTO_INCREMENT,
	bookName VARCHAR(100) NOT NULL,
	bookAuthor VARCHAR(20) NOT NULL,
	bookType CHAR(1) NOT NULL, 
	originPrice DOUBLE NOT NULL,
	processYN CHAR(1) NOT NULL DEFAULT 'N',
	registDate DATETIME NOT NULL,
	PRIMARY KEY(bookID),
	INDEX(processYN,bookType)
);

/** 
 * test_book_origin 백업테이블 
 */
CREATE TABLE test_book_orign_backup
(
	bookID INT NOT NULL,
	bookName VARCHAR(100) NOT NULL,
	bookAuthor VARCHAR(20) NOT NULL,
	bookType CHAR(1) NOT NULL, 
	originPrice DOUBLE NOT NULL,
	processYN CHAR(1) NOT NULL DEFAULT 'N',
	registDate DATETIME NOT NULL,
	PRIMARY KEY(bookID),
	INDEX(processYN,bookType)
);

/**
 * 인서트 프로시저 
 */
DELIMITER $$
DROP PROCEDURE IF EXISTS INSERT_TEST_BOOK_ORIGIN$$
CREATE PROCEDURE INSERT_TEST_BOOK_ORIGIN(in _count INT, in _bookType CHAR, in _originPrice double)
BEGIN	
	DECLARE x INT;	
	SET x = 1;
	WHILE x <= _count DO		
		INSERT INTO test_book_origin(bookName, bookAuthor, bookType, originPrice, processYN,  registDate) 
		VALUE(concat("a","-",x), concat("p",""+x), _bookType, _originPrice, 'N', NOW());
		SET x = x + 1;
    END WHILE;
	SELECT COUNT(*) FROM test_book_origin;
END$$
DELIMITER ;


#10만건 씩 (소설)
#CALL INSERT_TEST_BOOK_ORIGIN(100000, '1', 1000);

#10만건 씩 (비즈니스)
#CALL INSERT_TEST_BOOK_ORIGIN(100000, '2', 2000);

#10만건 씩 (예술)
#CALL INSERT_TEST_BOOK_ORIGIN(100000, '3', 2000);


