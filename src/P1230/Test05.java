package P1230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		이름과 나이를 map으로 저장한 후 이것을 나이순서대로 정렬하여 출력하세요. 
 */
public class Test05 {
	public Test05() {
		HashMap map = new HashMap();
		map.put("하지원", 26);
		map.put("김하늘", 28);
		map.put("송지효", 22);
		map.put("오연수", 22);
		map.put("송혜교", 26);
		
		//키 값과 데이터를 동시에 출력하기 위해서 set으로 만들어서 출력하도록 해보겠다.
		
		Set set = map.entrySet();
		ArrayList list = new ArrayList(set);
		Collections.sort(list, new MySort05());
		//리스트안에 있는 데이터는 Map.Entry가 있고 이 안에는 정도가 2개가 있으므로
		// 무엇을 기준으로 해서 정렬할지 모른다.
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry)iter.next();
			String name = (String)	temp.getKey();
			int age = (int)	temp.getValue();
			
			System.out.println(name + " : " + age);
		}
	}

	public static void main(String[] args) {
		new Test05();
	}
}

class MySort05 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// 정렬 기준을 만드세요.
		// o1과 02는 무엇이 들어올까?
		
		Map.Entry temp1 = (Map.Entry)o1;
		Map.Entry temp2 = (Map.Entry)o2;
		
		int age1 = (int)temp1.getValue();
		int age2 = (int)temp2.getValue();
		return age1 - age2;
	}
	
}
