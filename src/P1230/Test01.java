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
		table.put("�̸�", "ȫ�浿");
		// �� ó�� map �迭�� �����͸� �Է��� �� �� �����͸� �����ϴ� Ű���� �ѽ����� ���� �Է��ؾ� �Ѵ�.
		table.put("����", 24);
		table.put("����", "010-1111-2222");
		table.put("����", 34);
		
		// ���� Ű������ �����͸� �Է��ϸ� ���� �����Ͱ� ������ ��
		// ���ο �����Ͱ� �Էµȴ�.
		// ��, ���� Ű���� �Ѱ��� �����͸� ����� �� �ִ�.
		table.put("����", "ȫ�浿");
		// Ű ���� �޶����� ������ �����͵� �ٽ� �Է� �� �� �ִ�.
		
		int size = table.size();
//		System.out.println(size);
		
		String name1 = (String) table.get("�̸�");
		int age = (int) table.get("����");
		
//		System.out.println("�̸� = " + name1 + " //  ���� = " + age);
		
		Collection con =  table.values();
		// table�� ������ �ִ� ���� �߿��� �����ϰ� �����͸� ������ �Ѵ�.
		
		Iterator iter =con.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {
		new Test01();
	}
}
