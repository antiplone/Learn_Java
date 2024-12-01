//AI서비스_웹과정반 @20일차[오라클6일차]
/*  1.트랜잭션 / 2.데이터사전 / 3.인덱스 / 4.시퀀스
 [ 1. 트랜잭션 ]
- 트랜잭션은 데이터 처리에서 논리적인 하나의 작업 단위를 의미한다.
- ALL or Nothing : 여러개의 명령어 집합이 정상적으로 처리되면 정상종료하고,
                            명령어들중 하나라도 잘못된다면 전체를 취소한다.
- DML 작업이 성공적으로 처리되었다면 COMMIT을, 
         취소해야 한다면 ROLLBACK 명령을 실행한다.
         ROLLBACK : COMMIT 후에 취소가 되지 않는다.
         
- DDL(테이블생성, 수정), DCL(권한)문이 실행되는 경우에는 자동으로 COMMIT 된다. COMMIT 할 필요 없다.
- COMMIT - 트랜잭션의 처리과정을 반영하여 변경된 내용을 영구저장한다. 모든 작업들의 정상처리확정 명령어다.
           INSERT, UPDATE, DELETE(즉 DML) 후 COMMIT을 해야 한다. 
           
- LOCK : 특정 세션에서 조작중인 데이터는 트랜잭션이 완료(COMMIT, ROLLBACK)되기 전까지 다른 계정에서 
         조작할 수 없도록 접근을 보류시키게 된다. 즉 데이터가 '잠금현상'이 일어난다.
         트랜잭션이 완료(COMMIT, ROLLBACK)가 되면 LOCK이 풀리게 된다.
         
         주의 : WHERE절을 지정하지 않은 UPDATE, DELETE문일 경우에는 테이블의 모든행이 LOCK 상태가 된다.
           
- DBeaver 툴에서는 savepoint가 작동안됨           
- SAVEPOINT - 현재의 트랜잭션을 작게 분할한다. 대소문자 구별함
   저장된 SAVEPOINT는 ROLLBACk TO SAVEPOINT 문을 사용하여 표시한 곳까지 롤백할 수 있다.
  1) SAVEPOINT S1;   -- S1 : SAVEPOINT명
     SAVEPOINT S2;   -- S2 : SAVEPOINT명0
  2) ROLLBACK TO S1;   -- S1 : SAVEPOINT명
*/

-- 구조 + 데이터
CREATE TABLE member_tbl_tr
AS
    SELECT * FROM member_tbl;

-- 1.
UPDATE member_tbl_tr
        SET mem_email = 'hongkildong@naver.com'
 WHERE mem_id = 103;

SAVEPOINT s1;

-- 2. 101번 삭제
DELETE FROM member_tbl_tr
 WHERE mem_id = 101;

SAVEPOINT s2;

-- 3. 102번 삭제
DELETE FROM member_tbl_tr
 WHERE mem_id = 102;

SAVEPOINT s3;

-- 4. 104번 삭제
DELETE FROM member_tbl_tr
 WHERE mem_id = 104;

SAVEPOINT s4;

ROLLBACK TO s3; -- 104번 복구
ROLLBACK TO s2; -- 102번 복구
ROLLBACK TO s1; -- 101번 복구
ROLLBACK; -- COMMIT 이후 시점

SELECT * FROM member_tbl_tr;
--DELETE FROM member_tbl_tr

/* SQL DEVELOPER에서 실행
 * [ 2. 데이터 사전 ]
 * - 데이터 사전 : 사용자와 데이터베이스 자원의 효율적 관리를 위한 다양한 정보를 저장하는 시스템 테이블의 집합이다.
 * - 사용자가 테이블을 생성하거나, 사용자를 변경하는 등의 작업을 할 때 데이터베이스 서버에 의해
 *   자동으로 갱신되는 테이블이다.
 
 * - [접두어]
 * USER_XXXX : 자신의 계정이 소유한 객체 등에 관한 정보조회
 * ALL_XXXX : 사용허가를 받은 모든 객체 정보 조회
 * DBA_XXXX : 데이터베이스 관리자(SYSTEM, SYS)만 접근가능한 정보
 * 
 * - 데이터 사전 - USER_데이터사전
 *   . USER_SEQUENCES : 사용자가 소유한 시퀀스의 정보
 *   . USER_INDEXES : 사용자가 소유한 인덱스의 정보
 *   . USER_VIEWS : 사용자가 소유한 뷰의 정보
 *   . USER_TABLES : 사용자가 소유한 테이블의 정보
 */
-- SCOTT_04 계정에서 실행
-- user_tables : USER_데이터 사전 => 자신의 계정에서 개인이 만든 테이블 목록 조회
-- 테이블목록
SELECT table_name
    FROM user_tables;

-- 뷰목록
SELECT view_name
    FROM user_views;

-- all 접두어를 가진 데이터 사전
SELECT owner, table_name
    FROM all_tables;

