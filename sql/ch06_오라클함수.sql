//AI서비스_웹과정반 @16일차[오라클2일차]
/* ch6. 오라클함수
 * 6-2) 대소문자를 바꿔주는 UPPER, LOWER, INITCAP
 * -- UPPER : 대문자로 변환
 * -- LOWER : 소문자로 변환
 * -- INITCAP : 첫글자만 대문자로, 나머지 글자는 소문자로 변환
 */
-- 사원테이블의 last_name이 'King'일 경우 employee_id, last_name 조회
SELECT employee_id
             , last_name
    FROM employees
 WHERE last_name = 'King';

-- 사원테이블의 last_name이 'King'일 경우 employee_id, last_name 조회(INITCAP)
SELECT employee_id
             , last_name
    FROM employees
 WHERE last_name = INITCAP('king');

-- 사원테이블의 last_name이 'King'일 경우 employee_id, last_name 조회(UPPER)
SELECT employee_id
             , last_name
    FROM employees
 WHERE last_name = UPPER('king'); /* KING */

-- 실습 6-3) 사원테이블의 email이 'TFOX'일 경우 email 조회 UPPER(소문자)
SELECT email
    FROM employees
 WHERE email = UPPER('tfox');

 /* 6-4)
 * 문자열 길이를 구하는 LENGTH 함수 : 한글 한문자당 1byte
 * 문자열 길이를 구하는 LENGTHB 함수 : 한글 한문자당 3byte
 */
-- Dual 테이블 : SYS 소유의 테이블로, 오라클에서 제공하는 dummy 테이블, 한 행으로 결과를 출력함, 임시연산, 함수결과 확인용도
-- DUMMY  VARCHAR2(1)라는 하나의 컬럼으로 구성되어 있고, 데이터는 'X'값 
SELECT * FROM dual;     -- X

SELECT LENGTH('안녕') FROM dual;        -- 2
SELECT LENGTHB('안녕') FROM dual;      -- 6
SELECT LENGTH('oracle') FROM dual;      -- 6
SELECT LENGTHB('oracle') FROM dual;    -- 6

SELECT sysdate AS 오늘
             , sysdate + 1 AS 내일
             , sysdate + 2 AS 모레
             , sysdate - 1 AS 어제
             , sysdate - 2 AS 그제
    FROM dual;

/* 6-5)
 * 문자열 일부를 추출하는 SUBSTR 함수.. 인덱스는 1부터 시작
 * - SUBSTR(문자열데이터, 시작위치, [추출갯수]) : 시작위치부터 추출갯수만큼 추출한다.
 * - 시작위치가 양수인 경우 1부터 시작, 음수인 경우 뒤쪽부터 시작
 * - 추출 갯수 생략시 데이터 끝까지 추출
 */ 
SELECT job_id
              , SUBSTR(job_id, 1, 2)
              , SUBSTR(job_id, -2, 2)
              , SUBSTR(job_id, -5)
              , SUBSTR(job_id, 5)
    FROM employees
 WHERE job_id = 'AC_ACCOUNT';
 
 /* 6-6
 * INSTR - 문자열내에 특정문자 위치를 찾아주는 함수
 * 형식 - INSTR(대상, 찾을 글자, 시작위치, 몇번째 발견)
 *     - 시작위치, 몇번째 발견 생략시 모두 1로 간주
 */
SELECT INSTR('HELLO, ORACLE!', 'L') AS instr_1  -- 3
             , INSTR('HELLO, ORACLE!', 'L', 5) AS instr_2  -- 12
             , INSTR('HELLO, ORACLE!', 'L', 2, 2) AS instr_3  -- 4
    FROM dual;

/* 6-7
 * REPLACE - 특정문자를 다른 문자로 바꾸는 REPLACE 함수
 * 형식 - REPLACE(문자열 데이터 또는 열이름(필수), [찾는 문자(필수)], [대체할 문자(선택)] 
 */
SELECT '010-1111-2222' AS "(원본)REPLACE_BEFORE"
             , REPLACE('010-1111-2222', '-', ' ') AS REPLACE_1
             , REPLACE('010-1111-2222', '-', '/') AS REPLACE_2
             , REPLACE('010-1111-2222', '-') AS REPLACE_3
    FROM dual;   
