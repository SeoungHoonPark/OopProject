/**
 * 
 */
package P0102;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author hong
 *
 */
public class Test06 {

	public Test06() {
		HashSet<String> set = new HashSet<String>();
		
		set.add("태연");
		set.add("서현");
		set.add("태효");
		set.add("제시카도쿠라");
		set.add("티파니에서 아침을");
		set.add("윤앙");
		set.add("수영장에서");
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()){
			String name = iter.next();
			System.out.println(name);
		}
	}

	public static void main(String[] args) {

	}
}
