/**
 * 
 */
package P1229;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *	
 */
public class Test06 {
	public Test06() {
		TreeSet set = new TreeSet(new MySort());
		
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
		
	}

	public static void main(String[] args) {
		new Test06();
	}
}

class MySort implements Comparator{
	public int compare(Object o1, Object o2) {
		// �����Ѵ�.
		// �ٲٷ��� ����
		// ������ 0
		// �ٲ��� �������� ���
		
		String temp1 = (String) o1;
		String temp2 = (String) o2;
		
		int imsi = temp1.compareTo(temp2);
		
		return -imsi;
	}
}