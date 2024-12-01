//AI서비스_웹과정반 @20일차[오라클6일차]
/**!
 * 제약 조건명 검색,
 * Table(
 * 		duplicate+{[structure], [data]},
 * 		ALTER(ADD, 'RENAME [COLUMN-]TO', MODIFY, DROP COLUMN)
 * 		RENAME, TRUNCATE, DROP
 * ),
 * Transaction(SAVEPOINT 'label', ROLLBACK [TO 'label']),
 * Data_Dictionary(
 * 		'DBAlias'(USER, ALL, DBA)_'dictName'(SEQUENCES, INDEXEDS, INDEXES, VIEWS, TABLES)
 * ),
 * INDEX(COMMON, UNIQUE, COMPOSITE, function-based),
 * SEQUENCE('seqName'.NEXTVAL, 'seqName'.CURRVAL)
 */
SELECT constraint_name
             , constraint_type
             , table_name
    FROM sys.user_constraints
 WHERE table_name IN ('POSTS', 'PAGE_CATEGORIES', 'PAGES');

CREATE TABLE posts_copy
          AS SELECT * FROM posts;

DESC posts_copy;
SELECT * FROM posts_copy;

CREATE TABLE pages_copy
          AS SELECT * FROM pages
                WHERE 0=1; /* 구조복사 */
INSERT INTO pages_copy
    SELECT * FROM pages; /* 데이터복사 */

ALTER TABLE pages_copy /* 컬럼추가 */
    ADD edit_date DATE DEFAULT sysdate;

SELECT * FROM pages_copy;

ALTER TABLE pages_copy
    RENAME COLUMN edit_date TO when_edit;

ALTER TABLE pages_copy
    MODIFY posting_name    VARCHAR2(80);
DESC pages_copy;

ALTER TABLE pages_copy
    DROP COLUMN when_edit;
SELECT * FROM pages_copy;

RENAME pages_copy TO pages_ccopy;
SELECT * FROM pages_copy; -- 없다.
SELECT * FROM pages_ccopy; -- 있다.

TRUNCATE TABLE pages_ccopy;
SELECT * FROM pages_ccopy; -- 있다.

DROP TABLE pages_ccopy; -- 있다.
SELECT * FROM pages_ccopy; -- 있다.

-- 1.
UPDATE posts_copy
        SET tags = '#DTO#DAO'
 WHERE posting_id = 1;

SAVEPOINT s1;

-- 2. 101번 삭제
DELETE FROM posts_copy
 WHERE posting_id = 1;

SAVEPOINT s2;

-- 3. 102번 삭제
DELETE FROM posts_copy
 WHERE posting_id = 2;

SAVEPOINT s3;

SELECT * FROM posts_copy;
ROLLBACK TO s1;
SELECT * FROM posts_copy;


INSERT INTO posts (posting_id, tags)
        VALUES (seq_post.NEXTVAL, '#트랜잭션#커밋#롤백');
INSERT INTO pages (page_id, category_id, posting_id, posting_name, posting_contents)
		VALUES (seq_page.NEXTVAL, 2, seq_post.CURRVAL, 'DDL, DML 복습', '트랜잭션은 매우 중요합니다.');

SELECT * FROM posts;
COMMIT;
