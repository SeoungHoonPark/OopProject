/**
 * 
 */
package P1220;

import P1220.Outer05.Inner05;

/**
 * @author hong
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//inner Ŭ���� ���
			//Inner05 in = new Inner05();	//����
			// �ֳ��ϸ� inner Ŭ���� Ư¡�� Ŭ�����̸��� �ٱ�Ŭ�����̸�.����Ŭ�����̸����� ����
			Outer05.Inner05 in = new Outer05.Inner05();
			in.abc();
	}
}

class Outer05{
	
	static class Inner05{
		int a = 10;
		void abc(){
			System.out.println("���� ���� abc�̴�.");
		}
	}
}
