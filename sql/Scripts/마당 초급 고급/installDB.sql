CREATE USER madang IDENTIFIED BY madang DEFAULT TABLESPACE users;

GRANT CONNECT, resource, CREATE view, CREATE SESSION TO madang;

ALTER USER madang account UNLOCK;

-- 책
-- 테이블 생성
-- CREATE TABLE 테이블명(
--    컬럼명     데이터타입(크기) PRIMARY KEY, -- 중복(X), NOT NULL
--);
drop table Book; /* 부모 child:Orders */
drop table Customer; /* 부모 child:Orders */
drop table Orders; /* 자식:Parents */

/* 부모 child:Orders, Imported_Book */
CREATE TABLE Book(
  bookid    NUMBER(2) PRIMARY KEY,
  bookname  VARCHAR2(40),
  publisher VARCHAR2(40),
  price     NUMBER(8)
);

/* 부모 child:Orders */
CREATE TABLE Customer(
  custid  NUMBER(2) PRIMARY KEY,
  name    VARCHAR2(40),
  address  VARCHAR2(50),
  phone    VARCHAR2(20)
);

/* 자식: parent:Book */
CREATE TABLE Orders(
  orderid NUMBER(2) PRIMARY KEY,
  custid  NUMBER(2) REFERENCES Customer(custid),
  bookid  NUMBER(2) REFERENCES Book(bookid),
  saleprice NUMBER(8),
  orderdate DATE
);

CREATE TABLE Imported_Book (
  bookid    NUMBER,
  bookname  VARCHAR2(40),
  publisher VARCHAR2(40),
  price     NUMBER(8)
);



-- INSERT INTO 테이블명(컬럼1, 컬럼2,...컬럼n)
-- VALUES(val1, val2..valn);
/* Book, Customer, Orders 데이터 생성 */
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (2, '축구아는 여자', '나무수', 13000);  
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (3, '축구의 이해', '대한미디어', 22000);    
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (4, '골프바이블', '대한미디어', 35000); 
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (5, '피겨교본', '굿스포츠', 8000); 
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (6, '역도 단계별기술', '굿스포츠', 6000); 
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (7, '야구의 추억', '이상미디어', 20000);   
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (8, '야구를 부탁해', '이상미디어', 13000); 
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (9, '올림픽 이야기', '삼성당', 7500); 
INSERT INTO Book (bookid, bookname, publisher, price)
  VALUES (10, 'Olympic Champions', 'Person', 13000);   

  
INSERT INTO Customer (custid, name, address, phone)
  VALUES(1, '박지성', '영국 멘체스터', '000-5000-0001');  
INSERT INTO Customer (custid, name, address, phone)
  VALUES(2, '김연아', '대한민국 서울', '000-6000-0001');
INSERT INTO Customer (custid, name, address, phone)
  VALUES(3, '장미란', '대한민국 강원도', '000-7000-0001');  
INSERT INTO Customer (custid, name, address, phone)
  VALUES(4, '추신수', '미국 클리브랜드', '000-8000-0001');
INSERT INTO Customer (custid, name, address, phone)
  VALUES(5, '박세리', '대한민국 대전', NULL);  
  
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(1,1,1,6000,TO_DATE('2014-07-01', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(2,1,3,21000,TO_DATE('2014-07-03', 'yyyy-mm-dd'));  
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(3,2,5,8000,TO_DATE('2014-07-03', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(4,3,6,6000,TO_DATE('2014-07-04', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(5,4,7,20000,TO_DATE('2014-07-05', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(6,1,2,12000,TO_DATE('2014-07-07', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(7,4,8,13000,TO_DATE('2014-07-07', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(8,3,10,12000,TO_DATE('2014-07-08', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(9,2,10,7000,TO_DATE('2014-07-09', 'yyyy-mm-dd'));
INSERT INTO ORDERS (orderid, custid, bookid, saleprice, orderdate)
  VALUES(10,3,8,13000,TO_DATE('2014-07-10', 'yyyy-mm-dd'));  

INSERT INTO Imported_Book VALUES(21, 'Zen Golf', 'Person', 12000);
INSERT INTO Imported_Book VALUES(22, 'Soccer Skills', 'Human Kinetics', 15000);
COMMIT; 

-- SELECT *
--   FROM Book;

-- SELECT *
--   FROM Customer;

-- SELECT *
--   FROM ORDERS;  

-- SELECT *
--   FROM Imported_Book;  
