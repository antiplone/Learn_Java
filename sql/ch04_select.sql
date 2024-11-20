//AI서비스_웹과정반 @15일차
-- 열(컬럼:Column), 행(로우:Row), 테이블(데이터가 저장되는 장소)
-- 식별자:KEY => PK(Primary Key), FK(Foreign Key)
-- 화면 입력 -> DTO(setter -> 멤버변수 -> getter) -> DB(List에 DTO정보를 add - > 테이블에 insert)

/* ctrl + shift + y 소문자
 * ctrl + shift + x 대문자
 * SELECT * FROM 테이블명;
 *
 * SELECT 컬럼1, 컬럼2... FROM 테이블명
 *  WHERE 조건절 => 행에 대한 조건절
 *  ORDER BY 컬럼명 ASC; => SELECT문 맨끝에 온다. 여러열 지정가능,
 *  정렬한 데이터가 동일하면, 그 뒤에 오는 데이터의 정렬방식을 따른다.
 *        ASC(오름차순이며 생략가능), DESC(내림차순);
 *~Tips)
 * SELECT후 FROM절을 먼저 써놓으면, Column참조가 더쉽다.
 */

-- 실습 4-1)
-- SELECT * FROM 테이블명;
SELECT *
    FROM employees;     -- 모든(*) 사원정보 조회

-- 이메일 오름차순, First_Name 오름차순, 입사일순 내림차순
SELECT first_name
             , email
             , hire_date
    FROM employees
ORDER BY first_name                      -- 1순위 이름 오름
                  , email DESC                   -- 2순위 이메일 내림
                  , hire_date DESC;            -- 3순위 입사일 내림

-- 부서코드 오름차순, hire_date 내림차순
SELECT department_id
             , hire_date
    FROM employees
ORDER BY department_id ASC, hire_date DESC;

-- 실습 4-2) 사번테이블에서 사번, First_name, 입사일, 이메일, 급여, 부서코드, 직무코드 조회(사번이 206번일때)
SELECT employee_id      -- 사번
             , first_name          -- 이름
             , hire_date           -- 입사일
             , email                  -- 이메일
             , salary                 -- 급여
             , department_id    -- 부서코드
             , job_id                 -- 직무코드
    FROM employees
 WHERE employee_id = 206;
 --     206	William	02/06/07	WGIETZ	8300	110	AC_ACCOUNT

-- 실습 4-3) 부서정보 조회
SELECT *
    FROM departments;   -- 모든(*) 부서정보 조회

-- 실습 4-4) 부서테이블에서 부서코드, 부서명, 지역코드 조회(부서코드가 110번일때)
SELECT department_id
             , department_name
             , location_id
    FROM departments
 WHERE department_id = 110;
 --     110	Accounting	1700

-- 실습 4-5) 지역테이블 조회
SELECT *
    FROM locations;

 -- 실습 4-6) 지역코드가 1700일때 위치코드, 주소, 도시, 국가코드(지역코드가 1700일때)
 SELECT location_id         -- 위치코드
              , street_address  -- 주소
              , city                     -- 도시
              , country_id          -- 국가코드
     FROM locations
  WHERE location_id = 1700;
  --    1700	2004 Charade Rd	Seattle	US

-- 실습 4-7) 국가정보 조회
SELECT *
    FROM countries;

-- 실습 4-8) 국가ID, 국가명, 지역코드(국가코드가 US일때)
SELECT country_id       -- 국가ID
             , country_name -- 국가명
             , region_id         -- 지역코드
    FROM countries
 WHERE country_id = 'US'; /* '대소문자 구분'    cf) "문자열"은 에러 */
 --     US	United States of America	2

-- 실습 4-9) 직무테이블 조회
SELECT *
    FROM jobs;

-- 실습 4-10) William의 직무코드, 직무타이틀, 최소급여 조회(직무코드가 AC_ACCOUNT일때)
SELECT job_id           -- 직무코드
             , job_title        -- 직무타이틀
             , min_salary   -- 최소급여
    FROM jobs
 WHERE job_id = 'AC_ACCOUNT'; /* William의 직무코드 */
 --     AC_ACCOUNT	Public Accountant	4200
 
 
 -- 실습 4-11) 직무기록 테이블 조회
SELECT *
    FROM job_history;

-- 실습 4-12) AC_ACCOUNT 직무히스토리를 가진 사원의 사번, 시작일, 종료일, 부서코드
SELECT employee_id           -- 사번
             , start_date               -- 시작일
             , end_date                -- 종료일
             , department_id        -- 부서코드
    FROM job_history
 WHERE job_id = 'AC_ACCOUNT';
--  101	97/09/21	01/10/27	110
--  200	02/07/01	06/12/31	90

----------------------------------------------------------------------
--  [DESC 테이블의 구조 : DESC(DESCRIBE) 테이블명 ]  -- 테이블의 구조 파악
-- NOT NULL(NULLABLE NO) : 필수
DESC employees;

-- [DISTINCT] : 열 중복데이터를 삭제
-- SELECT DISTINCT + 적용 컬럼
-- 열이 여러개인 경우, 여러개의 열까지 모두 동일해야 중복데이터로 간주

-- 실습 4-13) 사원테이블에서 department_id, manager_id를 조회 (단 department_id 중복없이 출력)
--      department_id 내림차순 정렬
SELECT DISTINCT department_id
    FROM employees
ORDER BY department_id DESC; /* null이 제일 큰값으로 정렬됨 */

-- DISTINCT다음에 열(Column)들을 종합해서 중복을 검사
-- (department_id, manager_id두개의 값 모두 동일해야 중복)
SELECT DISTINCT department_id
             , manager_id
    FROM employees
ORDER BY department_id DESC; /* null이 제일 큰값으로 정렬됨 */


-- [별칭]
-- 컬럼명 : 한칸띄우고 별칭, 한칸 띄우고 "별칭", 한칸 띄우고 AS 별칭, 한칸 띄우고 AS "별칭"
-- 테이블명 : 한칸 띄우고 영문별칭 /* 테이블이 두개이상일때 많이씀(Column명이 겹치는 경우) */
--{     처리문을 간결하게 정리, 글자가 이어지지 않을때 "별칭"으로 묶으면 된다.
-- 이메일 오름차순, First_Name 오름차순, 입사일순 내림차순

SELECT emp.first_name || ' ' || emp.last_name "이름" /* ||(concat) 문자열 연결 */
             , email "이메일"
             , hire_date "입사일"
             , salary * 12 + commission_pct "연봉" /* 값이 null이면 비교, 연산, 할당 불가 => null로 들어감 */
             , nvl(salary * 12 + commission_pct, 0) "null = 0"
    FROM employees emp;