-- 010-1111-2222   010 1111 2222   010/1111/2222   01011112222  

/* 실습 6-8)
 * 데이터의 빈공간을 특정 문자로 채우는 LPAD, RPAD 함수
 * RPAD(대상, 길이, 채울문자) => 오른쪽 채우기
 * LPAD(대상, 길이, 채울문자) => 왼쪽 채우기
 */
SELECT RPAD('971225-', 14, '*') AS RPAD_JUMINNO
    FROM DUAL;

SELECT RPAD('010-8908-', 13, '*') AS RPAD_HPNO
    FROM DUAL;

 /* 실습 6-9)
 * CONCAT - 문자의 값을 연결한다.('||'와 동일)
 */
-- 1.사원테이블에서 사번, 입사일, 이름(first_name-last_name)
SELECT employee_id
             , hire_date
             , first_name || ' ' || last_name  "이름"
    FROM employees;

-- 2.입사년도가 02년도이거나 04년도인 사원의 사번, 입사일(----년 --월 --일), 이름(first_name-last_name)
-- 입사일 순서로 정렬, 별칭사용 => 사번, 입사일
SELECT employee_id                                          "사번"
             , '20' || SUBSTR(hire_date, 1, 2) || '년 '
                     || SUBSTR(hire_date, 4, 2) || '월 '
                     || SUBSTR(hire_date, 7, 2) || '일'   "입사일"
             , first_name || ' ' || last_name                  "이름"
    FROM employees
 WHERE SUBSTR(hire_date, 1, 2) IN (02, 04)
ORDER BY hire_date;

SELECT employee_id                                          "사번"
             , '20' || SUBSTR(hire_date, 1, 2) || '년 '
                     || SUBSTR(hire_date, 4, 2) || '월 '
                     || SUBSTR(hire_date, 7, 2) || '일'   "입사일"
             , first_name || ' ' || last_name                  "이름"
    FROM employees
 WHERE hire_date LIKE '02%'
         OR hire_date LIKE '04%'
ORDER BY hire_date;

/* 실습 6-10)
 * TRIM : 불필요한 공백제거
 * LTRIM : 왼쪽 공백 지우기
 * RTRIM : 오른쪽 공백 지우기
 */
 SELECT '             Orcale mania          '
              , TRIM('             Orcale mania          ') AS trim
              , LTRIM('             Orcale mania          ') AS l_trim
              , RTRIM('             Orcale mania          ') AS r_trim
    FROM dual;

//AI서비스_웹과정반 @17일차[오라클3일차]
/*
 * 6-11. 숫자함수 => 중요
 * ROUND : 지정한 숫자의 특정 위치에서 반올림한 값을 반환
 * TRUNC : 지정한 숫자의 특정 위치에서 버림한 값을 반환
 * CEIL : 지정한 숫자와 가까운 큰 정수 반환
 * FLOOR : 지정한 숫자와 가까운 작은 정수 반환
 * MOD : 숫자를 나눈 나머지 값을 구하는 MOD 함수
 *~
 * 0이전은 계산된 위치와 그뒤로는 0으로 채운다.
 */
/* 내생각에는
 * ROUND(숫자, [(0 <=)소수점표시 자릿수, 0이전은 반올림 위치])가 맞는것 같다.
 * 0이전은 반올림 후 올린위치와 그뒤로는 0으로 채운다.
 */
 -- ROUND(숫자, 반올림위치),  반올림위치가 생략시 0이 생략됨
 -- 반올림위치 0 : 소수점 첫째자리
 -- 반올림위치 -1 : 자연수 첫째자리가 5보다 크면, 반올림을 한후 0으로 채우고, 5보다 작으면 0으로만 채운다.
SELECT ROUND(1234.5678/*,0 */) AS ROUND         -- 1235
     , ROUND(1234.5678, 0) AS ROUND_0    -- 1235
     , ROUND(1234.5678, 1) AS ROUND_1    -- 1234.6
     , ROUND(1234.5678, 2) AS ROUND_2    -- 1234.57
     , ROUND(1234.5678, -1) AS ROUND_M1  -- 1230
     , ROUND(1235.5678, -1) AS ROUND_M1  -- 1240
     , ROUND(1234.5678, -2) AS ROUND_M2  -- 1200
     , ROUND(1254.5678, -2) AS ROUND_M2  -- 1300
  FROM dual;

 -- TRUNC(숫자, 버림위치)                   -- 1234.5678
