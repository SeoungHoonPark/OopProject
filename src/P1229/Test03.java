/**
 * 
 */
package P1229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * hashset을 이용해서 데이터를 저장한 후 원하는 형태로 정렬해서 사용하라.
 * list와 set은 호환이 된다.
 */
public class Test03 {

	public Test03() {
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
		
		// 이제 데이터를 마지막으로 출력할 때가 되면 
		// 
		ArrayList list = new ArrayList(set);
		
		Collections.sort(list);
		
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		new Test03();
	}
}
