package P1228;

import java.util.Calendar;
import java.util.Vector;

/**
 *	문제
 *		다양한 형태의 데이터를 벡터에 입력한 후 꺼내보자
 */
public class Test02 {
	public Test02() {
		Vector v = new Vector();
		
		v.add("홍길동");
		v.add(10);
		v.add(Calendar.getInstance());
		v.add(3.14f);
		v.add(false);
		// 컬렉션 안에는 모든 데이터를 동시에 보관 할 수 있다.
		
		String name = (String)v.get(0);
		
		for(int i = 0; i < v.size(); i++){
			System.out.println(v.get(i));
		}
		
	}

	public static void main(String[] args) {
		new Test02();
	}
}
