package ch10;

import java.util.List;
import java.util.Map;

//AI서비스_웹과정반 @14일차
public class _01_Main {

	public static void main(String[] args) {
		/**!
		 * 싱글톤(Singleton), Object.toString()재정의,
		 * String메서드(length, concat, replace, substring, toUpper·LowerCase
		 * , split, trim)
		 * StringBuffer(append, insert, subString)
		 * Spread Parameter
		 */
		_01_Company nexon = _01_Company.getInstance();

		List<String> listID = nexon.getListID();
		Map<String, _01_Employee> employees = nexon.getEmployees();
		
		_01_Employee emp1 = employees.get(listID.get(0));
		StringBuffer sb = new StringBuffer();

		String addr = emp1.getAddress();
		if (addr.length() < 4) {
			addr = addr.replace("어딘가", "서울시 서초구쪽");
			sb.append(addr.substring(addr.indexOf("서초구")));
		}

		emp1.setAddress(addr);
		employees.replace(null, null);

		String re = "Report";
		String qu = "question";
		re = re.toLowerCase();
		qu = qu.toUpperCase();

		nexon.details();
		addr = addr.concat("로 이사갔답니다.");
		System.out.println("[" + re + "] " + addr.toString());
		sb.insert(sb.length(), " 확실한가?");
		System.out.println("[" + qu + "] " + sb.toString());
	}

}
