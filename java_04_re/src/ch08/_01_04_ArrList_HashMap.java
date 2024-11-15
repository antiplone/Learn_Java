package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//AI서비스_웹과정반 @12일차
public class _01_04_ArrList_HashMap {

	public static void main(String[] args) {
		/**! ArrayList(List), Iterator, HashMap(Map) */
		String[] details = {
			"초봄, 봄, 늦봄이 있다.",
			"초여름, 장마, 한여름, 늦여름이 있다.",
			"초가을, 가을, 늦가을이 있다.",
			"초겨울, 늦겨울, 한겨울이 있다.",
		};
		List<String> season = new ArrayList<String>();
		Map<String, String> maps = new HashMap<String, String>();
		Iterator<String> itor;

		season.add("봄");
		season.add("여름");
		season.add("가을");
		season.add("겨울");

		itor = season.iterator();
		int i = 0;
		while(itor.hasNext()) {
			maps.put(itor.next(), details[i]);
			i += 1;
		}

		for (String names : season) {
			System.out.println(names + "은(는) " +maps.get(names) );
		}
	}
}
