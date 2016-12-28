/**
 * 
 */
package P1228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *	ArrayList에 랜덤하게 숫자를 입력한 후
 *	이것을 정렬하여 출력하라.
 */
public class Test06 {
	
	public Test06() {
		
		ArrayList list = new ArrayList();
		
		for(int i = 0; i < 10; i++){
			int temp = (int) (Math.random() * 101);
			list.add(temp);
		}
		System.out.println("정렬 전 " + list);
		Collections.sort(list, new MySort());
		System.out.println("\n정렬 후 " + list);
	}
	

	public static void main(String[] args) {
		new Test06();
	}
}
//정렬 방식을 변경하기 위해서는 Comparator를 상속받은 클래스를 만들어야 한다.

class MySort implements Comparator {

	public int compare(Object o1, Object o2) {
		// 이 함수느 정렬을 할 때 비교할 대상이 01, 02이 전달되어 들어온다.
		// (물론 jvm이 자동으로 호출해서 준다)
		// 개발자는 이 두개의 데이터를 비교해서 바꿀지 말지만 결정하면 된다.
		// 반환값이 	1(양수)이면 바꾸지 말라
		// 반환값이 	0이면 같은 데이터이다.
		// 반환값이 -1(음수)이면 바꾼다.
		
		int temp1 = (int) o1;
		int temp2 = (int) o2;
		
//		if(temp1 == temp2){
//			return 0;
//		}else if(temp1 > temp2){
//			return -1;
//		}else{
//			return 1;
//		}
		
		return -(temp1 - temp2);
	}
}
