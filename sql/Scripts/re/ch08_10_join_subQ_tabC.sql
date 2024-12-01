//AI서비스_웹과정반 @19일차[오라클5일차]
/**! self-join
 * subQuery(single·multiple(IN) row, [ANY, SOME], ALL, EXISTS,
 * Scala(column), [WITH]inline-view(table))
 * DB 조작 = DDL(CREATE, DROP), DML(*), TCL(COMMIT, ROLLBACK)
 */
 -- 테이블이 존재하면 지운다.(자식부터)
DROP TABLE pages;
DROP TABLE posts;
DROP TABLE page_categories;

-- 페이지를 분류하는 테이블
DROP SEQUENCE seq_page_category;
CREATE SEQUENCE seq_page_category
                 MINVALUE 1
              START WITH 1
         INCREMENT BY 1
CACHE 999;

CREATE TABLE page_categories(
    category_id         NUMBER(3),
    category_name   VARCHAR2(45)    NOT NULL UNIQUE,
    CONSTRAINT page_categories_category_id_pk PRIMARY KEY(category_id)
);
-- 게시글 속성 테이블
DROP SEQUENCE seq_post;
CREATE SEQUENCE seq_post
                 MINVALUE 1
              START WITH 1
         INCREMENT BY 1
CACHE 999999999;

CREATE TABLE posts(
    posting_id      NUMBER(9),
    tags                VARCHAR2(400)     NOT NULL,
    CONSTRAINT posts_posting_id_pk PRIMARY KEY(posting_id)
);
-- 전체 페이지 테이블
DROP SEQUENCE seq_page;
CREATE SEQUENCE seq_page
                 MINVALUE 1
              START WITH 1
         INCREMENT BY 1
CACHE 99;

CREATE TABLE pages (
    page_id                  NUMBER(2)   PRIMARY KEY,
    category_id            NUMBER(3),
    posting_id              NUMBER(9),
    posting_name        VARCHAR2(255),
    posting_contents    VARCHAR2(4000),
    CONSTRAINT pages_category_id_fk FOREIGN KEY(category_id) REFERENCES page_categories(category_id),
    CONSTRAINT pages_posting_id_fk FOREIGN KEY(posting_id) REFERENCES posts(posting_id)
                ON DELETE CASCADE
);
SELECT * FROM tab;
SELECT * FROM seq;
//////까지 테이블 생성 //////////////////////////////////

INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'Java');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'SQL');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'HTML');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'React');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'JSP');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'Spring');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'Python');
INSERT INTO page_categories (category_id, category_name)
        VALUES (seq_page_category.NEXTVAL, 'Elasticsearch');

SELECT * FROM page_categories;
//////까지 카테고리 데이터 생성 //////////////////////////////////

INSERT INTO posts (posting_id, tags)
        VALUES (seq_post.NEXTVAL, '#싱글톤#복습#패턴');
INSERT INTO pages (page_id, category_id, posting_id, posting_name, posting_contents)
		VALUES (seq_page.NEXTVAL, 1, seq_post.CURRVAL, '싱글톤 복습', '싱글톤 패턴을 작성하는 방법은 이렇습니다.');
INSERT INTO posts (posting_id, tags)
        VALUES (seq_post.NEXTVAL, '#쿼리#복습');
INSERT INTO pages (page_id, category_id, posting_id, posting_name, posting_contents)
		VALUES (seq_page.NEXTVAL, 2, seq_post.CURRVAL, 'Join 복습', 'Join을 사용하는 방법은 이렇습니다.');

SELECT seq_post.CURRVAL FROM DUAL;

SELECT * FROM posts;
SELECT * FROM pages;

UPDATE pages
        SET page_id = 2
 WHERE posting_id = 2;

ROLLBACK;
COMMIT;
