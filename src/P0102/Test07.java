/**
 * 
 */
package P0102;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		�л������� �̸��� �̿��ؼ� �����ϴ� map�� ������
 */
public class Test07 {

	public Test07() {
		HashMap<String, Integer>	map = 
				new HashMap<String, Integer>();
		
		map.put("ȫ�浿", 11);
		map.put("ȫ�浿", 11);
		map.put("ȫ�浿", 11);
		map.put("ȫ�浿", 11);
		
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
