/**
 * 
 */
package P1230;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 */
public class Test06 {

	public Test06() {
			TreeMap map = new TreeMap();
			map.put("������", 26);
			map.put("���ϴ�", 28);
			map.put("����ȿ", 22);
			map.put("������", 22);
			map.put("������", 26);
			
			Set set = map.entrySet();
			Iterator iter = set.iterator();
			
			while(iter.hasNext()){
				Map.Entry temp = (Map.Entry) iter.next();
				
				String name = (String) temp.getKey();
				int age = (int) temp.getValue();
				System.out.println(name + "  :  " + age);
			}
	}

	public static void main(String[] args) {
		new Test06();
	}
}

