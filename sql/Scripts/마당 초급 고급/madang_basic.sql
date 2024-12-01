-- 02. SQL 개요
-- 예) 김연아 고객의 전화번호를 찾으시오.
SELECT name		"이름"
	 , phone	"전화번호"
  FROM customer
 WHERE name='김연아';

-- [3.1.1 SELECT/FROM]
-- 3-1 모든 도서의 이름과 가격을 검색하시오.
SELECT bookname		"제목"
	 , price		"가격"
  FROM book;

-- (3-1 변형) 모든 도서의 가격과 이름을 검색하시오.
SELECT price		"가격"
	 , bookname		"제목"
  FROM book;

-- 3-2 모든 도서의 도서번호, 도서이름,출판사,가격을 검색하시오.
SELECT bookid		"도서번호"
	 , bookname		"제목"
	 , publisher	"출판사"
	 , price		"가격"
  FROM book;

-- 3-3 도서 테이블에 있는 모든 출판사를 검색하시오.
SELECT publisher	"출판사"
  FROM book;

-- [3.1.2 WHERE 조건]
-- 3-4 가격이 20,000원 미만인 도서를 검색하시오.
SELECT  *
  FROM book
 WHERE PRICE < 20000;

-- 3-5 가격이 10,000원 이상 20,000 이하인 도서를 검색하시오.
SELECT  *
  FROM book
 WHERE PRICE > 10000 AND PRICE < 20000;

-- 3-6 출판사가 '굿스포츠'혹은 '대한미디어'인 도서를 검색하시오.
SELECT *
  FROM book
 WHERE publisher IN ('굿스포츠', '대한미디어');

-- 3-7 '축구의 역사'를 출간한 출판사를 검색하시오.
SELECT publisher	"출판사"
	 , bookname		"제목"
  FROM book
 WHERE bookname = '축구의 역사';

-- 3-8 도서이름에 '축구'가 포함한 출판사를 검색하시오.
SELECT publisher	"출판사"
	 , bookname		"제목"
  FROM book
 WHERE bookname LIKE '%축구%'; 

-- 3-9 도서이름의 왼쪽 두 번째 위치에 '구'라는 문자열을 갖는 도서를 검색하시오.
SELECT *
  FROM book
 WHERE bookname LIKE '_구%'; 

-- 3-10 축구에 관한 도서 중 가격이 20,000원 이상인 도서를 검색하시오.
SELECT *
  FROM book
 WHERE bookname LIKE '%축구%'
   AND price >= 20000; 

-- 3-11 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색하시오.
SELECT *
  FROM book
 WHERE publisher IN ('굿스포츠', '대한미디어');

-- 3-12 도서를 이름순으로 검색하시오
SELECT *
  FROM book
 ORDER BY bookname;

-- 3-14 도서를 가격의 내림차순으로 검색하시오. 만약 가격이 같다면 출판사의 오름차순으로 검색한다.
SELECT *
  FROM book
 ORDER BY price DESC, publisher;

-- 3-15 고객이 주문한 도서의 총 판매액을 구하시오.
SELECT SUM(saleprice)	"총 판매액"
  FROM orders;

-- 3-16 2번 김연아 고객이 주문한 도서의 총 판매액을 구하시오.
SELECT custid			"김연아"
	 , SUM(saleprice)	"총 판매액"
  FROM orders
 WHERE custid='2'
GROUP BY custid;

-- 3-17 고객이 주문한 도서의 총판매액, 평균값, 최저가, 최고가를 구하시오
SELECT SUM(saleprice)	"총판매액"
	 , AVG(saleprice)	"평균값"
	 , MIN(saleprice)	"최저가"
	 , MAX(saleprice)	"최고가"
  FROM orders;

-- 3-18 마당서점의 도서 판매 건수를 구하시오.
SELECT COUNT(*)	"판매건수"
  FROM orders;

-- [3.2.2 GROUP BY]
-- 3-19 고객별로 주문한 도서의 총 수량과 총 판매액을 구하시오.
SELECT custid	"고객"
	 , COUNT(*)	"총 수량"
	 , SUM(saleprice)
  FROM orders
GROUP BY custid;

-- 3-20 가격이 8,000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총 수량을 구하시오. 단, 두권 이상 구매한 고객만 구한다.
SELECT custid			"고객"
	 , COUNT(*)			"총 수량"
	 , MIN(saleprice)	"최소구매"
  FROM orders
 WHERE saleprice >= 8000
GROUP BY custid
  HAVING COUNT(*) >= 2;

-- 3-21 고객과 고객의 주문에 관한 데이터를 모두 보이시오.
SELECT c.*
	 , o.*
  FROM orders	o
	 , customer	c
 WHERE o.custid = c.custid;

-- 3-22 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬하여 보이시오.
SELECT c.*
	 , o.*
  FROM orders	o
	 , customer	c
 WHERE o.custid = c.custid
ORDER BY o.custid;

-- 3-23 고객의 이름과 고객이 주문한 도서의 판매가격을 검색하시오.
SELECT c.name		"고객"
	 , o.saleprice	"판매가격"
  FROM orders	o
	 , customer	c
 WHERE o.custid = c.custid
ORDER BY o.custid;

-- 3-24 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬하시오.
SELECT c.name			"고객"
	 , SUM(o.saleprice)	"총 판매액"
  FROM orders	o
	 , customer	c
 WHERE o.custid = c.custid
GROUP BY c.name
ORDER BY c.name;

