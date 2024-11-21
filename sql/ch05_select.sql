//AI서비스_웹과정반 @16일차[오라클2일차]
-- 실습 4-15) 사원테이블의 사번, 이메일, 급여, 부서, 입사일 조회(단, 부서코드가 60, 100일때)
/* 5장
 * [비교연산자]
 * - 같다 : =
 * - 같지않다 : <>, !=, ^=
 * - >, <, >=, <=
 */
-- 실습 5-1) 사원테이블에서 사번, last_name, job_id, salary 조회
-- 단, salary가 10000이상, 사번이 150이상, last_name이 Ozer인 사원일 때
                                             -- 참조할 Column은
SELECT employee_id          -- 사번
             , last_name              -- 성
             , job_id                     -- 직무
             , salary                     -- 급여
    FROM employees  -- 사원테이블에서
 WHERE salary >= 10000          -- 급여가 10000이상이고,
       AND employee_id >= 150   -- 사번이 150이상이고,
       AND last_name = 'Ozer';     -- 성이 Ozer일때

-- 실습 5-2) 사원테이블에서 사번, 입사일, 급여, 부서ID 조회(부서ID 오름차순, 급여 내림차순), 단 급여는 15000이상
                                        -- 참조할 Column은
SELECT employee_id       "사번"
             , hire_date            "입사일"
             , salary                 "급여"
             , department_id    "부서코드"
    FROM employees  -- 사원테이블에서
 WHERE salary >= 15000  -- 급여가 15000이상일때
ORDER BY department_id  -- 부서코드는 오름차순,
                  , salary DESC;    -- 급여는 내림차순으로 기준으로 정렬

-- 실습 5-3) 부서테이블에서 부서ID가 50번 미만일때의 부서ID, 부서명, 매니저ID
                                                -- 참조할 Column은
SELECT department_id            "부서코드"
             , department_name      "부서이름"
             , manager_id                "매니저ID"
    FROM departments    -- 부서테이블에서
 WHERE department_id < 50;  -- 부서코드가 50보다 작을때(미만)
 
 /* [IN 연산자] : 특정 컬럼의 값이 A,B,C 중에 하나라도 일치하면 참이 되는 연산자이다. => 중요
 * - 형식 : 컬럼값 IN(A,B,C)  
 *         컬럼값 NOT IN(A,B,C)  
 */
-- 실습 5-4) salary가 1000이상 11000이하인 사원의 사번, salary 검색(정렬)
                                       -- 참조할 Column은
SELECT employee_id      "사번"
             ,  salary                "급여"
    FROM employees  -- 사원테이블에서
 WHERE salary >= 10000 AND salary <= 11000    -- 10000 <= 급여 <= 11000일때 BETWEEN을 써도 되겠다.
ORDER BY salary;    -- 급여기준으로 정렬

-- 실습 5-5) 날짜 / 문자 데이터 조회
-- 사원테이블에서 last_name이 King이거나, 입사일이 05/07/16인 사원의 사번, last_name, 입사일 조회
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , last_name      "성"
             , hire_date        "입사일"
    FROM employees  -- 사원테이블에서
 WHERE last_name = 'King'           -- 성이 King이고,
         OR hire_date = '05/07/16';     -- 입사일이 05/07/16일때 /* 날짜는 규격이있는 문자열 */

-- 실습 5-6) 사원테이블에서 부서ID가 70,90,100인 사원의 
-- 사번, last_name, 부서ID로 조회(단 부서ID 오름차순)
                                       -- 참조할 Column은
SELECT employee_id      "사번"
             , last_name          "성"
             , department_id    "부서코드"
    FROM employees  -- 사원테이블에서
 WHERE department_id IN (70, 90, 100)  -- 부서코드가 70 OR 90 OR 100일때
ORDER BY department_id; -- 부서코드기준으로 정렬

/*
 * BETWEEN A AND B 연산자 => 중요
 * - WHERE 컬럼명 BETWEEN 최소값 AND 최대값; 
 */
-- 실습 5-7) salary가 10000이상 11000이하인 사원의 사번, salary 검색(정렬)
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , salary             "급여"
    FROM employees  -- 사원테이블에서
 WHERE salary BETWEEN 10000 AND 11000   --  10000 <= 급여 <= 11000일때
ORDER BY salary;    -- 급여기준으로 정렬

-- 실습 5-8) 사원테이블에서 사번, 입사일 조회(단 입사일은 04/12/31 ~ 05/01/30), 단 입사일 오름차순 정렬
                                  -- 참조할 Column은
SELECT employee_id  "사번"
             , hire_date        "입사일"
    FROM employees  -- 사원테이블에서
 WHERE hire_date BETWEEN '04/12/13' AND '05/01/30'  -- 04/12/13 <= 입사일 <= 05/01/30일때
ORDER BY hire_date; -- 입사일기준으로 정렬

/*
 *  LIKE 연산자와 와일드 카드 => 중요
 * - 컬럼명 LIKE Pattern
 * - 와일드 카드 :
 *   % => 길이와 상관없이 모든 문자데이터를 의미
 *   _ => 어떤 값이든 상관없이 한개의 문자데이터를 의미
 */
-- 실습 5-9) 사원테이블에서 last_name의 3번째, 4번째 단어가 'tt'인 사원의 사번, last_name 조회..사번 오름차순정렬
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , last_name      "성"
    FROM employees  -- 사원테이블에서
 WHERE last_name LIKE '__tt%'   -- 성이 3, 4번째 단어가 't'일때