SELECT TRUNC(1234.5678) AS TRUNC         -- 1234
     , TRUNC(1234.5678, 0) AS TRUNC_0    -- 1234
     , TRUNC(1234.5678, 1) AS TRUNC_1    -- 1234.5
     , TRUNC(1234.5678, 2) AS TRUNC_2    -- 1234.56
     , TRUNC(1234.5678, -1) AS TRUNC_M1  -- 1230
     , TRUNC(1235.5678, -1) AS TRUNC_M2  -- 1230
     , TRUNC(1234.5678, -2) AS TRUNC_M3  -- 1200
     , TRUNC(1254.5678, -2) AS ROUND_M4  -- 1200
  FROM dual;

-- CEIL : 지정한 숫자와 가까운 큰 정수 반환
-- FLOOR : 지정한 숫자와 가까운 작은 정수 반환
SELECT CEIL(3.14)       -- 4    3 ~ 4중 4가 크기때문
             , FLOOR(3.14)   -- 3   3 ~ 4중 3이 작기때문
             , CEIL(-3.14)      -- -3   -4 ~ -3중 -3이 크기때문
             , FLOOR(-3.14)  -- -4  -4 ~ -3중 -4가 작기때문
    FROM dual;

-- MOD : 숫자를 나눈 나머지 값을 구하는 MOD 함수
SELECT MOD(15, 6)
             , MOD(10, 2)
             , MOD(11, 2)
    FROM dual;

/*
 * 6-12
 * 날짜연산, sysdate : 현재일
 */
SELECT sysdate       오늘
             , sysdate - 1  어제
             , sysdate + 1  내일
    FROM dual;

/*
 * 6-13. 날짜함수
 * - 두 날짜간의 개월수 차이를 구하는 MONTHS_BETWEEN 함수
 * - 형식 : MONTHS_BETWEEN(날짜, 날짜)
 */
SELECT sysdate      오늘
             , ROUND(MONTHS_BETWEEN(sysdate, '2024-10-30'), 2)    AS  "개강후 몇개월"
             , ROUND(MONTHS_BETWEEN('2025-05-12','2024-10-30'), 0)    AS  "종강일 개강일 6개월"
             , ROUND(TO_DATE('2025-05-12') - sysdate)    "수업일수"
             , ROUND(TO_DATE('2025-05-12') - TO_DATE('2024-10-31'))    "전체 수업일수"
    FROM dual;

/*
 * 6-14. 날짜함수
 * - 몇 개월 0후 날짜를 더하는 ADD_MONTHS 함수
 * - 형식 : ADD_MONTHS(날짜, 더할 개월수)
 */
SELECT sysdate  오늘
             , ADD_MONTHS(sysdate, 3)   "3개월후"
    FROM dual;

/*
 * 6-15
 * 날짜의 ROUND 반올림 함수, TRUNC 버림 함수
 * 형식 : TRUNC(date, format)
 * TRUNC => format이 'MONTH'인 경우, 달을 기준으로 자른다. 이번달 1일
 * ROUND => format이 'MONTH'인 경우, 일을 기준으로 16보다 작으면 이번달 1일, 16 이상이면 다음달 1일
 */
-- 사원테이블에서 사번, 입사일, T_입사일, R_입사일, 근무개월수, R_근무개월수, T_근무개월수를 구한다. 입사일 오름차순
SELECT employee_id      사번
             , hire_date            입사일
             , TRUNC(hire_date, 'MONTH')            T_입사일
             , ROUND(hire_date, 'MONTH')            R_입사일
             , ROUND(MONTHS_BETWEEN(sysdate, hire_date))            근무개월수
             , ROUND(MONTHS_BETWEEN(sysdate, hire_date))            R_근무개월수
             , TRUNC(MONTHS_BETWEEN(sysdate, hire_date))            T_근무개월수
    FROM employees
