-- 회원정보
-- SCOTT_04계정에서 하도록
DROP TABLE jdbc_member_tbl;
CREATE TABLE jdbc_member_tbl(
	id				VARCHAR2(20)	PRIMARY KEY,
	password		VARCHAR2(20)	NOT NULL,
	gender          VARCHAR2(10),
	email			VARCHAR2(50)	UNIQUE,
	address         VARCHAR2(100)
);
--ALTER TABLE jdbc_member_tbl
--           MODIFY password VARCHAR2(20) NOT NULL;
DESC jdbc_member_tbl;

INSERT INTO jdbc_member_tbl(id, password, gender, email, address )
        VALUES('test', 't1234', '여성', 'test@gmail.com', '맨하튼');

SELECT * FROM jdbc_member_tbl;

SAVEPOINT insert_1; ----------- SESSION

UPDATE jdbc_member_tbl
        SET address = '파리 에펠탑'
 WHERE id = 'test';

SAVEPOINT update_1; ----------- SESSION

SELECT * FROM jdbc_member_tbl;

ROLLBACK TO insert_1;
ROLLBACK;
COMMIT;

UPDATE jdbc_member_tbl
        SET password = 'hong1234',
                gender = '중성',
                email = 'hong-kildong@gmail.com',
                address = '치앙마이'
WHERE id = 'hong';
COMMIT;

SELECT * FROM jdbc_member_tbl;

-- 책정보
SELECT * FROM tab;
CREATE TABLE jdbc_book_tbl(
    bookno      NUMBER(5)           PRIMARY KEY,
    title            VARCHAR2(60)     NOT NULL,
    author        VARCHAR2(60)     NOT NULL,
    price           NUMBER(8)           NOT NULL
);

--INSERT INTO jdbc_book_tbl -- (bookno, title, author, price)
--    VALUES (bookno, title, author, price);

SELECT * FROM jdbc_book_tbl;

INSERT INTO jdbc_member_tbl --(id, password, gender, email, address )
    VALUES ('hong', 1234, '남성', 'hong@naver.com', '서울시 강남구');
COMMIT;

