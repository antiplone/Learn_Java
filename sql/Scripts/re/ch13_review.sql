//AI서비스_웹과정반 @22일차[오라클8일차]
-- HR 계정에서 실습
SELECT department_id	/* 그룹화할 일반컬럼 */
	 , job_id			/* 그룹화할 일반컬럼 */
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY ROLLUP(department_id, job_id) /* 소계, 합계 출력 */
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

SELECT department_id	/* 그룹화할 일반컬럼 */
	 , job_id			/* 그룹화할 일반컬럼 */
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY CUBE(department_id, job_id) /* 지정한 모든 열에서 가능한 조합의 결과를 모두 출력 */
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

/* 지정한 모든 열을 각각 대그룹으로 처리 */
SELECT department_id	/* 그룹화할 일반컬럼 */
	 , job_id			/* 그룹화할 일반컬럼 */
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
  FROM employees
GROUP BY GROUPING SETS(department_id, job_id) /* 소계가 없음 */
ORDER BY department_id, job_id;

/* 그룹화 여부 확인 */
SELECT department_id
	 , job_id
	 , COUNT(*)
	 , MAX(salary)
	 , SUM(salary)
	 , ROUND(AVG(salary), 2)
	 , GROUPING(department_id)	-- 그룹화(0), 비그룹화(1), NULL(1)
	 , GROUPING(job_id)			-- 그룹화(0), 비그룹화(1), NULL(1)
  FROM employees
GROUP BY CUBE(department_id, job_id) /* 지정한 모든 열에서 가능한 조합의 결과를 모두 출력 */
ORDER BY department_id, job_id;

/* 일련된 값을 확인할때 */ 
SELECT department_id
	 , LISTAGG(last_name, ', ') /* 그룹에 속해 있는 데이터를 가로로 나열 */
 		  WITHIN GROUP(ORDER BY salary DESC) AS LAST_NAME
  FROM employees
GROUP BY department_id
ORDER BY department_id;
-- 30	Raphaely, Khoo, Baida, Tobias, Himuro, Colmenares

-- 검증
SELECT department_id, salary, last_name
  FROM EMPLOYEES
ORDER BY department_id, salary DESC;

/* 행기준으로 세로로된 표형태로 출력*/
SELECT *
  FROM(SELECT department_id, job_id, salary
  		 FROM employees)
  PIVOT(MAX(salary)
  			FOR department_id IN(10, 20, 30) /* 가로 라벨 */
	   )
ORDER BY job_id;

-- 검증
SELECT job_id, department_id, MAX(salary)
  FROM employees
 WHERE  department_id < 40
GROUP BY  job_id, department_id
ORDER BY department_id; 


/* 특정결과를 그룹화하지않고, 일반컬럼과 비교할수있게 한다. */
SELECT department_id
	 , employee_id
	 , salary
	 , SUM(SALARY)	OVER(PARTITION BY department_id) AS ""
  FROM EMPLOYEES
ORDER BY department_id;
