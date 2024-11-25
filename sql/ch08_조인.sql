//AI서비스_웹과정반 @18일차[오라클4일차]
/*
 * 8-1. 조인 => 면접
 * 부서정보
 * 
 * 정보를 제공하는 테이블 => 부모테이블 : 부서T => Primary Key(식별키, PK) => NOT NULL, Unique
 * 정보를 제공받는 테이블 => 자식테이블 : 사원T => Foreign Key(외래키, FK)
 * 
 * - 형식
 * SELECT t1.column, t2.column
 *   FROM table t1, table t2
 *  WHERE t1.column = t2.column
 *    AND 조건식;
 * - 중복컬럼은 테이블명을 붙여야 한다.
 */
-- 부서테이블 조회(20번 부서) => 부모
SELECT department_id
             , department_name
    FROM departments
 WHERE department_id = 20;

-- 사원테이블 조회(20번 부서)
SELECT employee_id
             , first_name
             , department_id
    FROM employees
 WHERE department_id = 20;

-- 10번 부서의 부서ID, 부서명 조회
SELECT e.employee_id
             , e.first_name
             , e.department_id  -- FK
             , d.department_id  -- PK
             , d.department_name 
    FROM employees  e, departments  d
 WHERE d.department_id = e.department_id
      AND d.department_id = 20;

-- [ 사원정보, 부서정보 ]
-- 사원테이블의 사번 101번인 사원의 사번, 부서번호, 부서명 조회
SELECT e.employee_id                                 AS  사번
             , d.department_id                                AS   부서번호
             , d.department_name                          AS   부서명
    FROM employees      e
              , departments     d
 WHERE e.department_id = d.department_id /* Equi Join */
       AND e.employee_id = 101;

-- 방법2. JOIN ~ ON => ,를 JOIN으로 바꾸고, WHERE를 ON으로 바꾸고 첫번째 AND를 WHERE로 바꾼다.
 /*
 - JOIN~ON
 - 중복컬럼은 테이블명을 붙여야 함
 - 테이블명과 테이블명 사이에 콤마(,)대신 JOIN을 사용하고 
 - 공통으로 존재하는 키를 비교(조인조건)하는 WHERE 대신에 ON을 사용한다.
 - 다른 검색이나 필터조건은 WHERE절에 분리해서 기술한다.
 */
 SELECT e.employee_id                                 AS  사번
              , d.department_id                                AS   부서번호
              , d.department_name                          AS   부서명
    FROM employees      e
      JOIN departments     d
         ON e.department_id = d.department_id /* Equi Join */
 WHERE e.employee_id = 101;

-- 60번부서(IT부서)에서 일하는 사원의 사번, last_name, 부서번호, 부서명  
-- 방법1.
SELECT e.employee_id          "사번"
             , e.last_name              "성"
             , d.department_id        "부서코드"
             , d.department_name  "부서명"
    FROM employees      e
              , departments   d
 WHERE e.department_id = d.department_id
       AND e.department_id = 60;
 
--2
SELECT e.employee_id          "사번"
             , e.last_name              "성"
             , d.department_id        "부서코드"
             , d.department_name  "부서명"
    FROM employees      e
       JOIN departments   d
          ON e.department_id = d.department_id
       AND e.department_id = 60;

--------------------------------- 
-- [1. 사원정보, 직무정보 ]
-- 사원테이블의 사번이 110번인 사원의 사번, last_name, 직무ID, 직무타이틀, 최소급여, 최대급여
-- 방법1.
SELECT e.employee_id        "사번"
             , e.last_name            "성"
             , j.job_id                    "직무ID"
             , j.job_title                 "직책"
             , j.min_salary            "최소급여"
             , j.max_salary           "최대급여"
    FROM employees     e
              , jobs                j
 WHERE e.job_id = j.job_id
       AND e.employee_id = 110;

-- 방법2.
SELECT e.employee_id        "사번"
             , e.last_name            "성"
             , j.job_id                    "직무ID"
             , j.job_title                 "직책"
             , j.min_salary            "최소급여"
             , j.max_salary           "최대급여"
    FROM employees     e
      JOIN jobs                j
         ON e.job_id = j.job_id
 WHERE e.employee_id = 110;