ORDER BY hire_date;

/* 6-16
 * - NEXT_DAY : 돌아오는 요일의 날짜 반환 => NEXT_DAY([날짜 데이터], [요일문자])
 *              요일 대신 숫자가 올수 있다.  1:일요일, 2:월요일
 * - LAST_DAY : 달의 마지막 날짜 반환 => LAST_DAY([날짜 데이터])
 */
SELECT sysdate  오늘
             , NEXT_DAY(sysdate, 1/* '일요일' */)     "이번주 일요일"
             , NEXT_DAY(sysdate, '월요일')     "이번주 월요일"
             , NEXT_DAY(sysdate, '화요일')     "이번주 화요일"
             , NEXT_DAY(sysdate, '수요일')     "이번주 수요일"
             , NEXT_DAY(sysdate, '목요일')     "이번주 목요일"
             , NEXT_DAY(sysdate, '금요일')     "이번주 금요일"
             , NEXT_DAY(sysdate, 7/* '토요일' */)     "이번주 토요일"
    FROM dual;

-- 사원테이블에서 사번, 입사일, 입사한 달의 마지막날 조회
SELECT employee_id                  "사번"
             , hire_date                       "입사일"
             , LAST_DAY(hire_date)  "입사한 달의 마지막날"
    FROM employees;

/*
 * TO_CHAR : 숫자 또는 날짜 -> 문자 데이터로 변환
 * TO_NUMBER : 문자 -> 숫자 데이터로 변환
 * TO_DATE : 문자 -> 날짜 데이터로 변환
 */

/*
1. TO_CHAR
- 날짜형 혹은 숫자형을 문자형으로 변환한다. 
- 형식 : TO_CHAR(날짜데이터, '출력형식')
- 날짜 출력 형식
  종류    의미
  YYYY   년도표현(4자리)
  YY     년도표현(2자리)
  MM     월을 숫자로 표현       
  MON    월을 알파벳으로 표현
  DD     일을 숫자로 표현
  DAY    요일 표현
  DY     요일을 약어로 표현
  W      몇 번째 주
  CC     세기
*/
-- 1. TO_CHAR
-- 날짜형 혹은 숫자형을 문자형으로 변환한다. 
-- 형식 : TO_CHAR(날짜데이터, '출력형식')
SELECT sysdate      "오늘"
             , TO_CHAR(sysdate, 'YY/MM/DD DAY')    "YY/MM/DD DAY"
             , TO_CHAR(sysdate, 'YY/MM/DD (DAY)')    "YY/MM/DD (DAY)"
             , TO_CHAR(sysdate, 'YY/MM/DD DY')    "YY/MM/DD DY"
             , TO_CHAR(sysdate, 'YY/MM/DD (DY)')    "YY/MM/DD (DY)"
    FROM dual;

-- 시간 표현
-- 오전 -> AM  |  오후 -> PM
-- 12시간 -> HH:MI:SS    |    24시간 -> HH24:MI:SS
SELECT sysdate      "오늘"
             , TO_CHAR(sysdate, 'YY/MM/DD(DY) HH:MI:SS')              "HH:MI:SS"
             , TO_CHAR(sysdate, 'YY/MM/DD(DY) HH24:MI:SS PM')    "HH24:MI:SS PM"
    FROM dual;
-- 24/11/22(금) 12:37:40
-- 24/11/22(금) 12:37:40 오후

/*  
-- 1-2. TO_CHAR(숫자형) -> 문자형으로 변환한다.  
-- 형식 : TO_CHAR(숫자, '출력형식')  
- L : 각 지역별 통화기호를 앞에 표시 예)한국: ￦   -- 도구-환경설정 -> 검색(돋보기) -> NLS 창에 통화 : ￦으로 설정되어 있음
-  특수문자 : ㄹ+한자키 
- , : 천단위 자리 구분을 표시
- . : 소수점을 표시
- 9 : 자리수를 나타내며, 자리수가 맞지 않아도 0으로 채우지 않는다.
- 0 : 자리수를 나타내며, 자리수가 맞지 않을 경우 나머지 공간을 0으로 채운다.
*/
SELECT employee_id AS 사번
     , salary
     , TO_CHAR(salary, 'L9,999,999') AS "L9" -- L : 각 지역별 통화기호 -- ￦24,000
     , TO_CHAR(salary, 'L0,009,999') AS "L0" -- L : 각 지역별 통화기호 -- ￦0,012,008
     , TO_CHAR(salary, '$9,999,999') AS "$9" -- : shift + 4 -- $24,000
     , TO_CHAR(salary, '$0,009,999') AS "$0" -- : shift + 4 -- $0,024,000
  FROM employees;
