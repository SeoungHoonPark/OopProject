/**
 * 
 */
package P0102;

import java.util.ArrayList;

public class Test08 {
	//	���ʸ� ������ ���ϵ� ī�� ��� ǥ���Ѵ�.
	//	��, � �Լ��� ���ʸ� ����� �÷����� �Ű�������
	//	������
	//	�ڱ� �ڽ� �̿��� �ٸ� Ŭ������ ���ʸ� ����� �͵�
	//	���� �� �ֵ��� �Ѵ�.
	public void abc(ArrayList<Father08> temp) {
		//	�� �Լ��� ArralLis�� �Ű������� �޾Ƽ� ����Ѵ�.
		//	�� �Լ��� �ݵ�� Father08�� ���ʸ� ����� �͸�
		//	�Ű� ������ ���� �� �ִ�.
	}
	public void xyz(ArrayList<? super Father08> temp) {
		//	�� �Լ��� ArralLis�� �Ű������� �޾Ƽ� ����Ѵ�.
		//	�� �Լ��� �ݵ�� Father08�� ���ʸ� ����� �Ͱ�
		//	�� ���� Ŭ������ ���ʸ� ����� ����
		//	�Ű� ������ ���� �� �ִ�.
	}
	public void lmn(ArrayList<? extends Father08> temp) {
		//	Father08�� �� ������ ���ʸ� �����
		//	ArrayList�� ���� �� �ִ�.
	}
	
	public void asdf(ArrayList<?> temp) {
		//	��� ���ʸ� ����� ArrayList �� �� �޴´�.
	}

	public Test08() {
		ArrayList<Father08> list1 = new ArrayList<Father08>();
		asdf(list1);
		
		ArrayList<Grand08> list2 = new ArrayList<Grand08>();
		asdf(list2);

		ArrayList<Son08> list3 = new ArrayList<Son08>();
		asdf(list3);
	}
	
	public static void main(String[] args) {
	}
}

class Grand08 {
	
}
class Father08 extends Grand08 {
	
}
class Son08 extends Father08 {
	
}