----------------------------------
-- [2. 사원정보, 부서정보, 위치정보 ]
-- 100번인 사원의 사번, last_name, 부서테이블의 부서코드, 부서명, 
-- 위치테이블의 location_id, street_address
-- 방법1. 
SELECT e.employee_id            "사번"
             , e.last_name                "성"
             , d.department_id          "부서코드"
             , d.department_name    "부서명"
             , l.location_id                 "위치"
             , street_address             "주소"
    FROM employees        e
              , departments     d
              , locations           l
 WHERE e.department_id = d.department_id
       AND d.location_id = l.location_id
       AND e.employee_id = 100;

-- 방법2. 
SELECT e.employee_id            "사번"
             , e.last_name                "성"
             , d.department_id          "부서코드"
             , d.department_name    "부서명"
             , l.location_id                 "위치"
             , street_address             "주소"
    FROM /* Equi Join은 이게 더 직관적일지도... */
                employees e JOIN departments d
         ON e.department_id = d.department_id JOIN locations l
         ON d.location_id = l.location_id
       WHERE e.employee_id = 100;

-------------------------------------------------
-- [3. 사원정보, 부서정보, 위치정보, 국가정보 ]
-- 101번인 사원의 사번, last_name, 부서테이블의 부서코드, 부서명, 위치테이블의 location_id, street_address, 국가테이블의 id, name
-- 방법1.
SELECT e.employee_id                "사번"
             , e.last_name                    "성"
             , d.department_id              "부서코드"
             , d.department_name        "부서명"
             , l.location_id                     "위치ID"
             , l.street_address               "주소"
             , c.country_id                      "국가코드"
             , c.country_name                "국가"
    FROM employees          e
              , departments       d
              , locations             l
              , countries            c
 WHERE e.department_id = d.department_id
       AND d.location_id = l.location_id
       AND l.country_id = c.country_id
       AND e.employee_id = 101;

-- 방법2.
SELECT e.employee_id                "사번"
             , e.last_name                    "성"
             , d.department_id              "부서코드"
             , d.department_name        "부서명"
             , l.location_id                     "위치ID"
             , l.street_address               "주소"
             , c.country_id                      "국가코드"
             , c.country_name                "국가"
    FROM employees              e
              JOIN departments    d
               ON e.department_id = d.department_id
              JOIN locations          l
               ON d.location_id = l.location_id
              JOIN countries           c
               ON l.country_id = c.country_id
       AND e.employee_id = 101;

-- [4. 사원정보, 부서정보, 위치정보, 국가정보, 지역정보]
-- 100번인 사원의 사번, last_name, 부서테이블의 부서코드, 부서명, 위치테이블의 location_id, street_address, 
-- 국가테이블의 id, name, Regions 테이블의 region_id, region_name
-- 방법1.
SELECT e.employee_id                "사번"
             , e.last_name                    "성"
             , d.department_id              "부서코드"
             , d.department_name        "부서명"
             , l.location_id                     "위치ID"
             , l.street_address               "주소"
             , c.country_id                      "국가코드"
             , c.country_name                "국가"
             , r.region_id                         "지역ID"
             , r.region_name                   "지역명"
    FROM employees      e
              , departments   d
              , locations          l
              , countries         c
              , regions            r
 WHERE e.department_id = d.department_id
       AND d.location_id = l.location_id
       AND l.country_id = c.country_id
       AND c.region_id = r.region_id
       AND e.employee_id = 100;

-- [5. 사원정보, 부서정보, 위치정보, 국가정보, 지역정보, 직무정보(현재), 직무history(이전)]
-- 101번인 사원의 사번, last_name, 부서테이블의 부서코드, 부서명, 위치테이블의 location_id, street_address, 
-- 국가테이블의 id, name, Regions 테이블의 region_id, region_name, 모든 직무정보, 
-- 직무history : start_date : '97/09/21'의 모든 정보 
-- 방법1.
SELECT e.employee_id                "사번"
             , e.last_name                    "성"
             , d.department_id              "부서코드"
             , d.department_name        "부서명"
             , l.location_id                     "위치ID"
             , l.street_address               "주소"
             , c.country_id                      "국가코드"
             , c.country_name                "국가"
             , r.region_id                         "지역ID"
             , r.region_name                   "지역명"
             , j.*
             , jh.*
    FROM employees            e
              , jobs                      j
              , job_history           jh
              , departments         d
              , locations               l
              , countries              c
              , regions                 r
 WHERE e.department_id = d.department_id /* 사원정보면 사원정보 중심으로 Equi Join */
       AND e.job_id = j.job_id