--100	24000	           ￦24,000	        ￦0,024,000	    $24,000	 $0,024,000

/*
 * 2. TO_DATE : 문자 -> 날짜 데이터로 변환
 * - 형식 : TO_DATE('문자', '날짜 format')
 */ 
-- 입사일이 03/06/17인 사원의 사번, 입사일 조회
SELECT employee_id      "사번"
             , hire_date            "입사일"
    FROM employees
 WHERE hire_date = TO_DATE('03/06/17');
-- WHERE hire_date = '03/06/17';
-- WHERE TO_CHAR(hire_date) = TO_DATE('03/06/17');

SELECT employee_id      "사번"
             , hire_date            "입사일"
             , TO_CHAR(hire_date, 'YYYY-MM-DD(DY)')            "to_char 입사일"
    FROM employees
 WHERE hire_date = TO_DATE('20030617', 'YYYY/MM/DD');

/*
 * TO_NUMBER 
 * - 문자형을 숫자형으로 바꾼다.
 */ 
SELECT TO_NUMBER('100,000', '999,999') - TO_NUMBER('50,000', '999,999')
  FROM dual;  -- 오류 : 문자열은 산술불가


/*
 * 1. NVL 함수 => 매우 중요
 * - NULL : 미확정, 값이 정해져있지 않아 알수없는 값을 의미하며, 연산, 대입, 비교가 불가능하다.
 *          연산시 관계 컬럼값도 null로 바뀐다.
 * - NVL : 값이 NULL일 경우 연산, 대입, 비교가 불가능하므로 NVL을 이용해 대체
 *         NULL을 0 또는 다른 값으로 변환한다.
 *      문법 : NVL(컬럼값, 초기값)
 *            단 두개의 값은 반드시 데이터 타입이 일치해야 한다.
 */
-- 1.사원테이블의 last_name, salary, salary*12+commission_pct 연봉, commission_pct, salary >= 10000  
SELECT employee_id                                                                  "사번"
             , last_name                                                                      "성"
             , salary                                                                             "급여"
             , salary * 12 + nvl(commission_pct, 0)                             "연봉"
             , salary * 12 + (salary * nvl(commission_pct, 0))              "월 커밋션"
             , salary * 12 + ((salary * 12) * nvl(commission_pct, 0))    "연 커밋션"
             , commission_pct                                                             "커밋션률"
    FROM employees
 WHERE salary >= 10000;

-- 2.LOCATIONS 테이블에서 location_id, city, state_province 조회
-- (단 state_province가 null이 아닌 경우 조회)
SELECT location_id
             , city
             , state_province
    FROM locations
 WHERE state_province IS NOT NULL;

