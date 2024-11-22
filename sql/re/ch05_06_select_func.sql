//AI서비스_웹과정반 @16일차[오라클2일차]
//접속계정 : ot             출처: https://www.oracletutorial.com/getting-started/oracle-sample-database/
/**! 논리곱(AND)·합(OR), 비교연산(=, !=, <·>=, [NOT]IN, BETWEEN val1 AND val2 ), LIKE 'widcards'
 * , IS [NOT] NULL, UNION [ALL], MINUS, INTERSECT, UPPER, LOWER, INITCAP, LENGTH, LENGTHB, SUBSTR
 * , INSTR, REPLACE, L·RPAD, CONCAT, [L·R]TRIM
 */
SELECT contact_id                              "연락처ID"
             , first_name || ' ' || last_name   "이름"
             , phone                                     "전화번호"
    FROM contacts
MINUS
SELECT contact_id                              "연락처ID"
             , first_name || ' ' || last_name   "이름"
             , phone                                     "전화번호"
    FROM contacts
 WHERE customer_id >= 1 AND customer_id <= 300
       AND SUBSTR(phone, 1, 3) IN ('+1 ', '+39', '+41', '+91');
-- 184	Carlos Moody	+86 811 012 4093
-- 185	Javier Kim	+86 123 012 4095
-- 187	Shelia Brewer	+49 89 012 4129
-- 188	Jeri Randall	+49 90 012 4131
-- 189	Jermaine Cote	+49 91 012 4133
-- 198	Colette Estrada	+81 565 012 4567
-- 207	Carita Mcintyre	+86 10 012 4165
-- 210	Jaleesa Bowen	+66 76 012 4633
-- 268	Basilia Downs	+66 76 012 4441
-- 301	Adam Jacobs	+91 80 012 3699
-- 302	Vernia Hayes	+91 80 012 3701
-- 303	Ismael Solomon	+91 80 012 3703
-- 304	Ivey Rutledge	+91 80 012 3709
-- 305	Jame Terrell	+91 80 012 3711
-- 306	Daina Combs	+91 80 012 3715
-- 307	Lashunda Davidson	+91 80 012 3717
-- 308	Arlette Thornton	+91 80 012 3719
-- 309	Darron Robertson	+91 80 012 3723
-- 310	Maple Barnett	+91 80 012 3725
-- 311	Charlsie Carey	+91 80 012 3731
-- 312	Frank Shannon	+91 80 012 3733
-- 313	Josiah Beasley	+91 80 012 3735
-- 314	Annabelle Butler	+91 80 012 3737
-- 315	Ed Mueller	+91 80 012 3739
-- 316	Colleen Estrada	+91 80 012 3741
-- 317	Nikia Kent	+91 80 012 3745
-- 318	Amber Brady	+91 80 012 3837
-- 319	Wendell Massey	+86 10 012 3839

SELECT first_name || ' ' || last_name       "이름" 
             , manager_id                                "상사"
    FROM employees
 WHERE manager_id IS NULL
UNION
SELECT first_name || ' ' || last_name       "이름" 
             , manager_id                                "상사"
    FROM employees
 WHERE manager_id IS NOT NULL
      AND last_name LIKE '_oo%'
      AND hire_date BETWEEN '16-1월-03' AND '16-8월-31';
-- Blake Cooper	1
-- Jessica Woods	1
-- Louis Wood	15
-- Tommy Bailey	사장님

SELECT LENGTH(hire_date)
             , LENGTHB(hire_date)
    FROM employees
 WHERE first_name LIKE 'El%';
-- 9	11
-- 9	11
-- 9	11
-- 9	11
-- 9	11
-- 9	11
-- 9	11
-- 9	11
-- 9	11

SELECT REPLACE(email, 'com', 'net')
    FROM employees
 WHERE job_title = 'Programmer';
-- louie.richardson@example.net
-- nathan.cox@example.net
-- bobby.torres@example.net
-- charles.ward@example.net
-- gabriel.howard@example.net

SELECT SUBSTR(first_name, 1, 1) || '.' || last_name   "이름"
             , email
    FROM employees
 WHERE INITCAP(SUBSTR(email, 1, INSTR(email, '.') - 1 )) LIKE 'Loui%';
-- L.Richardson    louie.richardson@example.com
-- L.Wood  louis.wood@example.com

SELECT SUBSTR(first_name, 1, 1) || '.' || last_name "이름"
             , email
             , phone                                                            "전화번호"
    FROM employees
 WHERE first_name LIKE 'El%'    -- 이름이 El로 시작하는 집합
INTERSECT
SELECT SUBSTR(first_name, 1, 1) || '.' || last_name "이름"
             , email
             , phone                                                            "전화번호"
    FROM employees
WHERE SUBSTR(phone, 1, 3) = '650';  -- 전화번호가 650으로 시작하는 집합
-- E.Black eliza.black@example.com 650.505.2876
-- E.Grant eleanor.grant@example.com   650.501.3876
-- E.Robertson ellie.robertson@example.com 650.509.4876
-- E.Washington    ellis.washington@example.com    650.124.6234
