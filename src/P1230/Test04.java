/**
 * 
 */
package P1230;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		�̸��� ��ȭ��ȣ�� �ѽ����� �ϴ� map�� �ϳ� ������
 */
public class Test04 {

	public Test04() {
		HashMap map = new HashMap();
		map.put("ȫ�浿", "123");
		map.put("��׷�", "456");
		map.put("�ȱ׷�", "789");
		map.put("�ֱ׷�", "915");
		map.put("��׷�", "157");
		
		//�̰��� ����ϴٺ��� ���� �����ؼ� set���� ��ȯ���Ѽ� ����ϱ⸦ ���Ѵ�.
		
		Set set = map.entrySet();
		//map�� set���� ��ȯ�ɶ� key, value�� �ϳ��� ������ �Ѵ�.
		// �̶� ���Ǵ� vo�� map.entry�� �ȴ�.
		// ���
		//		set�ȿ��� map.entry�� �����ǰ�
		//		map.entry�ȿ� key, value�� ���� �����̴�.
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry) iter.next();
			
			String name = (String)temp.getKey();
			String tel = (String)temp.getValue();
		}
	}

	public static void main(String[] args) {
		new Test04();
	}
}