-- 3-25 고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
SELECT c.name			"이름"
	 , b.bookname		"제목"
  FROM orders	o
	 , book		b
	 , customer	c
 WHERE o.custid = c.custid
   AND o.bookid = b.bookid;

-- 3-26 가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오.
SELECT c.name			"고객"
	 , b.bookname		"제목"
  FROM orders	o
	 , book		b
	 , customer	c
 WHERE o.custid = c.custid
   AND o.bookid = b.bookid
   AND b.price = 20000;

-- 3-27 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격을 구하시오.
SELECT c.name		"고객"
	 , o.saleprice	"판매가격"
  FROM orders	o
	 , customer	c
 WHERE o.custid(+) = c.custid;

-- [3.3.2 부속질의]
-- 3-28 가장 비싼 도서의 이름을 보이시오.
SELECT bookname	"제목"
	 , price	"가격"
  FROM book
 WHERE price = (SELECT MAX(price)
 				  FROM book);

-- 3-29 도서를 구매한 적이 있는 고객의 이름을 검색하시오.
SELECT name		"고객"
  FROM customer
 WHERE custid IN (SELECT custid
 					FROM orders);
// no subquery
SELECT c.name	"고객"
  FROM customer	c
  	 , orders	o
 WHERE o.custid = c.custid
GROUP BY c.name
  HAVING COUNT(o.custid) > 0;

-- 3-30 대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오.
SELECT c.name		"이름"
  FROM customer c
 	 , orders	o
 WHERE o.custid = c.custid
   AND o.bookid IN (SELECT o.bookid
   					  FROM orders	o
   					     , book		b
				     WHERE o.bookid = b.bookid
				       AND b.publisher = '대한미디어');

-- 3-31 출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오.
-- 상관 부속질의, 서브쿼리가 독립적이지 않고, 서로 연관되어있음.
SELECT bexp.bookname	"제목"
  FROM book bexp
 WHERE bexp.price > (SELECT AVG(bavg.price)
 					 FROM book bavg
 					WHERE bavg.publisher = bexp.publisher);

-- [3.3.3 집합연산]
-- 3-32 도서를 주문하지 않은 고객의 이름을 보이시오.
SELECT name			"고객"
  FROM customer
MINUS
SELECT name
  FROM customer
 WHERE custid IN (SELECT custid
 					FROM orders);

-- [3.3.4 EXISTS]
-- 3-33 주문이 있는 고객의 이름과 주소를 보이시오.
SELECT name		"고객"
	 , address	"주소"
  FROM customer c
 WHERE EXISTS(SELECT *
 				FROM orders o
 			   WHERE c.custid = o.custid);

-- [4.1 CREATE 문]
-- 3-34 다음과 같은 속성을 가진 NewBook 테이블을 생성하시오. 정수형은 NUMBER를, 문자형은 가변형 문자타입인 VARCHAR2를 사용한다.
DROP TABLE newbook;
CREATE TABLE newbook(
	bookid		NUMBER			PRIMARY KEY,
	bookname	VARCHAR2(20)	NOT NULL,
	publisher	VARCHAR2(20)	UNIQUE,
	price		NUMBER			DEFAULT 10000 CHECK(price > 1000)
);

-- 3-35 다음과 같은 속성을 가진 NewCustomer 테이블을 생성하시오.
DROP TABLE newcustomer;
CREATE TABLE newcustomer(
	custid		NUMBER		PRIMARY KEY,
	name		VARCHAR2(40),
	address		VARCHAR2(40),
	phone		VARCHAR2(30)
);

-- 3-36 다음과 같은 속성을 가진 NewOrders 테이블을 생성하시오.
DROP TABLE neworders;
CREATE TABLE neworders(
	orderid		NUMBER,
	custid		NUMBER	NOT NULL,
	bookid		NUMBER	NOT NULL,
	saleprice	NUMBER,
	orderdate	DATE,
	PRIMARY KEY(orderid),
	FOREIGN KEY(custid) REFERENCES newcustomer(custid)
		ON DELETE CASCADE
);

-- [4.2 ALTER문]
-- 3-37 NewBook 테이블에 VARCHAR2(13)의 자료형을 가진 isbn 속성을 추가하시오.
ALTER TABLE newbook
  ADD isbn	VARCHAR2(13);

-- 3-38 NewBook 테이블의 isbn 속성의 데이터 타입을 NUMBER형으로 변경하시오.
ALTER TABLE newbook
MODIFY isbn NUMBER;

-- 3-39 NewBook 테이블의 isbn 속성을 삭제하시오.
ALTER TABLE newbook
 DROP COLUMN isbn;

-- 3-40 NewBook 테이블의 bookid 속성에 NOT NULL 제약조건을 적용하시오.
ALTER TABLE newbook
MODIFY bookid NUMBER NOT NULL;

-- 3-41 NewBook 테이블의 bookid 속성을 기본키로 변경하시오.
ALTER TABLE newbook
  ADD PRIMARY KEY(bookid);

-- [4.3 DROP 문]
-- 3-42 NewBook 테이블을 삭제하시오.
DROP TABLE newbook;

-- 3-43 NewCustomer 테이블을 삭제하시오. 만약 삭제가 거절된다면 원인을 파악하고 관련된 테이블을 같이 삭제하시오(NewOrders 테이블이 NewCustomer를 참조하고 있음).
DROP TABLE neworders; /* FK:custid */
DROP TABLE newcustomer; /* PK:custid */

purge recyclebin;