-- 3.LOCATIONS 테이블에서 location_id, city, state_province 조회
-- (단 state_province가 null일 경우 '미정 주'로 출력
SELECT location_id
             , city
             , nvl(state_province, '미정 주')
    FROM locations;

/*
 * NVL2 함수
 * 형식 : NVL2(expr1, expr2, expr3)
 * - expr1이 null이면 expr3을 반환하고, null이 아니면 expr2을 반환
 */
-- 사원테이블의 last_name, salary, salary*12+commission_pct 연봉, commission_pct, salary >= 10000 
SELECT employee_id                                                                      "사번"
             , last_name                                                                          "성"
             , salary                                                                                 "급여"
             , salary * 12 + nvl(commission_pct, 0)                                 "연봉"
             , salary * 12 + nvl2(commission_pct, commission_pct, 0)    "연봉"
             , commission_pct                                                                  "커밋션률"
    FROM employees
 WHERE salary >= 10000;

/*
 * 3. NULLIF 함수
 * - 형식 : NULLIF(expr1, expr2)
 * - 두 표현식을 비교하여 동일하면 null을 반환하고, 동일하지 않으면 첫번째 표현식을 반환
 */
 SELECT NULLIF('A', 'A')  -- null
     , NULLIF('A', 'B')  -- A
  FROM dual;

/*
 * 4. COALESCE
 * - 형식 : COALESCE(expr-1,expr-2,..expr-n)
 * - 인수중에서 NULL이 아닌 첫번째 인수를 반환하는 함수
 */
 -- 사원테이블의 last_name, salary, salary*12+commission_pct 연봉, commission_pct, salary >= 10000  
SELECT employee_id                                                                      "사번"
             , last_name                                                                          "성"
             , salary                                                                                 "급여"
             , salary * 12 + nvl(commission_pct, 0)                                 "연봉"
             , salary * 12 + nvl2(commission_pct, commission_pct, 0)    "nvl2 연봉"
             , salary * 12 + COALESCE(commission_pct, 0)                  "cor 연봉"
    FROM employees
 WHERE salary >= 10000;

/*
 * DECODE 함수 : 자바의 Switch Case문과 동일
 * - 조건에 따라 다양한 선택이 가능
 * - 형식 : DECODE(표현식,
 *                 조건1, 결과1,
 *                 조건2, 결과2,
 *                 조건3, 결과3,..
 *                 기본결과n); 
 */
-- 사번, 이름, job_id, salary, 수당 출력(단 decode를 이용해 수당 출력)
--  표현식   조건        결과
-- job_id : AD_PRES  salary*1.1
--          AD_VP    salary*1.2
--          IT_PROG   salary*1.3
--          FI_MGR    salary*1.4
--          그 외      salary*1.5  AS 수당 
SELECT employee_id      "사번"
             , last_name
             , job_id
             , salary
             , DECODE(job_id,   'AD_PRES',  salary*1.1
                                         ,   'AD_VP',        salary*1.2
                                         ,   'IT_PROG',    salary*1.3
                                         ,   'FI_MGR',       salary*1.4
                                         ,   salary*1.5)    AS "수당"
    FROM employees;

-- CASE문 적용
/*
 * CASE문 : 자바의 if else문과 동일
 * - 형식 : CASE 
 *                WHEN 표현식 조건1 THEN 결과1
 *           WHEN 표현식 조건2 THEN 결과2
 *           WHEN 표현식 조건3 THEN 결과3..
 *              ELSE 결과n                  
 *         END
 */
SELECT employee_id      "사번"
             , last_name
             , job_id
             , salary
             , CASE     job_id  WHEN   'AD_PRES'    THEN  salary*1.1
                                          WHEN   'AD_VP'         THEN  salary*1.2
                                          WHEN   'IT_PROG'     THEN salary*1.3
                                          WHEN   'FI_MGR'        THEN salary*1.4
                                          ELSE   salary*1.5
                END      "수당"
    FROM employees;

-- 사번, 이름, job_id, salary, commission_pct, case문을 이용해 comm_text 출력 
-- comm_text : commission_pct가 null이면 '해당사항 없음'
--                           0이면 '수당 없음'
--                           0보다 크면 연봉 출력 => '연봉 : ' 
SELECT employee_id      "사번"
             , last_name           "이름"
             , job_id                   "직무코드"
             , salary                   "수당"
             , commission_pct   "커밋션률"
             , nvl2(commission_pct
                      , CASE commission_pct
                                    WHEN 0  THEN '수당 없음'
                                ELSE   '연봉 : ' ||  ROUND(salary *12 + commission_pct, 1)
                        END, '해당사항 없음')     "comm_text"
    FROM employees;

SELECT employee_id      "사번"
             , last_name           "이름"
             , job_id                   "직무코드"
             , salary                   "수당"
             , commission_pct   "커밋션률"
              , CASE
                            WHEN commission_pct IS NULL
                                      THEN '해당사항 없음'
                            WHEN commission_pct = 0
                                      THEN '수당 없음'
                            WHEN commission_pct > 0
                                      THEN '연봉 : ' || TO_CHAR(salary *12 + commission_pct)
                END    "comm_text"
    FROM employees;
