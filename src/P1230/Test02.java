/**
 * 
 */
package P1230;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *		ģ�� �̸��� Ű������ �ϰ� �� ģ���� ��ȭ��ȣ�� �����ϴ� map�� ������.
 */
public class Test02 {
	public Test02() {
		Hashtable t = new Hashtable();
		t.put("ȫ�浿", "010-1121-2222");
		t.put("��׷�", "010-1131-2444");
		t.put("�ȱ׷�", "010-1771-2236");
		t.put("�ֱ׷�", "010-1391-2882");
		t.put("�ʱ׷�", "010-1251-0001");
		
		Enumeration en = t.keys();
		while(en.hasMoreElements()){
			String name = (String) en.nextElement();
			// ���� Ű������ ���Ǵ� ģ���̸��� �˾�����...
			// ���� ģ���̸��� �̿��ؼ� �����Ϲ�ȣ���� ������.
			String tel = (String)t.get(name);
			System.out.println(name + " : " + tel);
		}
		
	}

	public static void main(String[] args) {
		new Test02();
	}
}

