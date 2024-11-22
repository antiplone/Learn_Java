//AI서비스_웹과정반 @15일차
/* SQL문 작성시...
 * '문자열'이 아니면, 대소문자를 굳이 구분하지는 않지만,
 * SELET, FROM같은 질의문(Query)만 대문자로 작성해서 구분짓기도 한다.
 *
 * *자료형
 * VARCHAR2(길이)는 가변형이어서, 데이터가 들어있는 만큼만 저장소에 할당한다.
 * NUMBER(소수점 뒷자리 포함, 소수점 뒷자리)는 Java의 정수나, 실수같은 자료형
 */
SELECT/* Table 조회의 시작 '*'는 전체 Column을 조회한다. */
  FROM employees; -- 참조할 Table을 설정합니다.

SELECT /* [DISTINCT:중복제거] 조회할 [Table별칭.][Column1 [[AS] "별칭"], ...columns]
		*~
		* DISTINCT는 열거된 Column들의 값들을 비교해서 중복을 제거한다.
		* 만약, Column1의 값이 동일해도 뒤에오는 Column들의 값이 다르면, 중복이 아니다.
		*
		* Column별칭을 쓸때 ""나 AS를 안써도 되지만, 별칭사이에 공백이 들어가면, ""로 묶으면 된다.
		* 별칭은 Column에 처리문을 간결하게 정리할때나, 다시 구분짓고 싶을때 쓴다.
		* SELECT앞에 무조건 Column만 오는게 아니라, 수식으로 처리된 Column이 될수도 있다.
		* ||은 Java에서는 OR연산이었지만, SQL에서는 문자열 연결할때 쓴다.
		*
		* Table에 별칭이 지정되어있으면, Table의 별칭을 참조해서 Column을 참조할수있다.
		*/
  FROM /* 참조할[Table1 ["별칭"], Table2 ["별칭"] ...tables] */
 WHERE /* 조건식(ex: employee_id = 206)
 		*~
 		* SQL은 '='의미가 대입이 아닌, 비교
 		*/
ORDER BY /* 정렬할[Column1 ([ASC], DESC), Column2 ([ASC], DESC) ...columns]
		  *~
		  * ASC:오름차순 DESC:내림차순
		  * 우선순위(Priority) = 먼저 정의된순(Column1, Column2 ...columns)
		  */

DESC /* Table;
	  *~
	  * 현재 Table의 구조를 보여준다.
	  * Column과 자료형, Nullable을 보여주지만,
	  * 개인적인 생각은 완전한 구조를 파악하기에는 좋지않고,
	  * Column참조시 참고용으로만 쓰기에 좋은것 같다.
	  */
