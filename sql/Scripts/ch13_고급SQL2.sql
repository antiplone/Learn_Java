//AI서비스_웹과정반 @22일차[오라클8일차]
/* 1. 분석함수(중요)
- 테이블에 있는 데이터를 특정용도로 분석하여 결과를 반환하는 함수
- PARTITION BY : 계산 대상을 그룹으로 정한다.
- OVER : 분석함수임을 나타내는 키워드
- 분석함수는 그룹별 계산결과를 각 행마다 보여준다.
   분석함수는 그룹함수와 그룹단위로 값을 계산한다는 점에서 유사하지만,
            그룹마다가 아니라 결과 SET의 각 행마다 집계결과를 보여준다.
*/
-- HR 계정에서 실행
-- 각각의 동일 부서의 급여합계
SELECT department_id
	 , employee_id
	 , salary
	 , SUM(SALARY)	OVER(PARTITION BY department_id) AS ""
  FROM EMPLOYEES
ORDER BY department_id;
