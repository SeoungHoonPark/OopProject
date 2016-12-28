/**
 * 
 */
package P1228;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author hong
 *
 */
public class Test05 {
	public Test05() {
		// 여기서 컬렉션을 사용하다가, 데이터를 꺼낼 시점이 되면
		// 밑에 있는 함수에게 자신의 컬렉션을 Iterator로 변환시켜주면 꺼낼 수 있도록 한다.
		
		ArrayList al = new ArrayList();
		
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
//		al.add("태연");
		
//		getData(al.iterator());
		
		HashSet list = new HashSet();
		al.add("태연1");
		al.add("태연2");
		al.add("태연3");
		al.add("태연4");
		al.add("태연5");
		al.add("태연6");
		al.add("태연7");
		al.add("태연8");
		al.add("태연9");
		
		getData(list.iterator());
			
	}
	
	// 데이터를 꺼내기 위한 전용 함수
	void getData(Iterator iter){
		while(iter.hasNext()){
			String temp = (String) iter.next();
			// 지금처럼 순서대로만 꺼낼 수 있다.
			// List는 순서를 보장하고 Set은 보장하지 못하므로 두가지 방식을 혼용하기 위해서는 한쪽이 손해를 봐야 한다.
			System.out.println(temp);
		}
		System.out.println("다시꺼낸다.");
		// 하지만 데이터를 꺼내지 못한다. 한번 꺼낸 데이터는 삭제되지 못한다.+666666666666666666```````````
		
		while(iter.hasNext()){
			String temp = (String) iter.next();
			// 지금처럼 순서대로만 꺼낼 수 있다.
			// List는 순서를 보장하고 Set은 보장하지 못하므로 두가지 방식을 혼용하기 위해서는 한쪽이 손해를 봐야 한다.
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		new Test05();
	}

}
