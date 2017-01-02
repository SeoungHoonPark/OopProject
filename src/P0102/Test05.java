/**
 * 
 */
package P0102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 
 */
public class Test05 {

	public Test05() {
		HashSet<String> set = new HashSet<String>();
		
		set.add("태연");
		set.add("서현");
		set.add("태효");
		set.add("제시카도쿠라");
		set.add("티파니에서 아침을");
		set.add("윤앙");
		set.add("수영장에서");
		
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list);
		int size = list.size();
		
		for(int i = 0; i < size; i++){
			String name = list.get(i);
			
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