-- system 계정에서 실행
-- DBA 접두어를 가진 데이터 사전
SELECT owner, table_name
    FROM dba_tables;

-- system 계정에서 실행
SELECT *
    FROM dba_users
 WHERE username = 'SCOTT_04';

/* [ 3. 인덱스 ]    인덱스의 종류
 - 1)비고유 인덱스 : 중복된 데이터를 갖는 컬럼에 대해서 생성하는 인덱스이며, UNIQUE를 붙이면 에러 발생
 - 2)고유 인덱스 : 기본키나 유일키처럼 유일한 값을 갖는 컬럼에 대해서 생성하는 인덱스이며, UNIQUE INDEX로 사용한다.
 - 3)결합 인덱스 : 두개 이상의 컬럼으로 인덱스를 구성
 - 4)함수기반 인덱스 : 수식이나 함수를 적용하여 만든 인덱스
*/
CREATE TABLE emp_idx_tbl
AS
    SELECT * FROM emp_tbl;

CREATE TABLE dept_idx_tbl
AS
    SELECT * FROM dept_tbl;

SELECT * FROM emp_idx_tbl;
SELECT * FROM dept_idx_tbl;

-- 1) 인덱스 : 비고유
-- 중복된 데이터를 갖는 컬럼에 대해서 생성하는 인덱스이며, UNIQUE를 붙이면 에러 발생
-- 단, 서브쿼리로 테이블생성시 제약조건이 복사안되므로 에러가 안남
DROP INDEX idx_emp_empname;
CREATE INDEX idx_emp_empname
    ON emp_idx_tbl(empname);      -- ON 테이블명(컬럼);

-- 인덱스 생성 확인
SELECT index_name
             , table_name
             , column_name
    FROM USER_IND_COLUMNS   -- 데이터사전에서 인덱스 조회
 WHERE table_name IN('EMP_IDX_TBL');

-- 2) 고유 인덱스 :
-- 기본키나 유일키처럼 유일한 값을 갖는 컬럼에 대해서 생성하는 인덱스이며, UNIQUE INDEX로 사용한다.
DROP INDEX idx_dept_deptno;
CREATE UNIQUE INDEX idx_dept_deptno
    ON dept_idx_tbl(deptno);      -- ON 테이블명(컬럼);

-- 인덱스 생성 확인
SELECT index_name
             , table_name
             , column_name
    FROM USER_IND_COLUMNS   -- 데이터사전에서 인덱스 조회
 WHERE table_name IN('DEPT_IDX_TBL');

-- 3) 결합 인덱스 : 두개 이상의 컬럼으로 인덱스를 구성
DROP INDEX idx_dept_com;
CREATE INDEX idx_dept_com
    ON dept_idx_tbl(deptname, loc);      -- ON 테이블명(컬럼);

-- 인덱스 생성 확인
SELECT index_name
             , table_name
             , column_name
    FROM USER_IND_COLUMNS   -- 데이터사전에서 인덱스 조회
 WHERE table_name IN('DEPT_IDX_TBL');

-- 4) 함수기반 인덱스 : 수식이나 함수를 적용하여 만든 인덱스
DROP INDEX idx_emp_salary;
CREATE INDEX idx_emp_salary
          ON emp_idx_tbl(salary * 12);

-- 인덱스 생성 확인
SELECT index_name
             , table_name
             , column_name
    FROM USER_IND_COLUMNS   -- 데이터사전에서 인덱스 조회
 WHERE table_name IN('EMP_IDX_TBL');

/*
   [ 4. 시퀀스 ]  
    시퀀스는 테이블내의 유일한 숫자를 자동으로 생성해주며, 기본키로 사용된다.
   새로운 데이터가 추가될 때 기본키값을 자동으로 발생시키는 용도로 사용된다.
   마치 mysql의 auto_increment와 동일
   
   CURRVAL : 시퀀스에서 마지막으로 생성한 번호를 반환
             - 시퀀스를 생성하고 바로 사용하면 번호가 만들어진적이 없으므로 오류가 발생=> 처음 시퀀스를 만든 경우 NEXTVAL을 먼저 조회해야 한다.)
   NEXTVAL : 다음 번호를 생성
      
   사용 : 게시판의 게시글번호, 상품주문번호
   -- [형식]
   -- 시퀀스 생성
   CREATE SEQUENCE 시퀀스명
     START WITH n
     INCREMENT BY n
     MAXVALUE n | MINVALUE n
     CYCLE | NOCYCLE
     CACHE | NOCACHE
     
   -- 생성한 시퀀스 확인(데이터사전)
   SELECT *
     FROM USER_SEQUENCES;
     
   -- 시퀀스 삭제  
   DROP SEQUENCE 시퀀스명;  
*/
DROP SEQUENCE dept_seq;
CREATE SEQUENCE dept_seq
    START WITH 10
    INCREMENT BY 10
    MAXVALUE 90
    MINVALUE 0
    NOCYCLE;

