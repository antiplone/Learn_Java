//AI서비스_웹과정반 @20일차[오라클6일차]
-- scott_04 접속
SELECT * FROM tab;

DROP TABLE member_tbl_copy;
-- 신규 테이블 생성
CREATE TABLE member_tbl (
        mem_id          NUMBER(3)           PRIMARY KEY,    -- PK(UNIQUE, NOT NULL)
        mem_name    VARCHAR2(50)    NOT NULL,    -- 필수
        mem_age       NUMBER(3),
        mem_email     VARCHAR2(60)     NOT NULL     UNIQUE,          -- 중복허용x
        mem_address VARCHAR2(100)
);

-- 방법1) 기존 테이블 복제(구조, 데이터)
CREATE TABLE member_tbl_copy
          AS SELECT * FROM member_tbl;

DESC member_tbl_copy;
SELECT * FROM member_tbl_copy;

-- 방법2-1) 테이블 구조만 복사(CREATE) => 단, 제약조건(구조)은 복사되지 않는다.
CREATE TABLE member_tbl_copy2
          AS SELECT * FROM member_tbl
                WHERE 0=1;

-- 방법2-2) 테이블에 데이터 복사
INSERT INTO member_tbl_copy2
    SELECT * FROM member_tbl;
COMMIT;

SELECT * FROM member_tbl_copy2;

/* 12-3. 테이블의 구조를 변경하는 ALTER TABLE문
 * 
 * 1) 컬럼추가 : ADD 컬럼명 데이터타입
 *    컬럼추가를 하면 테이블의 맨끝에 컬럼이 추가된다.
 * 
 * [ 형식 ]
 * ALTER TABLE 테이블명
 * ADD 컬럼명 데이터타입
 * 
 * 2) 열이름 변경 : RENAME COLUMN old_컬럼 TO new_컬럼
 */
-- 1) 컬럼추가 : ADD 컬럼명 데이터타입
ALTER TABLE member_tbl_copy
    ADD mem_joindate DATE DEFAULT sysdate;

SELECT * FROM member_tbl_copy;

-- 2) 열이름 변경 : RENAME COLUMN old_컬럼 TO new_컬럼
ALTER TABLE member_tbl_copy
    RENAME COLUMN mem_joindate TO mem_join_date;

/*  
 * 3) 컬럼의 자료형 변경 : MODIFY 컬럼명 데이터타입
 * => 기존 데이터는 그대로 유지하면서 데이터타입, 크기, 기본값을 변경한다.
 * 
 * [ 형식 ]
 * ALTER TABLE 테이블명
 * MODIFY 컬럼명 데이터타입
 */
-- 3) 컬럼 자료형 변경 : MODIFY
ALTER TABLE member_tbl_copy
    MODIFY mem_email    VARCHAR2(100); -- 60 => 100
DESC member_tbl_copy;

/*
 * 4) 컬럼제거 : DROP COLUMN 컬럼명
 * => 기존 데이터는 그대로 유지
 * 
 * [형식]
 * ALTER TABLE 테이블명
 * DROP COLUMN 컬럼명
 */ 
-- 4) 컬럼 삭제 : DROP COLUMN
ALTER TABLE member_tbl_copy
    DROP COLUMN mem_join_date;
SELECT * FROM member_tbl_copy;

/*
 * 5) 테이블 이름 변경 RENAME TO
 * 
 * [형식]
 * ALTER TABLE [old 테이블명] 
 * RENAME TO [new 테이블명] 
 
 * 또는
 RENAME [old 테이블명]  TO [new 테이블명];
 */
RENAME member_tbl_copy2 TO member_tbl_rename;
SELECT * FROM member_tbl_copy2; -- 없다.
SELECT * FROM member_tbl_rename; -- 있다.

/*
 * 12-4. 테이블의 데이터를 전체 삭제하는 TRUNCATE문
 *   => 데이터정의어이므로 자동커밋되기 때문에 롤백이 되지 않는다.(WHERE절이 없는 DELETE(롤백이 된다)와 동일)
 * 
 * [형식]
 * TRUNCATE TABLE 테이블명
 */
TRUNCATE TABLE member_tbl_rename;
SELECT * FROM member_tbl_rename; -- 있다.

/*
 * 12-5. 테이블을 삭제하는 DROP문
 *   => 테이블 자체 삭제
 * 
 * [형식]
 * DROP TABLE 테이블명
 */
DROP TABLE member_tbl_rename; -- 있다.
SELECT * FROM member_tbl_rename; -- 있다.
