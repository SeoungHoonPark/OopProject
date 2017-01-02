/**
 * 
 */
package P0102;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		학생점수와 이름을 이용해서 저장하는 map을 만들자
 */
public class Test07 {

	public Test07() {
		HashMap<String, Integer>	map = 
				new HashMap<String, Integer>();
		
		map.put("홍길동", 11);
		map.put("홍길동", 11);
		map.put("홍길동", 11);
		map.put("홍길동", 11);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		
		Iterator<Map.Entry<String, Integer>> iter = set.iterator();
		
		while(iter.hasNext()){
			Map.Entry<String, Integer> temp = (Map.Entry) iter.next();
			
			String key = temp.getKey();
			int value = temp.getValue();
			
		}
	}

	public static void main(String[] args) {
		new Test07();
	}
}