ORDER BY employee_id;   -- 사번기준으로 정렬

-- 실습 5-10) 사원테이블에서 사번, 'JONES'가 포함된 email 조회.. 사번 오름차순 정렬
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , email              "E-mail"
    FROM employees  -- 사원테이블에서
WHERE email LIKE '%JONES%'  -- 이메일에 JONES가 들어갈때
ORDER BY employee_id;   -- 사번기준으로 정렬

-- 실습 5-11) JOBS 테이블에서 'REP'가 포함된 job_id 조회
                         -- 참조할 Column은
SELECT job_id   "직무코드"
    FROM jobs   -- 직무테이블에서
WHERE job_id LIKE '%REP%';  -- 직무코드에 REP가 들어갈때

-- 실습 5-12-1) 사원테이블에서 'ul'이 포함된 사번, last_name 조회.. 사번 오름차순 정렬
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , last_name      "성"
    FROM employees  -- 사원테이블에서
WHERE last_name LIKE '%ul%' -- 성에 ul이 들어갈때
ORDER BY employee_id;   --  사번기준으로 정렬

-- 실습 5-12-2) 사원테이블에서 'ul'이 포함되지 않은 사번, last_name 조회.. 사번 오름차순 정렬
                                   -- 참조할 Column은
SELECT employee_id  "사번"
             , last_name      "성"
    FROM employees  -- 사원테이블에서
WHERE last_name NOT LIKE '%ul%' -- 성에 ul이 안들어갈때
ORDER BY employee_id;   -- 사번기준으로 정렬

/*
 * NULL : 미확정, 값이 정해져 있지 않아 알수없는 값을 의미하며, 연산불가, 비교불가, 대입불가
 *        연산시 관계 컬럼값도 null로 바뀐다. 예) 커미션이 null이면 연봉도 null
 *      - IS NULL, IS NOT NULL
 *
 * PK(Primary Key) => 1. Unique(중복되지않아야 한다.)    2. NOT NULL(필수)
 */
-- 실습 5-13-1) 사원테이블에서 부서ID가 null이 아닌 모든 행을 조회(단 부서id로 오름차순 정렬)
SELECT *
    FROM employees
 WHERE department_id IS NOT NULL
ORDER BY department_id;

-- 신설부서
SELECT *
    FROM employees
 WHERE department_id IS NULL
ORDER BY department_id;

-- PK이기때문에 NULL일수가 없다.
SELECT employee_id
    FROM employees
 WHERE employee_id IS NULL
ORDER BY department_id;

-- 실습 5-13-2) 사원테이블의 employee_id, last_name, salary, salary*12+commission_pct 연봉, 
-- commission_pct 검색, salary >= 10000, commission_pct이 null이 아닐때
SELECT employee_id                           "사번"
             , last_name                               "성"
             , salary                                      "급여"
             , salary * 12 + commission_pct "연봉"
             , commission_pct                       "커밋션률"
    FROM employees
 WHERE salary >= 10000
       AND commission_pct IS NOT NULL;

/*
 * 5-14. 합집합
 * -- UNION : 중복제거 / UNION ALL 중복허용
 * -- ORDER BY는 문장의 맨끝
 * -- 합집합, 교집합, 차집합은 테이블간에 갯수와 자료형이 일치해야 한다. 테이블은 달라도 무관
 *
 *~ 다양한 사례의 조회를 묶을때 쓴다.
 */
SELECT employee_id      "사번"
             , last_name          "성"
             , salary                 "급여"
             , department_id    "부서코드"
    FROM employees
 WHERE department_id = 10
   UNION
SELECT employee_id      "사번"
             , last_name          "성"
             , salary                 "급여"
             , department_id    "부서코드"
    FROM employees
 WHERE department_id = 20;

-- UNION ALL -- 중복허용 - 20번부서의 사번, 이름, 급여, 부서ID
SELECT employee_id      --"사번"
             , last_name          --"성"
             , salary                 --"급여"
             , department_id    --"부서코드"
    FROM employees
 WHERE department_id = 20
   UNION ALL
SELECT employee_id      --"사번"
             , last_name          --"성"
             , salary                 --"급여"
             , department_id    --"부서코드"
    FROM employees
 WHERE department_id = 20
 ORDER BY employee_id; /* UNION을 하고, 정렬을 실행하려면, 별칭이 문제가 된다. */

-- 차집합 : MINUS - 10번을 제외한  부서의 사번, 이름, 급여, 부서ID => 전체 사원정보 - 10번부서의 사원정보
SELECT employee_id      --"사번"
             , last_name          --"성"
             , salary                 --"급여"
             , department_id    --"부서코드"
    FROM employees
   MINUS
SELECT employee_id      "사번"
             , last_name          "성"
             , salary                 "급여"
             , department_id    "부서코드"
    FROM employees
 WHERE department_id = 10;
 
 -- 교집합(INTERSECT)
SELECT employee_id      --"사번"
             , last_name          --"성"
             , salary                 --"급여"
             , department_id    --"부서코드"
    FROM employees
INTERSECT
SELECT employee_id      "사번"
             , last_name          "성"
             , salary                 "급여"
             , department_id    "부서코드"
    FROM employees
 WHERE department_id = 30
