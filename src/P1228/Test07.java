package P1228;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *	10����� �̸��� �Է��� �� �����ؼ� ����ϼ���.
 */
public class Test07 {
	public Test07() {
		LinkedList list = new LinkedList();
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("����ȿ");
		list.add("���ϴ�");
		list.add("���¿�");
		list.add("�̹���");
		list.add("���ֶ�");
		list.add("�̼���");
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		new Test07();
	}
}

class MySort07 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//�� �Լ��� jvm�� ������ �õ��ϴ� ���� �ڵ�ȣ��Ǵ� �Լ��̴�.
		// �� �����͸� �ٲ��� ������ ������ �ָ� �ȴ�.
		// �� ��ȯ���� ����� �ָ� �ȹٲٰ�, ������ �ָ� �ٲٰ�, 0���� �ָ� ���� ������.
		
		// �츮�� ���ڿ� �ΰ��� ���ؼ� �ٲ��� ������ ������ �ָ� �ȴ�.
		String temp1 = (String)o1;
		String temp2 = (String)o2;
		return -(temp1.compareTo(temp2) );
		
		// compareTo() 
		// 		�� ������ ��Ұ��踦 ���ϴ� �Լ��̴�.
		//		���� ���ڰ� ũ�� ����� ������
		// 		���� ���ڰ� ũ�� ������ ������
		// 		�� ���ڰ� ������ 0���� ���´�.
	}
}
