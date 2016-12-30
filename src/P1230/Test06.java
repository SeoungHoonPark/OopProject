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
			map.put("ÇÏÁö¿ø", 26);
			map.put("±èÇÏ´Ã", 28);
			map.put("¼ÛÁöÈ¿", 22);
			map.put("¿À¿¬¼ö", 22);
			map.put("¼ÛÇı±³", 26);
			
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

