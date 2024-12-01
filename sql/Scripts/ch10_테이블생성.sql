 //AI서비스_웹과정반 @19일차[오라클5일차]
 -- scott_04 접속
 /*
  * 웹에서 데이터 가져올시 실수!
  * 커밋 안했던가, 다른계정에 데이터를 입력했던가, 입력도중 오류가 났던가
  */
-- SCOTT_04 계정에서 작업
/*
-- DDL(Data Definition Language : 데이터 정의어) : CREATE, ALTER, DROP, TRUNCATE
                  => AUTO COMMIT
-- DML(Data Manipulation Language : 데이터 조작어) : INSERT, UPDATE, DELETE
                  => COMMIT, ROLLBACK
-- DQL(Data Query Language : 데이터 질의어) : SELECT
-- DCL(Data Control Language : 데이터 제어) : GRANT, REVOKE
-- TCL(Transaction Control Language : 트랜잭션 콘트롤 제어) : COMMIT, ROLLBACK
*/
-- 테이블 목록 조회
SELECT * FROM tab;

-- 회원정보 테이블 삭제
DROP TABLE member_tbl;
-- 회원정보 테이블 생성
CREATE TABLE member_tbl (
        mem_id          NUMBER(3)           PRIMARY KEY,    -- PK(UNIQUE, NOT NULL)
        mem_name    VARCHAR2(50)    NOT NULL,    -- 필수
        mem_age       NUMBER(3),
        mem_email     VARCHAR2(60)     NOT NULL     UNIQUE,          -- 중복허용x
        mem_address VARCHAR2(100)
);

DESC member_tbl;    -- 테이블구조 확인
SELECt * FROM member_tbl;

/* 
 * 테이블에 데이터 추가하기 - 컬럼갯수, 컬럼순서, 자료형이 일치해야 한다.
 * INSERT INTO table명(컬럼1, 컬럼2, ..컬럼n)
 *  VALUES(값1, 값2, ..값n);
 * - 컬럼명 생략시 테이블생성시의 모든 컬럼순서대로 모든 값을 insert해야 한다. 갯수, 자료형 모두 일치해야 하며, 데이터 생략 불가.
 */
INSERT INTO member_tbl(mem_id, mem_name, mem_age, mem_email, mem_address)
    VALUES(101, '김태희', 30, 'kth@mail.com', '서울시 서초구');
INSERT INTO member_tbl(mem_id, mem_name, mem_age, mem_email, mem_address)
    VALUES(102, '비', 35, 'rain@mail.com', '서울시 마포구');
INSERT INTO member_tbl(mem_id, mem_name, mem_age, mem_email, mem_address)
    VALUES(103, '홍길동', 40, 'hong@mail.com', '서울시 금천구');
INSERT INTO member_tbl(mem_id, mem_name, mem_age, mem_email, mem_address)
    VALUES(104, '박나래', 45, 'park@mail.com', '서울시 강남구');
INSERT INTO member_tbl(mem_id, mem_name, mem_age, mem_email, mem_address)
    VALUES(105, '아이유', 30, 'iu@mail.com', '서울시 은평구');
INSERT INTO member_tbl /* 생략하면, 모든 컬럼 참조 */
    VALUES(106, '아이유', 30, 'kkk@mail.com', '서울시 은평구');

ROLLBACK; /* 되돌리기(데이터 조작후 COMMIT이 실행이 안됐을때) */
COMMIT; /* 영구저장 */

/*
 * 데이터 수정 
 * UPDATE 테이블명
 *  SET 변경컬럼명1=수정데이터1, 변경컬럼명2=수정데이터2,..
 *  WHERE 조건절
 */
UPDATE  member_tbl
       SET mem_name = '소지섭', mem_address = '맨하튼'
 WHERE mem_id = 106;
 -- 25~45(5씩 정렬) 나이수정
 UPDATE member_tbl
        SET mem_age = 25
 WHERE mem_id = 101;
 UPDATE member_tbl
        SET mem_age = 30
 WHERE mem_id = 102;
 UPDATE member_tbl
        SET mem_age = 35
 WHERE mem_id = 103;
 UPDATE member_tbl
        SET mem_age = 40
 WHERE mem_id = 104;
 UPDATE member_tbl
        SET mem_age = 45
 WHERE mem_id = 105;

/*
 * 데이터(행) 삭제 
 * DELETE [FROM] 테이블명
 *  WHERE 조건절
 */
-- 106 삭제
DELETE member_tbl
 WHERE mem_id = 106;

