/**
 * 
 */
package P1229;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *	
 */
public class Test06 {
	public Test06() {
		TreeSet set = new TreeSet(new MySort());
		
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
		
	}

	public static void main(String[] args) {
		new Test06();
	}
}

class MySort implements Comparator{
	public int compare(Object o1, Object o2) {
		// 정렬한다.
		// 바꾸려면 음수
		// 같으면 0
		// 바꾸지 않으려면 양수
		
		String temp1 = (String) o1;
		String temp2 = (String) o2;
		
		int imsi = temp1.compareTo(temp2);
		
		return -imsi;
	}
}