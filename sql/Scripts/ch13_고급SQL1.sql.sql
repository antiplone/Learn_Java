//AI서비스_웹과정반 @22일차[오라클8일차]
/* 1. 그룹화와 관련된 여러가지 함수
    ROLLUP, CUBE, GROUPING SETS 함수
    => GROUP BY 절에 지정할 수 있는 특수함수이다.
    
    [형식]
    SELECT 컬럼1, 컬럼2, 그룹함수...
      FROM 테이블명
     WHERE절
     GROUP BY ROLLUP(그룹화할 컬럼1, 컬럼2 ..);
     
     SELECT 컬럼1, 컬럼2, 그룹함수...
      FROM 테이블명
     WHERE절
     GROUP BY CUBE(그룹화할 컬럼1, 컬럼2 ..);

     SELECT 컬럼1, 컬럼2, 그룹함수...
      FROM 테이블명
     WHERE절
     GROUP BY GROUPING SETS(그룹화할 컬럼1, 컬럼2 ..);
*/

-- HR 계정에서 실습
-- 1. 기존 GROUP BY절만 사용한 그룹화
-- 부서별 직무별 그룹함수
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY department_id, job_id
ORDER BY department_id, job_id;

-- 2. ROLLUP 함수를 적용한 그룹화
-- ROLLUP 함수는 명시한 열에 대해 소그룹별 결과를 출력하고, 마지막에 최종결과를 출력한다.
-- ROLLUP 함수에 명시한 열에 한하여 결과가 출력되며, ROLLUP 함수에는 그룹함수를 지정할 수 없다.
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id, job_id;

--10	AD_ASST	1	4400	4400	4400
--10	소계		1	4400	4400	4400
--20	MK_MAN	1	13000	13000	13000
--20	MK_REP	1	6000	6000	6000
--20	소계		2	13000	19000	9500
--......
--null	SA_REP	1	7000	7000	7000
--null			1	7000	7000	7000
--		총계		107	24000	691416	6461.83

-- 3. CUBE 함수를 적용한 그룹화
-- ROLLUP 결과와 동일하게 출력되며, 그 아래에 부서와 상관없이 직책별 결과가 함께 출력된다.
-- CUBE 함수는 지정한 모든 열에서 가능한 조합의 결과를 모두 출력한다.
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY CUBE(department_id, job_id) /* 따로따로 */
ORDER BY department_id, job_id;
--10	AD_ASST	1	4400	4400	4400
--10		1	4400	4400	4400
--20	MK_MAN	1	13000	13000	13000
--20	MK_REP	1	6000	6000	6000
--20		2	13000	19000	9500
--....
--110	AC_ACCOUNT	1	8300	8300	8300
--110	AC_MGR	1	12008	12008	12008
--110		2	12008	20308	10154
--	AC_ACCOUNT	1	8300	8300	8300
--....
--	ST_MAN	5	8200	36400	7280
--		1	7000	7000	7000
--		107	24000	691416	6461.83

-- 4.  GROUPING SETS
-- GROUPING SETS 함수를 사용하여 컬럼별로 그룹으로 묶어 출력하기
-- 지정한 모든 열을 각각 대그룹으로 처리하여 출력
-- CUBE와 같으나 소계가 없음
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY GROUPING SETS(department_id, job_id) /* 따로따로 */
ORDER BY department_id, job_id;

-- 5. GROUPING 함수 : 그룹화(0), 비그룹화(1), NULL(1)
-- 각 한 컬럼씩만 GROUPING 할 수 있다.
-- 부서와 직무의 그룹화 결과 여부를 GROUPING 함수로 확인하기
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
	 , GROUPING(department_id)	-- 한컬럼씩만
	 , GROUPING(job_id)			-- 한컬럼씩만
  FROM employees
GROUP BY CUBE(department_id, job_id) /* 따로따로 */
ORDER BY department_id, job_id;

-- 6. LISTAGG 함수 :   LISTAGG  ~ WITHIN GROUP  => 그룹에 속해 있는 데이터를 가로로 나열할 때 사용
-- 부서별 사원 이름을 나열히 나열해서 출력하기 
SELECT department_id
	 , LISTAGG(last_name, ', ')
 		  WITHIN GROUP(ORDER BY salary DESC) AS LAST_NAME
  FROM employees
GROUP BY department_id
ORDER BY department_id;
-- 30	Raphaely, Khoo, Baida, Tobias, Himuro, Colmenares

-- 검증
SELECT department_id, salary, last_name
  FROM EMPLOYEES
ORDER BY department_id, salary DESC;

-- 7. PIVOT 함수를 사용하여 직책별 부서별 최고급여를 2차원 표형태로 출력하기
SELECT *
  FROM(SELECT department_id, job_id, salary
  		 FROM employees)
  PIVOT(MAX(salary)
  			FOR department_id IN(10, 20, 30) -- 가로 표제목
	   )
ORDER BY job_id;

-- 검증
SELECT job_id, department_id, max(salary)
  FROM employees
 WHERE  department_id < 40
GROUP BY  job_id, department_id
ORDER BY department_id; 