-----------------------------------
 /* 1. 제약조건(테이블 생성시) => 매우 중요 
 * -- 제약조건이란 테이블에 유효하지 않은(부적절한) 데이터가 입력되는 것을 방지하기 위해서
 *    테이블 생성시 각 컬럼에 대해 정의하는 규칙이다.
 * 
 * -- 데이터 무결성 : 데이터베이스에 저장되는 데이터의 정확성과 일관성을 보장한다는 의미이다.
 *             제약조건은 데이터 무결성을 지키기 위한 안전장치로서 중요한 역할을 한다.
 *             INSERT, UPDATE, DELETE 등 모든 과정에서 제약조건을 지켜야 한다.
 * -- Oracle의 제약조건 종류
 *    구분           설명    
 * - NOT NULL : 컬럼에 NULL 값을 허용하지 않는다. 중복은 허용함
 * - UNIQUE : 지정한 컬럼이 유일한 값을 가져야 한다. 단 null은 값의 중복에서 제외
 * - PRIMARY KEY : 식별자로서 지정한 컬럼이 유일한 값이면서 NULL을 허용하지 않는다. 테이블에 하나만 지정가능하다.
 * - FOREIGN KEY : 부모테이블에 존재하는 PK의 값만 입력가능하다. NULL을 허용한다. 
 * - CHECK : 설정한 조건식을 만족하는 데이터만 입력가능하다.
 * 
 * -- 테이블 생성은 부모테이블부터 하고, 테이블 삭제는 자식테이블부터 한다.
 * -- ON DELETE CASCADE : 자식테이블에 설정하면, 부모테이블 데이터 삭제시, 자식테이블 데이터도 함께 삭제 (순장)
 */ 
-- SCOTT_04 계정에서 작업
-- 부서테이블(부모테이블) 생성
SELECT * FROM tab;
DROP TABLE dept_tbl;

CREATE TABLE dept_tbl(
--        deptno          NUMBER(3)       PRIMARY KEY /* 컬럼등급 제약걸기 */,
        deptno          NUMBER(3),
        deptname     VARCHAR2(50)   NOT NULL,
        loc                VARCHAR2(50),
        CONSTRAINT dept_tbl_deptno_pk   PRIMARY KEY(deptno) /* 테이블등급 제약걸기 */
);

SELECT * FROM dept_tbl;

-- 사원테이블(자식테이블) 생성
CREATE TABLE emp_tbl(
        empno          NUMBER(3),       -- PK
        empname     VARCHAR2(30)    NOT NULL,
        hire_date      DATE     DEFAULT sysdate,
        salary           NUMBER(9)      CONSTRAINT emp_tbl_salary_min CHECK(salary > 0),
        deptno          NUMBER(3),      -- FK
        email            VARCHAR2(100),      -- UNIQUE
        CONSTRAINT emp_tbl_empno_pk PRIMARY KEY(empno),
        CONSTRAINT emp_tbl_deptno_fk FOREIGN KEY(deptno) REFERENCES dept_tbl(deptno)
                          ON DELETE CASCADE, -- 자식테이블에 설정하면, 부모테이블 삭제시, 같이 삭제된다.
        CONSTRAINT emp_tbl_email_uk UNIQUE(email)

        -- deptno NUMBER(3) CONSTRAINT emp_tbl_empno_fk REFERENCES dept_tbl(deptno) ON DELETE CASCADE
);

SELECT * FROM emp_tbl;

-- [ DEPT_TBL ] 10~50 -----------------------
INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(10, 'IT', '뉴욕');

INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(20, '마케팅', '캐나다');

INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(30, '회계', '파리');

INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(40, '인사과', '맨하튼');

INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(50, '경리과', '서울');

COMMIT;
SELECT * FROM dept_tbl;

-- [ DEPT_TBL ] 10~50 -----------------------
INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(101, '아이유', '2024/01/01', 10000, 10, 'iu@email.com');

INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(102, '방탄소년', '2024/02/01', 20000, 20, 'bt@email.com');

INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(103, '소지섭', '2024/03/01', 30000, 30, 'sjws@email.com');

INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(104, '박나래', '2024/04/01', 40000, 40, 'park@email.com');

INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(105, '유느님', '2024/05/01', 50000, 50, 'you@email.com');

COMMIT;
SELECT * FROM dept_tbl;

--INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
--    VALUES(106, 'test', '2024/06/01', 60000, 60, 'test@email.com'); /* FK값이 없다.(없는 부서다) */

-- dept_tbl, emp_tbl 60번 부서 동시 삭제 가능 => ON DELETE CASCADE => 만일 이 제약조건이 없다면, 부모삭제시 오류발생
INSERT INTO dept_tbl(deptno, deptname, loc)
    VALUES(60, '메타버스과', '실리콘벨리');

INSERT INTO emp_tbl(empno, empname, hire_date, salary, deptno, email)
    VALUES(106, '테스트', '2024/05/01', 50000, 60, 'test@email.com');

DELETE FROM dept_tbl
    WHERE deptno = 60;

COMMIT;

//AI서비스_웹과정반 @20일차[오라클6일차]
-- ***************************************************
-- 제약 조건명 검색 - [DBeaver]에서는 조회 안됨
-- 제약조건명은 계정이 동일한 모든 테이블에서 중복되면 안된다.
-- SQL Developer에서 실행
-- ***************************************************
SELECT constraint_name
             , constraint_type
             , table_name
    FROM sys.user_constraints       -- user로 시작하면, 데이터 사전
 WHERE table_name IN ('DEPT_TBL', 'EMP_TBL');     -- 테이블명은 반드시 대문자
