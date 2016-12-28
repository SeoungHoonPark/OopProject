/**
 * 
 */
package P1228;

import java.util.LinkedList;

/**
 *
 */
public class Test04 {

	public Test04() {
		LinkedList list = new LinkedList();
		list.add("태연");
		list.add("서현");
		list.add("효연");
		list.add("제시카");
		list.add("유리");
		list.add("윤아");
		list.add("써니");
		list.add("수영");
		
		int size = list.size();
		
		for(int i = 0; i < size; i++){
			String sosi = (String) list.get(i);
			System.out.println(sosi);
		}		
	}

	public static void main(String[] args) {
		new Test04();
	}

}
