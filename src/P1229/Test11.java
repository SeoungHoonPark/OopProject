package P1229;

import java.util.TreeSet;

/**
 *	랜덤하게 학생 성적을 10개 발생한 후
 *	60이상 점수와 60미만 점수를 따로 관리하자.
 */
public class Test11 {
	public Test11() {
		TreeSet set = new TreeSet();
		for(int i = 0; i < 10; i++){
			int temp = (int)(Math.random() * 101);
			set.add(temp);
		}
		// 60점 미만인 학생만 따로 관리하자.
		TreeSet minSet = (TreeSet) set.headSet(59);	// 처음부터 지정한 곳
		
		// 60점 이상인 학생만 따로 관리하자.
		TreeSet maxSet = (TreeSet)set.tailSet(60);	// 지정한 곳부터 마지막
		// 지금은 오름차순으로 되었기 때문에 이것이 가능한 것이고 
		//  만약 내림차순이 되면 반대로 결과가 나온다.
		
		System.out.println(set);
		System.out.println("60점 미만은 " +minSet);
		System.out.println("60점 이상은 " + maxSet);
	}

	public static void main(String[] args) {
		new Test11();
	}

}
