package P1230;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *		학생의 이름을 이용해서 점수를 관리하는 map을 만들어보자		
 */
public class Test03 {

	public Test03() {
		HashMap map = new HashMap();
		map.put("홍길동", new Student03("홍길동", 65, 77, 45));
		map.put("장그래", new Student03("장그래", 65, 77, 45));
		map.put("안그래", new Student03("안그래", 65, 77, 45));
		map.put("왜그래", new Student03("왜그래", 65, 77, 45));
		map.put("김그래", new Student03("김그래", 65, 77, 45));
		
		Set set = map.keySet();
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			String name = (String) iter.next();
			//키값을 알면 데이터도 꺼 낼 수 있다.
			Student03 temp = (Student03) map.get(name);
			System.out.println(name +	" : " + temp.tot);
		}
	}

	public static void main(String[] args) {
		new Test03();
	}
}


 class Student03 {
	 String name;
	 int kor;
	 int eng;
	 int mat;
	 int tot;
	 
	public Student03() {
	}
	
	public Student03(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		mat = m;
		tot = kor + eng + mat;
	}
	
 }
 