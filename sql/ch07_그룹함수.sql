//AI서비스_웹과정반 @17일차[오라클3일차]
/*
 * ch7. 그룹함수 => 중요
  * 7-1. 그룹함수
 * 7-2. GROUP BY
 * 7-3. HAVING
 */
-- 그룹함수 : 테이블의 전체 데이터중에서 통계적인 결과를 구하기 위해서,
--  하나 이상의 행을 그룹으로 묶어 연산하여 하나의 결과를 구한다.

-- 1. SUM : 합계 그룹함수
SELECT sum(salary)  AS  "급여총액"
    FROM employees;

SELECT salary
    FROM employees;

-- 2. AVG : 평균 그룹함수
-- 급여평균
SELECT avg(salary)  AS  "급여평균"
    FROM employees;

-- 급여평균 : 소수점 3째자리에서 반올림
SELECT ROUND(avg(salary), 2)  AS  "급여평균"
    FROM employees;

-- 급여평균 : 소수점 1째자리에서 반올림
SELECT ROUND(avg(salary))  AS  "급여평균"
    FROM employees;

-- 3. MAX, MIN : 최대값, 최소값 그룹함수
-- 최대급여, 최소급여
SELECT MAX(salary)  AS  "최대급여"
             , MIN(salary)  AS  "최소급여"
    FROM employees;

-- 최근 입사일, 가장 오래된 입사일
SELECT MAX(hire_date)   AS  "최근 입사일"
             , MIN(hire_date)   AS  "가장 오래된 입사일"
    FROM employees;

-- 4. COUNT(*) : 전체행(=row) 갯수를 구하는 그룹함수
-- COUNT(*) : NULL값으로 된 행, 중복된 행을 비롯하여 선택된 모든 행을 카운트한 갯수
-- COUNT(컬럼명) : 컬럼명의 값이 NULL이 아닌 갯수, 중복된 행 포함

-- 사원수
SELECT COUNT(*)     AS  사원수
    FROM employees;

-- 커미션을 받은 사원수
SELECT COUNT(commission_pct)    AS  사원수
    FROM employees;

-- 커미션이 NULL이 아닐때의 comission
SELECT commission_pct    AS  사원수
    FROM employees
 WHERE commission_pct IS NOT NULL;

-- 부서테이블의 부서갯수
SELECT COUNT(department_id)
    FROM departments;

SELECT department_id    AS  사원수
    FROM departments
 WHERE department_id IS NOT NULL;

-- 사원테이블의 부서갯수
SELECT COUNT(department_id)
    FROM employees;

SELECT department_id
    FROM employees
 WHERE department_id IS NULL;

-- 사원테이블에서 부서코드를 중복되지 않게 출력
SELECT DISTINCT department_id
    FROM employees
 WHERE department_id IS NOT NULL;

-- 사원테이블의 급여총액, 최대급여, 최소급여, 급여평균(둘째자리), 사원수
SELECT SUM(salary)  "급여총액"
             , MAX(salary)   "최대급여"
             , MIN(salary)   "최소급여"
             , ROUND(AVG(salary), 2)   "급여평균(둘째자리)"
             , COUNT(*)   "사원수"
    FROM employees;

//AI서비스_웹과정반 @18일차[오라클4일차]
/*
 * 7-2. GROUP BY
 * - 특정 컬럼을 기준으로 그룹별로 나눌때 사용
 * - 형식
 *   SELECT 컬럼1,..컬럼n, 그룹함수
 *     FROM 테이블명
 *    WHERE 조건
 *   GROUP BY 컬럼1,..컬럼n
 *   ORDER BY 컬럼명 ASC | DESC;
 * 
 * - GROUP BY절 다음에 컬럼의 별칭은 사용할 수 없다.
 * - 그룹함수가 아닌 SELECT 리스트의 모든 일반 컬럼은 GROUP BY 절에 반드시 기술해야 한다.(중요)
 *   그러나 반대로 GROUP BY 절에 기술된 컬럼이 반드시 SELECT 리스트에 있어야 하는 것은 아니다. 
 *   단지 결과가 무의미하다.
 */ 
-- 부서별 평균급여
-- SQL Error : ORA-00937: not a single-group group function => 그룹화해주어야 한다.  
SELECT department_id                    AS  부서
             , ROUND(AVG(salary), 2)    AS  평균급여
    FROM employees
GROUP BY department_id
ORDER BY department_id;

-- 부서별, 직무(job_id)별 최대급여 구하기(소수점 둘째자리), 부서정렬
SELECT DECODE( department_id
                    , NULL, '프리랜서'
                    , department_id
               )  "부서"
             , job_id                                     "직무"
             , ROUND(MAX(salary), 2)       "최대급여"
    FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

-- 사원테이블에서 직무(job_id)별 총급여, 최대급여, 최소급여, 직무정렬
SELECT job_id            "직무"
             , sum(salary)  "총급여"
             , max(salary)  "최대급여"
             , min(salary)   "최소급여"
    FROM employees
GROUP BY job_id
ORDER BY job_id;

-- 부서별, 직무(job_id)별 인원수, 급여평균, 최대급여 구하기(소수점 두째자리)
-- 부서, 직무 오름차순 정렬(단, 부서는 NULL 허용안함), 총급여가 10000 이상
SELECT department_id                    "부서"
             , job_id                                  "직무"
             , COUNT(*)                           "총인원"
             , ROUND(AVG(salary), 2)    " 급여평균"
             , MAX(salary)                        "최대급여"
    FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id, job_id
     HAVING MAX(salary) > 10000
ORDER BY department_id, job_id;

/*
 * 7-3. 그룹함수 제한 : HAVING절 => 중요 p190
 * - 표시할 그룹을 지정하여 집계정보를 기준으로 Filtering
 * - HAVING + 그룹함수 조건절
 * - 형식
 *   SELECT 컬럼1,..컬럼n, 그룹함수
 *     FROM 테이블명
 *    WHERE 조건
 *   GROUP BY 컬럼1,..컬럼n
 *   HAVING + 그룹함수 조건절
 *   ORDER BY 컬럼명 ASC | DESC;
 */
-- 부서별 최대급여, 총급여(단 총급여가 15000 이상), 부서코드 오름차순 정렬
-- 부서코드가 없으면 제외
SELECT department_id   "부서"
             , MAX(salary)      "최대급여"
             , SUM(salary)      "총급여"
    FROM employees
WHERE department_id IS NOT NULL /* 일반컬럼일때의 조건 */
GROUP BY department_id
     HAVING SUM(salary) >= 15000 /* 그룹단위일때의 조건 */
ORDER BY department_id;

-- 직무별 총급여, 평균급여(단 평균급여가 5000 이상)
-- 소수점 이하는 무조건 절삭(TRUNC), 직무(job_id) 오름차순 정렬(단 job_id가 IT를 포함할때 조회안되도록)
SELECT job_id                                "직무"
             , SUM(salary)                      "총급여"
             , TRUNC(AVG(salary))       "평균급여"
    FROM employees
WHERE job_id NOT LIKE '%IT%'
GROUP BY job_id
    HAVING AVG(salary) >= 5000
ORDER BY job_id;
