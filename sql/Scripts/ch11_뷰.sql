//AI서비스_웹과정반 @21일차[오라클7일차]
/*
1. 뷰의 개념과 사용하기 => 중요
- 뷰(View)는 한마디로 물리적인 테이블을 근거로 한 논리적인 가상테이블
- 디스크 저장 공간이 할당되지 않는다.
  즉, 실질적으로 데이터를 저장하지 않고, 데이터 사전에, 뷰를 정의할 때 기술한 쿼리문만 저장되어 있다.
  하지만 사용방법은 테이블에서 파생된 객체 테이블과 유사하기 때문에 가상테이블이라 한다.
  뷰의 정의는 USER_VIEWS 데이터 사전을 통해 조회가 가능하다.
  
2. 동작원리
- 뷰는 데이터를 저장하고 있지 않은 가상테이블이므로 실체가 없다.
  뷰가 테이블처럼 사용될 수 있는 이유는, 뷰를 정의할 때 CREATE VIEW 명령어 다음의
  AS 절에 기술한 쿼리문장 자체를 데이터딕셔너리에 저장하고 있다가 이를 실행하기 때문이다.
  
  SELECT문의 FROM 절에서 v-emp로 기술하여 정의하면, 오라클 서버는 USER_VIEWS에서 뷰이름(v-emp)를 찾는다.
  기술했던 서브쿼리문장이 저장된 text값을 view 즉 v_emp 위치로 가져와서 실행한다.
 
3. 뷰를 사용하는 이유
- 보안과 사용의 편의성 때문
- 보안 : 권한별로 접근이 제한되어서 동일한 테이블에 접근하는 사람마다 다른 뷰에 접근할 수 있도록 한다.

4. 권한 부여
-- 권한 부여 방법(System에서 부여) :  grant create view to scott_126;  
   만약 권한을 부여하지 않으면 insufficient privileges => create view 권한 없음 => 권한 부여하면 됨
-- View 생성시 자동으로  user_views 데이터사전에 자동등록된다.

-- View 이름은 user_views 데이터사전의 view_name에 저장
-- SQL문은 user_views 데이터사전의 text에 저장
*/
-- scott_04 계정
-- view 생성
CREATE OR REPLACE VIEW v_emp_dept       -- 데이터사전(user_views)에 자동 등록
AS
SELECT e.empno
             , e.empname
             , e.hire_date
             , d.deptname
    FROM emp_tbl e
              , dept_tbl d
 WHERE e.deptno = d.deptno; /* Equi Join */

SELECT * FROM tab;

-- 데이터사전(user_views)에서 view를 조회.. sql문이 text에 저장됨
SELECT view_name, text
    FROM user_views

-- view 조회
SELECT *
    FROM v_emp_dept;    -- 뷰이름
---------------------------------------------------
DROP TABLE menu_tbl;
CREATE TABLE menu_tbl(
        food_code       NUMBER(3)   PRIMARY KEY,
        rest_name       VARCHAR2(100)   NOT NULL,
        food_kind        VARCHAR2(50)   NOT NULL,
        food_name        VARCHAR2(50)   NOT NULL
);

--ALTER TABLE menu_tbl
--    MODIFY food_kind    VARCHAR(50) NOT NULL;

INSERT INTO menu_tbl(food_code, rest_name, food_kind, food_name)
    VALUES (101, '홍두깨칼국수', '한식', '돈까스');

INSERT INTO menu_tbl(food_code, rest_name, food_kind, food_name)
    VALUES (102, '쿠우쿠우', '일식뷔페', '초밥'); /* 한자당 3byte */

INSERT INTO menu_tbl(food_code, rest_name, food_kind, food_name)
    VALUES (103, '거북이의 주방', '일식', '카레');

INSERT INTO menu_tbl(food_code, rest_name, food_kind, food_name)
    VALUES (104, '호남식당', '한식', '제육볶음');

INSERT INTO menu_tbl(food_code, rest_name, food_kind, food_name)
    VALUES (105, '짜장상회', '중식', '짬뽕');

COMMIT;

SELECT * FROM menu_tbl;

-- v_menu => menu_tbl에서 food_code = 1, 3, 5일때 정보조회
CREATE OR REPLACE VIEW v_menu       -- 데이터사전(user_views)에 자동 등록
AS
SELECT *
    FROM menu_tbl
 WHERE food_code IN (101, 103, 105); /* Equi Join */

SELECT *
    FROM v_menu;

SELECT view_name, text
    FROM user_views;

-----------------------------------------------------------
/*  뷰 삭제하기
    [ 형식 ] DROP VIEW 뷰이름;
-- 뷰는 실체가 없는 가상테이블이기 때문에 뷰를 삭제한다는 것은 USER_VIEWS 데이터 사전에
      저장되어 있는 뷰의 정의를 삭제한다는 것을 의미
-- 뷰를 정의한 기본테이블의 구조나 데이터에는 영향이 없다.
*/
DROP VIEW v_menu;    -- 데이터사전에서 TEXT가 삭제

