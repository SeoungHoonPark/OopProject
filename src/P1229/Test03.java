/**
 * 
 */
package P1229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * hashset�� �̿��ؼ� �����͸� ������ �� ���ϴ� ���·� �����ؼ� ����϶�.
 * list�� set�� ȣȯ�� �ȴ�.
 */
public class Test03 {

	public Test03() {
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
		
		// ���� �����͸� ���������� ����� ���� �Ǹ� 
		// 
		ArrayList list = new ArrayList(set);
		
		Collections.sort(list);
		
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		new Test03();
	}
}
