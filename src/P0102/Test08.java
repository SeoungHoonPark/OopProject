/**
 * 
 */
package P0102;

import java.util.ArrayList;

public class Test08 {
	//	제너릭 선언의 와일드 카드 라고 표현한다.
	//	즉, 어떤 함수가 제너릭 선언된 컬렉션을 매개변수로
	//	받을때
	//	자기 자신 이외의 다른 클래스로 제너릭 선언된 것도
	//	받을 수 있도록 한다.
	public void abc(ArrayList<Father08> temp) {
		//	이 함수가 ArralLis를 매개변수로 받아서 사용한다.
		//	이 함수는 반드시 Father08로 제너릭 선언된 것만
		//	매개 변수로 받을 수 있다.
	}
	public void xyz(ArrayList<? super Father08> temp) {
		//	이 함수가 ArralLis를 매개변수로 받아서 사용한다.
		//	이 함수는 반드시 Father08로 제너릭 선언된 것과
		//	그 상위 클래스로 제너릭 선언된 것을
		//	매개 변수로 받을 수 있다.
	}
	public void lmn(ArrayList<? extends Father08> temp) {
		//	Father08과 그 하위로 제너릭 선언된
		//	ArrayList를 받을 수 있다.
	}
	
	public void asdf(ArrayList<?> temp) {
		//	모든 제너릭 선언된 ArrayList 를 다 받는다.
	}

	public Test08() {
		ArrayList<Father08> list1 = new ArrayList<Father08>();
		asdf(list1);
		
		ArrayList<Grand08> list2 = new ArrayList<Grand08>();
		asdf(list2);

		ArrayList<Son08> list3 = new ArrayList<Son08>();
		asdf(list3);
	}
	
	public static void main(String[] args) {
	}
}

class Grand08 {
	
}
class Father08 extends Grand08 {
	
}
class Son08 extends Father08 {
	
}