/**
 * 
 */
package P1230;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *		친구 이름을 키값으로 하고 그 친구의 전화번호를 관리하는 map을 만들어보자.
 */
public class Test02 {
	public Test02() {
		Hashtable t = new Hashtable();
		t.put("홍길동", "010-1121-2222");
		t.put("장그래", "010-1131-2444");
		t.put("안그래", "010-1771-2236");
		t.put("왜그래", "010-1391-2882");
		t.put("너그래", "010-1251-0001");
		
		Enumeration en = t.keys();
		while(en.hasMoreElements()){
			String name = (String) en.nextElement();
			// 이제 키값으로 사용되는 친구이름을 알았으니...
			// 나는 친구이름을 이용해서 저노하번호까지 꺼내자.
			String tel = (String)t.get(name);
			System.out.println(name + " : " + tel);
		}
		
	}

	public static void main(String[] args) {
		new Test02();
	}
}

