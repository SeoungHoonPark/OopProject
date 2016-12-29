/**
 * 
 */
package P1229;

import java.util.HashSet;
import java.util.Iterator;

/**
 *		10개의 문자열을 입력한 후 꺼내서 사용하도록 하자.
 */
public class Test01 {

	public Test01() {
		HashSet set = new HashSet();
		set.add("이미자");
		set.add("문주란");
		set.add("아잉유");
		set.add("최순실");
		set.add("김상희");
		set.add("김흥국");
		set.add("김정숙");
		set.add("남희");
		set.add("가일로");
		set.add("마일로");
		set.add("최순실");
		
		int size = set.size();
		
		System.out.println("입력된 수 : " + size);
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			String name = (String) iter.next();
			System.out.println(name);
		}
		
	}
	public static void main(String[] args) {
		new Test01();
	}

}
