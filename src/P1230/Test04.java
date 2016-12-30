/**
 * 
 */
package P1230;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		이름과 전화번호를 한쌍으로 하는 map을 하나 만들어보자
 */
public class Test04 {

	public Test04() {
		HashMap map = new HashMap();
		map.put("홍길동", "123");
		map.put("장그래", "456");
		map.put("안그래", "789");
		map.put("왜그래", "915");
		map.put("김그래", "157");
		
		//이것을 사용하다보니 조금 불편해서 set으로 변환시켜서 사용하기를 원한다.
		
		Set set = map.entrySet();
		//map이 set으로 변환될때 key, value로 하나로 묶여야 한다.
		// 이때 사용되는 vo가 map.entry가 된다.
		// 결론
		//		set안에는 map.entry가 저정되고
		//		map.entry안에 key, value가 기억된 상태이다.
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry) iter.next();
			
			String name = (String)temp.getKey();
			String tel = (String)temp.getValue();
		}
	}

	public static void main(String[] args) {
		new Test04();
	}
}
