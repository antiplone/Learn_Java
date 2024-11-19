package ch10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//AI서비스_웹과정반 @14일차
public class _01_Company {
	private static _01_Company singleton = new _01_Company();

	private ArrayList<String> listID;
	private HashMap<String, _01_Employee> employees;


	private _01_Company(/* default */) {
		String[] ids = {
			"S1001",
			"S1002",
			"S1003",
		};

		listID = new ArrayList<String>(List.of(ids));
		employees = new HashMap<String, _01_Employee>();

		_01_Employee[] info = {
			new _01_Employee("홍길동", "기획", "어딘가"),
			new _01_Employee("김뚜장", "그래픽", "어딘가"),
			new _01_Employee("이팔라", "프로그래머", "어딘가"),
		};

		int i = 0;
		for (String id : listID) {
			employees.put(id, info[i++]);
		}
	}
	public static _01_Company getInstance() {
		if (singleton == null)
			singleton = new _01_Company();

		return singleton;
	}
	
	/** [read-only] */
	public ArrayList<String> getListID() {
		return listID;
	}

	/** [read-only] */
	public HashMap<String, _01_Employee> getEmployees() {
		return employees;
	}


	public void details() {

		for (int i = 0; i < employees.size(); i++) {
			String key = listID.get(i);
			System.out.println(employees.get(key).toString());
		}
	}
}
