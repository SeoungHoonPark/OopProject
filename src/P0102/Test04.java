/**
 * 
 */
package P0102;

import java.util.ArrayList;

/**
 *		ArrayList에 String 데이터만 입력하도록 제너릭스 처리하여 사용해보자
 */
public class Test04 {

	public Test04() {
		ArrayList<String> list = new ArrayList<String>();
		// 이제 이 list는 String이 아닌 다른 형태의 데이터가 입력되면 에러가 발생한다.
		list.add("홍길동");
		list.add("이길동");
		list.add("박길동");
//		list.add(35);
		
		for(int i = 0; i < list.size(); i++){
			String name = list.get(i);
		}
		System.out.println(list.toString());
		
	}

	public static void main(String[] args) {
		new Test04();
	}
}
