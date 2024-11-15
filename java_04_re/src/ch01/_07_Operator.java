package ch01;

//AI서비스_웹과정반 @3일차
public class _07_Operator {

	public static void main(String[] args) {
		/**! 증감:단항(전위, 후위)·관계·논리·복합 연산자 */
		int newVal = 12;
		
		/**!
		 * 단항연산자가 사칙연산자보다 우선순위↑
		 * 같은 변수에는 최종값이 대입
		 */
		System.out.println("=== 증감연산자 ===");
		int beforeOp = ++newVal; /* 전위:증가 */
		System.out.println("beforeOp : " + beforeOp); /*= 13 */
		System.out.println("newVal : " + newVal); /*= 13 */
		
		int afterOp = newVal++; /* 후위:증가 */
		System.out.println(afterOp);
		System.out.println("beforeOp : " + beforeOp); /*= 13 */
		System.out.println("newVal : " + newVal); /*= 14 */

		beforeOp = --newVal; /* 전위:감소 */
		System.out.println("beforeOp : " + beforeOp); /*= 13 */
		System.out.println("newVal : " + newVal); /*= 13 */

		afterOp = newVal--; /* 후위:감소 */
		System.out.println("beforeOp : " + beforeOp); /*= 13 */
		System.out.println("newVal : " + newVal); /*= 12 */


		System.out.println("=== 관계연산자 ===");
		int relateOp = 6;

		boolean relateResult = (newVal == (relateOp * 2)); /* 12 == 12 */
		System.out.println("newVal == relateOp : " + relateResult); /*? true */

		relateResult = (newVal != relateOp); /* 12 != 6 */
		System.out.println("newVal != relateOp : " + relateResult); /*? true */

		relateResult = (newVal > relateOp); /* 12 > 6 */
		System.out.println("newVal > relateOp : " + relateResult); /*? true */

		relateResult = (newVal < relateOp); /* 12 < 6 */
		System.out.println("newVal < relateOp : " + relateResult); /*? false */

		relateResult = (newVal >= relateOp); /* 12 >= 6 */
		System.out.println("newVal >= relateOp : " + relateResult); /*? true */

		relateResult = (newVal <= (relateOp * 2)); /* 12 <= 12 */
		System.out.println("newVal <= relateOp : " + relateResult); /*? true */


		System.out.println("=== 논리연산자 ===");
		int cond1 = 14, cond2 = 3;

		boolean resultLogical = (cond1 == cond2 && cond1 != cond2); /* false (logical*) true */
		System.out.println("cond1 == cond2 && cond1 != cond2 : " + resultLogical); /* false */

		resultLogical = (cond1 == (cond2 + 11) && cond1 != cond2); /* true (logical*) true */
		System.out.println("cond1 == (cond2 + 11) && cond1 != cond2 : " + resultLogical); /* true */
		
		resultLogical = (cond1 == cond2 || cond1 != cond2); /* false (logical+) true */
		System.out.println("cond1 == (cond2 + 11) || cond1 != cond2 : " + resultLogical); /* true */
		
		resultLogical = (cond1 == cond2 || cond1 != (cond2 + 11)); /* false (logical*) false */
		System.out.println("cond1 == cond2 || cond1 != (cond2 + 11) : " + resultLogical); /* false */


		/**! 반복되는 변수를 한번만 쓰려고 한다. **/
		System.out.println("=== 복합대입연산자 ===");
		int vval = 4;

		vval += 8; /*~ vval = vval:4 + 8 */
		System.out.println("vval += : " + vval); /*= 12 */

		vval -= 8; /*~ vval = vval:12 - 8 */
		System.out.println("vval -= : " + vval); /*= 4 */

		vval *= 8; /*~ vval = vval:4 * 8 */
		System.out.println("vval *= : " + vval); /*= 32 */

		vval /= 8; /*~ vval = vval:32 / 8 */
		System.out.println("vval /= : " + vval); /*= 4 */

		vval /= 8; /*~ vval = vval:4 / 8 */
		System.out.println("vval /= : " + vval); /*= 4 */
	}
}
