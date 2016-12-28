package P1228;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *	10사람의 이름을 입력한 후 정렬해서 출력하세요.
 */
public class Test07 {
	public Test07() {
		LinkedList list = new LinkedList();
		list.add("아이유");
		list.add("전지현");
		list.add("송혜교");
		list.add("송지효");
		list.add("김하늘");
		list.add("김태연");
		list.add("이미자");
		list.add("문주란");
		list.add("이선희");
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		new Test07();
	}
}

class MySort07 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//이 함수는 jvm이 정렬을 시도하는 순간 자동호출되는 함수이다.
		// 이 데이터를 바꿀지 말지만 결정해 주면 된다.
		// 즉 반환값을 양수로 주면 안바꾸고, 음수로 주면 바꾸고, 0으로 주면 같은 데이터.
		
		// 우리는 문자열 두개를 비교해서 바꾸지 말지를 결정해 주면 된다.
		String temp1 = (String)o1;
		String temp2 = (String)o2;
		return -(temp1.compareTo(temp2) );
		
		// compareTo() 
		// 		두 문자의 대소관계를 비교하는 함수이다.
		//		앞의 문자가 크면 양수가 나오고
		// 		뒤의 문자가 크면 음수가 나오고
		// 		두 문자가 같으면 0으로 나온다.
	}
}
