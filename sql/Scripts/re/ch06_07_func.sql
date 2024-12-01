//AI서비스_웹과정반 @17일차[오라클3일차]
//접속계정 : ot             출처: https://www.oracletutorial.com/getting-started/oracle-sample-database/
/**! ROUND, TRUNC, CEIL, FLOOR, MOD, SYSDATE, MONTHS_BETWEEN, ADD_MONTHS,
 * NEXT_DAY, LAST_DAY, TO_CHAR, TO_NUMBER, TO_DATE, NVL[2], NULLIF, COALESCE,
 * DECODE(pair:CASE문, single:DAFAULT문), CASE [Column] WHEN-THEN-END, 
 * SUM, AVG, MAX, MIN, COUNT([*, Column])
 */
SELECT product_name                                                  "제품 이름"
             , ROUND(standard_cost) || '$'                           "가격(No Cent)"
             , SYSDATE - MOD(list_price, standard_cost)    "입고날짜"   -- 랜덤하게 주려고함
    FROM products
 WHERE category_id = 2
       AND SUBSTR(description, 9, 7) = 'FirePro'
ORDER BY product_id;

SELECT COUNT(*) || '건'  "배송된 건수"
    FROM orders
 WHERE status = 'Shipped'
ORDER BY order_date;

SELECT COUNT(salesman_id) || '건'  "판매자가 있는"
    FROM orders
 WHERE status = 'Shipped'
ORDER BY order_date;

SELECT nvl(state, '대도시') || ' ' || city    "지역"
    FROM locations;

SELECT city
             , DECODE(country_id,
                    'AU',   '호주',
                    'BR',   '브라질',
                    'CA',   '캐나다',
                    'CH',   '스위스',
                    'CN',   '중국',
                    'DE',   '독일',
                    'IN',     '인도',
                    'IT',     '이탈리아',
                    'JP',    '일본',
                    'MX',   '멕시코',
                    'NL',    '네덜란드',
                    'SG',   '싱가포르',
                    'UK',   '영국',
                    'US',   '미국'
               )   "국가"
    FROM locations;

SELECT product_name     "메인보드"
             , CASE
                    WHEN standard_cost < 300
                        THEN 'low-end'
                    WHEN standard_cost < 400
                        THEN 'middle-end'
                    WHEN standard_cost > 400
                        THEN 'high-end'
                END     "성능"
    FROM products
 WHERE SUBSTR(description, 1, 3) = 'CPU'
ORDER BY standard_cost;

SELECT COALESCE(state, city)    "최고범주"
    FROM locations;
