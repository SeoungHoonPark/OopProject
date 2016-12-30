/**
 * 
 */
package P1230;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *		
 */
public class Test01 {
	public Test01() {
		Hashtable table = new Hashtable();
		table.put("이름", "홍길동");
		// 이 처럼 map 계열은 데이터를 입력할 때 그 데이터를 구분하는 키값과 한쌍으로 만들어서 입력해야 한다.
		table.put("나이", 24);
		table.put("전번", "010-1111-2222");
		table.put("나이", 34);
		
		// 같은 키값으로 데이터를 입력하면 먼저 데이터가 삭제된 후
		// 새로운ㅇ 데이터가 입력된다.
		// 즉, 같은 키값은 한개의 데이터만 기억할 수 있다.
		table.put("성명", "홍길동");
		// 키 값이 달라지면 같은ㅇ 데이터도 다시 입력 할 수 있다.
		
		int size = table.size();
//		System.out.println(size);
		
		String name1 = (String) table.get("이름");
		int age = (int) table.get("나이");
		
//		System.out.println("이름 = " + name1 + " //  나이 = " + age);
		
		Collection con =  table.values();
		// table이 가지고 있는 내용 중에서 순수하게 데이터만 나오게 한다.
		
		Iterator iter =con.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {
		new Test01();
	}
}
