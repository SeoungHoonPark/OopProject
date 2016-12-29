/**
 * 
 */
package P1229;

import java.util.TreeSet;

/**
 *
 */
public class Test09 {

	public Test09() {
		TreeSet set = new TreeSet();
		
		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");
		// 이 중에서 b로 시작하는 데이터부터 d로 시작하는 데이터 까지만 꺼내서
		// 새로운 set을 만들고자 한다면
		
		TreeSet tempSet = (TreeSet) set.subSet("b","dzzz");
		//이렇게 하면 데이터와 b. d를 comparerTo하여 그 결과에 따라서 뽑아낸다.
		
		System.out.println(tempSet);
		
		
		
		
	}

	public static void main(String[] args) {
		new Test09();
	}
}
