/**
 * 
 */
package P1229;

import java.util.TreeSet;

/**
 *		랜덤한 숫자 10개를 발생하고, 학생의 성적으로 가정한다.
 *		이 중에서 80~100사이의 점수만 따로 뽑아서 관리하고자 한다.
 */
public class Test10 {

	public Test10() {
		TreeSet set = new TreeSet();
		for(int i = 0; i < 10; i++){
			int temp = (int)(Math.random() * 101);
			set.add(temp);
		}
		// 학생의 점수를 입력해 놓았다...
		
		System.out.println(set);
		
		TreeSet tempSet = (TreeSet) set.subSet(80, 100);
		
		System.out.println(tempSet);
	}

	public static void main(String[] args) {
			new Test10();
	}
}
