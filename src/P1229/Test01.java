/**
 * 
 */
package P1229;

import java.util.HashSet;
import java.util.Iterator;

/**
 *		10���� ���ڿ��� �Է��� �� ������ ����ϵ��� ����.
 */
public class Test01 {

	public Test01() {
		HashSet set = new HashSet();
		set.add("�̹���");
		set.add("���ֶ�");
		set.add("������");
		set.add("�ּ���");
		set.add("�����");
		set.add("���ﱹ");
		set.add("������");
		set.add("����");
		set.add("���Ϸ�");
		set.add("���Ϸ�");
		set.add("�ּ���");
		
		int size = set.size();
		
		System.out.println("�Էµ� �� : " + size);
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			String name = (String) iter.next();
			System.out.println(name);
		}
		
	}
	public static void main(String[] args) {
		new Test01();
	}

}
