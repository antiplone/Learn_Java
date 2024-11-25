//AI서비스_웹과정반 @18일차[오라클4일차]
//접속계정 : ot             출처: https://www.oracletutorial.com/getting-started/oracle-sample-database/
/**! GROUP BY-HAVING, JOIN(Equi:Inner, Outer) */
SELECT job_title            "직책"
            , COUNT(*)         "인원"
    FROM employees
GROUP BY job_title;

-- Equi JOIN
SELECT pc.category_name                           "상품"
             , COUNT(*)                                        "품목수"
             , ROUND(AVG(standard_cost), 2)    "가성비가격"
    FROM products                     p
              , product_categories  pc
 WHERE p.category_id = pc.category_id
GROUP BY p.category_id, pc.category_name
ORDER BY p.category_id;

-- RIGHT OUTER JOIN
SELECT pc.category_name                                       "상품"
             , COUNT(p.category_id)                                "품목수"
             , nvl(ROUND(AVG(standard_cost), 2), -1)    "가성비가"
    FROM products                     p
              , product_categories  pc
 WHERE p.category_id(+) = pc.category_id
GROUP BY p.category_id, pc.category_name
ORDER BY p.category_id;

--거래정보
SELECT it.order_id                                    "주문아이디"
             , COUNT(it.item_id)                       "주문가짓수"
             , SUM(it.quantity)                           "총수량"
             , SUM(it.quantity * it.unit_price)     "가치환산"
             , o.status                                        "배송상태"
             , c.name                                        "고객"
             , c.address                                     "배송지"
    FROM orders              o
              , order_items     it
              , customers        c
 WHERE o.order_id = it.order_id
       AND o.customer_id = c.customer_id
GROUP BY it.order_id, o.status, c.name, c.address
    HAVING SUM(it.quantity * it.unit_price) >= 900000
ORDER BY it.order_id;

-- 주문건의 정보
-- 찾고싶은 대상의 하위로 들어가는 컬럼들은 GROUP BY절에 들어간다고 생각하자.
SELECT it.product_id                    "상품코드"
             , pca.category_name         "품목"
             , p.product_name               "상품"
             , p.description                   "세부정보"
             , it.quantity                          "수량"
    FROM order_items              it
      JOIN products                   p
            ON it.product_id = p.product_id
      JOIN product_categories  pca
            ON p.category_id = pca.category_id
 WHERE it.order_id = 2
GROUP BY it.order_id, it.product_id, pca.category_name, p.product_name, p.description, it.quantity
ORDER BY pca.category_name;
