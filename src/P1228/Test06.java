/**
 * 
 */
package P1228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *	ArrayList�� �����ϰ� ���ڸ� �Է��� ��
 *	�̰��� �����Ͽ� ����϶�.
 */
public class Test06 {
	
	public Test06() {
		
		ArrayList list = new ArrayList();
		
		for(int i = 0; i < 10; i++){
			int temp = (int) (Math.random() * 101);
			list.add(temp);
		}
		System.out.println("���� �� " + list);
		Collections.sort(list, new MySort());
		System.out.println("\n���� �� " + list);
	}
	

	public static void main(String[] args) {
		new Test06();
	}
}
//���� ����� �����ϱ� ���ؼ��� Comparator�� ��ӹ��� Ŭ������ ������ �Ѵ�.

class MySort implements Comparator {

	public int compare(Object o1, Object o2) {
		// �� �Լ��� ������ �� �� ���� ����� 01, 02�� ���޵Ǿ� ���´�.
		// (���� jvm�� �ڵ����� ȣ���ؼ� �ش�)
		// �����ڴ� �� �ΰ��� �����͸� ���ؼ� �ٲ��� ������ �����ϸ� �ȴ�.
		// ��ȯ���� 	1(���)�̸� �ٲ��� ����
		// ��ȯ���� 	0�̸� ���� �������̴�.
		// ��ȯ���� -1(����)�̸� �ٲ۴�.
		
		int temp1 = (int) o1;
		int temp2 = (int) o2;
		
//		if(temp1 == temp2){
//			return 0;
//		}else if(temp1 > temp2){
//			return -1;
//		}else{
//			return 1;
//		}
		
		return -(temp1 - temp2);
	}
}
