/**
 * 
 */
package P1221;

/**
 * @author hong
 *
 */
public class Test04 {
	public Test04() {
		int a = 5;
		int b = 25;
		int c = 0;
		try{
			
		}catch (Exception e) {
			/* Exception e�� �ǹ̴� jvm�� �˷��ִ� ���� ����
			Ŭ������ ���� �غ� �ϴ� ���̴�.
			��, �Լ��� �Ű����� ������ �ϴ� ���̴�.
			�׸��� �� ������ �߻��� ������ ������ ���� Ŭ������ �޶����� ���´�.
			��) 0���� ���� ���� Arithmetic Excetion�� ������
				�迭�� ������ ��� ���� ArrayIndexOutOfBoundsException
			
			��� ���� Ŭ������ ���������� Exception Ŭ������ ������ �ִ�.
			���� Ŭ������ �ּҴ� ���� Ŭ������ ���� �� �ִ�.
			*/
			c = b;
		}
		
	}
	public static void main(String[] args) {
		new Test04();
		
	}
}
