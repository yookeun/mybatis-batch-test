#mybatis-batch-test


1. 배경
----------------------

mybatis에서 Sqlsession의 배치처리와 xml의 foreach로 배치처리하는 방법 


**mybatis-batch-test에 적용된 기술은 다음과 같습니다.**

사용된 오픈소스|버전
------------|---
java|1.7
spring|4.1.5
gradle|2.2.1
mybatis|3.2.8


2. 기능설명
-----------------
mybatis-batch-test는 test_book테이블에 10만건의 책들이 쌓여 있습니다.

**test_book**

컬럼명|타입|용도
-----|---|---
bookID|INT|고유키
bookName|VARCHAR(100)|제목
originPrice|DOUBLE|책원가
registDate|DATETIME|입력날짜
----------------

test_book_backup : test_book의 백업테이블 

**test_book_backup**

컬럼명|타입|용도
-----|---|---
backID|INT|고유키
bookID|INT|test_book.bookID
bookName|VARCHAR(100)|제목
originPrice|DOUBLE|책원가
registDate|DATETIME|입력날짜
----------------

3. 실행방법
----------------
eclipe에 gradle plug-in이 사전에 설치되어 있어야 합니다. 
eclipse에서 import > Gradle > Gradle Project 를 통해서 생성하면 됩니다. 

src/main/resource/installTable.sql 에 생성테이블과 실행프로시저가 있으니 테이블을 만들고 프로시저를 실행하고 나서 
BatchTestMain 에서 각각의 용도이 메소드를 주석을 해제한후에 실행하면 됩니다.

**아래 주석을 풀면서 테스트할 수 있음**

sqlSession 업데이트 배치 처리 (test_book.originPrice를 0으로 업데이트)
> //main.executeUpdateBatch("1"); 

foreach 업데이트 배치 처리 (test_book.originPrice를 0으로 업데이트)
> //main.executeUpdateBatch("2");
		
sqlSession 인서트 배치 처리 (test_book의 모든 레코드를 test_book_backup으로 인서트)
> //main.executeInsertBatch("1");
		
foreach 인서트  배치 처리 (test_book의 모든 레코드를 test_book_backup으로 인서트)
> //main.executeInsertBatch("2");