SELECT *
    FROM USER_SEQUENCES;

-- 1) 처음 시퀀스를 만든 경우 NEXTVAL(다음 번호새성)로 SQL을 만든다.
SELECT dept_seq.NEXTVAL
    FROM dual;

-- 2) 그후 CURRVAL로 값을 조회한다.
SELECT dept_seq.CURRVAL
    FROM dual;

-- ///////////////////////////////////////////////////////////////////////////
-- 부서테이블 생성(부모테이블)
DROP TABLE dept_seq_tbl;
CREATE TABLE dept_seq_tbl(
    deptno        NUMBER(3),
    deptname    VARCHAR2(50)    NOT NULL,
    loc                VARCHAR2(50),
    CONSTRAINT dept_seq_tbl_deptno_pk PRIMARY KEY(deptno)
);

-- 사원테이블 생성(자식테이블 생성)
DROP TABLE emp_seq_tbl;
CREATE TABLE emp_seq_tbl(
    empno       NUMBER(3),  -- PRIMARY KEY
    ename       VARCHAR2(30)    NOT NULL,
    hire_date   DATE  DEFAULT sysdate,
    salary        NUMBER(9)    CONSTRAINT emp_seq_tbl_salary_min CHECK(salary > 0),
    deptno       NUMBER(3),
    email          VARCHAR2(100),
    CONSTRAINT emp_seq_tbl_empno_pk PRIMARY KEY(empno),
    CONSTRAINT emp_seq_tbl_deptno_fk FOREIGN KEY(deptno) REFERENCES dept_seq_tbl(deptno)
            ON DELETE CASCADE,
    CONSTRAINT emp_seq_tbl_email_uk UNIQUE(email)
);

-- [ ex_dept_sequence 생성 => 부서테이블과 사원테이블의 부서번호 대체, 
-- [ ex_emp_sequence 생성 => 사원테이블의 사번 대체 ]
-- [ DEPT_SEQ_TBL ] 10~50 10씩 증가 ----------------------
-- [ EMP_SEQ_TBL ] 101~105 1씩 증가 ----------------------
CREATE SEQUENCE ex_dept_sequence
    START WITH 10
    INCREMENT BY 10
    MAXVALUE 100
    MINVALUE 0
NOCYCLE;
CREATE SEQUENCE ex_emp_sequence
    START WITH 101
    INCREMENT BY 1
    MAXVALUE 200
    MINVALUE 1
NOCYCLE;

-- 시퀀스 목록
SELECT sequence_name
    FROM user_sequences;

INSERT INTO dept_seq_tbl(deptno, deptname, loc)
    VALUES (ex_dept_sequence.NEXTVAL, 'IT', '뉴욕');
INSERT INTO emp_seq_tbl(empno, ename, hire_date, salary, deptno, email)
    VALUES (ex_emp_sequence.NEXTVAL, '아이유', '2024/01/01', 10000, ex_dept_sequence.CURRVAL, 'iu@email.com');

INSERT INTO dept_seq_tbl(deptno, deptname, loc)
    VALUES (ex_dept_sequence.NEXTVAL, '마케팅', '캐나다');
INSERT INTO emp_seq_tbl(empno, ename, hire_date, salary, deptno, email)
    VALUES (ex_emp_sequence.NEXTVAL, '방탄소년', '2024/02/01', 20000, ex_dept_sequence.CURRVAL, 'bt@email.com');

INSERT INTO dept_seq_tbl(deptno, deptname, loc)
    VALUES (ex_dept_sequence.NEXTVAL, '회계', '파리');
INSERT INTO emp_seq_tbl(empno, ename, hire_date, salary, deptno, email)
    VALUES (ex_emp_sequence.NEXTVAL, '소지섭', '2024/03/01', 30000, ex_dept_sequence.CURRVAL, 'sjws@email.com');

INSERT INTO dept_seq_tbl(deptno, deptname, loc)
    VALUES (ex_dept_sequence.NEXTVAL, '인사과', '맨하튼');
INSERT INTO emp_seq_tbl(empno, ename, hire_date, salary, deptno, email)
    VALUES (ex_emp_sequence.NEXTVAL, '박나래', '2024/04/01', 40000, ex_dept_sequence.CURRVAL, 'park@email.com');

INSERT INTO dept_seq_tbl(deptno, deptname, loc)
    VALUES (ex_dept_sequence.NEXTVAL, '경리과', '서울');
INSERT INTO emp_seq_tbl(empno, ename, hire_date, salary, deptno, email)
    VALUES (ex_emp_sequence.NEXTVAL, '유느님', '2024/05/01', 50000, ex_dept_sequence.CURRVAL, 'you@email.com');

SELECT * FROM dept_seq_tbl;
SELECT * FROM emp_seq_tbl;

COMMIT;
