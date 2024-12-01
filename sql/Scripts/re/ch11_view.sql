//AI서비스_웹과정반 @21일차[오라클7일차]
/**! VIEW(
 *   	CREATE OR REPLACE 'view_name'
 * 		AS
 * 		SELECT *
 * 			FROM 
 *   )
 */
ALTER TABLE pages
        ADD page_name      VARCHAR2(36)   DEFAULT ' ' NOT NULL;

UPDATE pages
        SET page_name = '복습';

--ALTER TABLE pages
--        MODIFY page_name

DESC pages;
SELECT * FROM pages;

-- 해당 페이지의 url을 참조하기만을 위한 용도
CREATE OR REPLACE VIEW v_page_url
AS
SELECT pc.category_name || '/' || p.page_name      "URL"
    FROM page_categories    pc
             , pages                     p
 WHERE p.category_id = pc.category_id
        GROUP BY p.page_name, pc.category_name
WITH READ ONLY;

SELECT * FROM v_page_url;

-- 인라인뷰를 해볼 데이터를 조회
SELECT salary
    FROM emp_tbl
ORDER BY salary DESC;

WITH /* 서브쿼리가 FROM절에 들어가면, 뷰처럼 쓰이게 된다고해서 inline-view */
od AS (SELECT salary
                         FROM emp_tbl
                 ORDER BY salary DESC)
SELECT ROWNUM   "순위"
             , od.*
    FROM od
 WHERE ROWNUM <= 3;
