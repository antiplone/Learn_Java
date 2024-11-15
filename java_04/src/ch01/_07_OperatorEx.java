package ch01;

//AI서비스_웹과정반 @3일차
public class _07_OperatorEx {

	public static void main(String[] args) {// 올팜 사료
		/* *
		 * 연산
		 * 2.증감연산자 => 매우 중요
		 * 1) 전위연산자 => y = ++x; => x값을 먼저 1증가시키고, 증가한 값을 y에 대입한다.
		 * 2) 후위연산자 => y = x++; => x값을 먼저 y에 대입한 후, x값을 1증가시킨다.
		 */
		System.out.println("=== 2. 증감연산자 ===");

		/* 전위연산자 */
		int c = 5;
		int nextC = ++c;

		System.out.println("c : " + c); /*? 6 */
		System.out.println("nextC : " + nextC); /*? 6 */

		/* 후위연산자 */
		System.out.println("------------------------");
		int d = 5;
		System.out.println("d : " + d); /*? 5 */

		int nextD = d++;
		System.out.println("nextD : " + nextD); /*? 5 */
		System.out.println("d : " + d); /*? 6 */

		/**!
		 * 단항연산자가 사칙연산자보다 우선순위가 높다.
		 * 동일한 변수에는 최종값이 대입된다.
		 * 계산이 복잡하면, 뒤에 있는것은 나중으로 미룬다.
		 */
		System.out.println("------------------------");
		int e = 2, f = 3, result = 0;
		System.out.println(e++ + --f * --e); /* 2 + 2 * 2 */
		System.out.println(++e + --f * e--); /* 3 + 1 * 3//-- */
		System.out.println(e++ + --f * e--); /* 2 + 0 * 3//-- */
		System.out.println("e : " + e); /*? 2 */
		System.out.println("f : " + f); /*? 0 */

		System.out.println("------------------------");
//		result = e++ + --f * e--; /* 2 + -1 * 3//-- = -1 */
		result = ++e + --f * e--; /* 3 + -1 * 3//-- = -1 */
		System.out.println("result : " + result);
		System.out.println("e : " + e); /*? 2 */ /*? 2 */
		System.out.println("f : " + f); /*? -1 */ /*? -1 */

		
		/* *
		 * 연산
		 * 3.관계연산자 => 매우 중요
		 * - >, <, >=, <=, 같다(==), 같지않다(!=)
		 * - 결과값은 boolean 타입 : 참(true), 거짓(false) 
		 */
		System.out.println("=== 3.관계연산자 ===");

		int c1= 10;
		int c2= 20;
		boolean resultEqual = (c1 == c2);
		System.out.println("c1 == c2 : " + resultEqual); /*? false */

		resultEqual = (c1 != c2);
		System.out.println("c1 != c2 : " + resultEqual); /*? true */

		resultEqual = (c1 > c2);
		System.out.println("c1 > c2 : " + resultEqual); /*? false */

		resultEqual = (c1 < c2);
		System.out.println("c1 < c2 : " + resultEqual); /*? true */

		resultEqual = (c1 >= c2);
		System.out.println("c1 >= c2 : " + resultEqual); /*? false */

		resultEqual = (c1 <= c2);
		System.out.println("c1 <= c2 : " + resultEqual); /*? true */


		/* *
		 * 연산
		 * 4.논리연산자 => 매우 중요
		 * - 1 => 참(true) | 0 => 거짓(false)
		 * - &&(논리곱) : 
		 * - ||(논리합) :  
		 */

		System.out.println("=== 4.논리연산자 ===");
		int z1 = 4, y1 = 5;
		boolean resultLogical = z1 == 4 && y1 == 5;
		System.out.println("z1 == 4 && y1 == 5 : " + resultLogical); /*? true (logical*) true = true */

		resultLogical = z1 == 4 && y1 == 10;
		System.out.println("z1 == 4 && y1 == 10 : " + resultLogical); /* true (logical*) false = false */

		resultLogical = z1 == 4 || y1 == 7;
		System.out.println("z1 == 4 || y1 == 7 : " + resultLogical); /* true (logical+) false = true */

		resultLogical = z1 == 7 || y1 == 7;
		System.out.println("z1 == 7 || y1 == 7 : " + resultLogical); /* false (logical+) false = false */


		/* *
		 * 연산
		 * 5.복합대입연산자 => 매우 중요
		 * 반복되는 변수를 한번만 쓰겠다.
		 */
		System.out.println("=== 5.복합대입연산자 ===");

		int ii = 5;

		ii += 10; /*~ ii = ii:5 + 10; */
		System.out.println("ii += : " + ii); /*= 15 */

		ii -= 10; /*~ ii = ii:15 - 10; */
		System.out.println("ii -= : " + ii); /*? 5 */

		ii *= 10; /*~ ii = ii:5 * 10; */
		System.out.println("ii *= : " + ii); /*? 50 */

		ii /= 10; /*~ ii = ii:50 / 10 */
		System.out.println("ii /= : " + ii); /*? 5 */

		ii %= 10; /*~ ii = ii:5 % 10 */
		System.out.println("ii %= : " + ii); /*? 5 */
	}
}
