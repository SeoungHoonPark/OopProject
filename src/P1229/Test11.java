package P1229;

import java.util.TreeSet;

/**
 *	�����ϰ� �л� ������ 10�� �߻��� ��
 *	60�̻� ������ 60�̸� ������ ���� ��������.
 */
public class Test11 {
	public Test11() {
		TreeSet set = new TreeSet();
		for(int i = 0; i < 10; i++){
			int temp = (int)(Math.random() * 101);
			set.add(temp);
		}
		// 60�� �̸��� �л��� ���� ��������.
		TreeSet minSet = (TreeSet) set.headSet(59);	// ó������ ������ ��
		
		// 60�� �̻��� �л��� ���� ��������.
		TreeSet maxSet = (TreeSet)set.tailSet(60);	// ������ ������ ������
		// ������ ������������ �Ǿ��� ������ �̰��� ������ ���̰� 
		//  ���� ���������� �Ǹ� �ݴ�� ����� ���´�.
		
		System.out.println(set);
		System.out.println("60�� �̸��� " +minSet);
		System.out.println("60�� �̻��� " + maxSet);
	}

	public static void main(String[] args) {
		new Test11();
	}

}