--       AND jh.job_id = j.job_id
       AND e.employee_id = jh.employee_id
       AND d.location_id = l.location_id
       AND l.country_id = c.country_id
       AND c.region_id = r.region_id
--       AND jh.job_id = e.job_id /* FK끼리는 null일수도 있으므로, Join하지 않는다. */
           AND e.employee_id = 101
           AND jh.start_date = '97/09/21';

/*
 * 면접
 *    Outer join
 *  두 테이블간 조인 수행에서 조인 기준열의 어느 한쪽이 null이어도 강제로 출력하는 방식을
 *  외부조인(outer join)이라고 한다.
 * 
 * (+) => 부족한 쪽 즉 null일때 강제출력
 * - left outer join : left가 데이터가 많은쪽 즉 기준이 되는 쪽임
 *   왼쪽 외부조인(Left Outer Join)
 *           예) WHERE table1.col1 = table2.col1(+)
 *            또는 FROM table1 LEFT OUTER JOIN table2 ON 조인조건식
 * 
 * 
 * - right outer join : right가 데이터가 많은쪽 즉 기준이 되는 쪽임
 *   오른쪽 외부조인(Right Outer Join)
 *           예) WHERE table1.col1(+)  = table2.col1
 *            또는 FROM table1 RIGHT OUTER JOIN table2 ON 조인조건식
 * 
 * - full outer join : FROM table1 FULL OUTER JOIN table2 ON 조인조건식
 */
-- 부서ID : 사원테이블(10~110, null) 중복제거 => 11건, null 

-- 부서테이블 조회(20번 부서) => 부모
SELECT department_id
             , department_name
    FROM departments;

-- 사원테이블 조회(20번 부서)
SELECT DISTINCT department_id
    FROM employees
ORDER BY department_id;
 
 -- 10~110 : 부서T, 사원T 모두 존재
 -- 120~270 : 부서T 존재, 사원T nulll
 -- 방법1.
SELECT d.department_id
             , d.department_name
             , e.employee_id
             , d.department_id
             , e.department_id
    FROM departments d
             , employees   e
 WHERE d.department_id =e.department_id(+)
ORDER BY d.department_id;

-- 방법2. LEFT OUTER JOIN
SELECT d.department_id
             , d.department_name
             , e.employee_id
             , d.department_id
             , e.department_id
    FROM departments d
      LEFT OUTER JOIN employees   e
         ON d.department_id =e.department_id
ORDER BY d.department_id;

-- 방법1.
SELECT d.department_id
             , d.department_name
             , e.employee_id
             , d.department_id
             , e.department_id
    FROM departments d
             , employees   e
 WHERE d.department_id(+) =e.department_id
ORDER BY d.department_id;

 -- 방법2. RIGHT OUTER JOIN
 SELECT d.department_id
             , d.department_name
             , e.employee_id
             , d.department_id
             , e.department_id
    FROM departments d
      RIGHT OUTER JOIN employees   e
         ON d.department_id =e.department_id
ORDER BY d.department_id;

 
 -- [ FULL OUTER JOIN ]  => LEFT OUTER JOIN 16건 + RIGHT OUTER JOIN 1건 추가
 -- 방법1. NG
SELECT d.department_id  
     , d.department_name
     , e.employee_id
     , d.department_id "부서-부서"
     , e.department_id "사원-부서"
  FROM departments d
     , employees e
 WHERE d.department_id(+) = e.department_id(+) -- NG
 ORDER BY d.department_id; 
 
-- 방법2.
SELECT d.department_id  
     , d.department_name
     , e.employee_id
     , d.department_id "부서-부서"
     , e.department_id "사원-부서"
  FROM departments d
 FULL OUTER JOIN employees e
    ON d.department_id = e.department_id   -- 10~110 + NULL 1건
 ORDER BY d.department_id;
 