/* 
- CREATE OR REPLACE VIEW 
  이미 존재하는 뷰에 대해서 그 내용을 새롭게 변경하여 재생성
  뷰가 없으면 새롭게 생성하고, 존재하면 변경
  
- WITH CHECK OPTION -- 조회 기준
  지정한 제약 조건을 만족하는 데이터에 한해 DML(I,U,D) 작업이 가능하도록 뷰 생성 
  
- WITH READ ONLY
  해당 뷰를 통해서 SELECT만 가능하며, INSERT/UPDATE/DELETE를 할 수 없다.
*/
CREATE OR REPLACE VIEW v_emp_readonly
AS
SELECT empno
             , empname
             , hire_date
             , salary
             , deptno
    FROM emp_tbl
WITH READ ONLY;

SELECT view_name, text
    FROM user_views;

SELECT *
    FROM v_emp_readonly;

INSERT INTO v_emp_readonly(empno, empname, hire_date, salary, deptno)
    VALUES(106, '톨스토이', sysdate, 60000, 50);

-- [ WITH CHECK OPTION ]
-- view 입력,수정,삭제시 실제 테이블이 반영됨, view는 조회결과이므로 반영됨
-- 1) email 컬럼을 추가해서 view 생성 : WITH CHECK OPTION
-- 2) 111,112,113 insert(update는 차후에 하고, email 컬럼 insert 제외) => 조회 조건에 3건만 제약조건
-- 3) email update
-- 4) delete

-- 1) email 컬럼을 추가해서 view 생성 : WITH CHECK OPTION

CREATE OR REPLACE VIEW v_emp_checkoption
AS
SELECT empno
             , ename
             , hire_date
             , salary
             , deptno
             , email
    FROM emp_tbl
 WHERE empno IN (111,112,113) --지정한 제약조건 맞족시 DML 작업가능
WITH CHECK OPTION;
SELECT * FROM emp_tbl;
SELECT view_name, text FROM user_views;

-- 2) 111,112,113 insert(update는 차후에 하고, email 컬럼 insert 제외) => 조회 조건에 3건만 제약조건 
INSERT INTO v_emp_checkoption(empno, ename, hire_date, salary, deptno)
VALUES (111, '기안 84', sysdate, 20000, 50);
INSERT INTO v_emp_checkoption(empno, ename, hire_date, salary, deptno)
VALUES (112, '이효리', sysdate, 30000, 50);
INSERT INTO v_emp_checkoption(empno, ename, hire_date, salary, deptno)
VALUES (113, '이상순', sysdate, 40000, 50);
COMMIT;

SELECT * FROM v_emp_readonly; --제약조건 일치 데이터 INSERT 성공
--111   기안 84   24/11/28   20000   50   NULL --이메일 미정
--112   이효리   24/11/28   30000   50   NULL
--113   이상순   24/11/28   40000   50   NULL

SELECT * 
    FROM emp_tbl;
--111   기안 84   24/11/28   20000   50   NULL 
--112   이효리   24/11/28   30000   50   NULL
--113   이상순   24/11/28   40000   50   NULL   
--101   아이유   24/01/01   10000   10   iu@email.com
--102   방탄소년단   24/02/01   20000   20   bts@email.com
--103   소지섭   24/03/01   30000   30   sjws@email.com
--104   박나래   24/04/01   40000   40   park@email.com
--105   유재석   24/05/01   50000   50   yjs@email.com

-- 3) email update
UPDATE v_emp_checkoption --뷰는 creat 말고 는 view 안 붙인다.
       SET email = 'kian84@naver.com'
 WHERE empno = 111;
UPDATE v_emp_checkoption 
       SET email = 'leehyolee@naver.com'
 WHERE empno = 112;
UPDATE v_emp_checkoption
       SET email = 'leesangsoon@naver.com'
 WHERE empno = 113;

-- 4) delete(111번)
DELETE FROM v_emp_checkoption
        WHERE empno = 111;
COMMIT;

/* 중요
 * 인라인뷰 : 일회성으로 만들어서 사용하는 뷰
 * 1. 뷰를 이용해서 top_n 구하기
 * 2. 
 */
SELECT ROWNUM AS 순위     -- ROWNUM : ROW(행)의 고유번호이며, 넘버링
             , e.*
    FROM emp_tbl e;

-- 1) 최근 회원가입순 2명출력(인라인뷰)
SELECT ROWNUM AS 순위
             , e.*
    FROM emp_tbl e
 WHERE ROWNUM < 3;

-- hr계정에서 실행
-- 2) 입사일 빠른 순서로 5명 출력(인라인뷰 - 서브쿼리)
SELECT ROWNUM AS 순위
             , e.*
    FROM (SELECT employee_id
                              , last_name
                              , hire_date
                              , salary
                    FROM employees
            ORDER BY hire_date) e
 WHERE ROWNUM <= 5;

SELECT *
    FROM employees
 WHERE ROWNUM <= 5 /* 이러면, 위에서부터 5개를 가져와서 정렬함 */
ORDER BY hire_date;

-- 3) 고액급여 순서로 5명 출력(인라인뷰 - 서브쿼리)
SELECT ROWNUM AS 순위
             , e.*
    FROM (SELECT employee_id
                              , last_name
                              , hire_date
                              , salary
                    FROM employees
            ORDER BY salary DESC) e
 WHERE ROWNUM <= 5;

-- 4) 인라인 뷰(WITH절 사용)
WITH
emp AS (SELECT employee_id
                              , last_name
                              , hire_date
                              , salary
                    FROM employees
            ORDER BY salary DESC)
SELECT ROWNUM AS 순위
             , e.*
    FROM  emp
 WHERE ROWNUM <= 5; 
