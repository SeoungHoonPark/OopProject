/**
 * 
 */
package P1222;

/**
 * 	���� Ŭ������ �Ǳ� ���ؼ��� Exception Ŭ������ ��� �޴´�.
 * 	�׷������� ���ܿ� ���õ� ����� �̿� �� �� �ִ�.
 */
public class AgeException extends Exception {
	
	// ������ ������ ����ϱ� ���ؼ���
	// toString()�� �������̵��Ͽ� �ʿ��� ������ ����ϸ� �ȴ�.	
	public String toString(){
		String temp = "���̴� �Ӽ��� �Էµ� �� ����";
		return temp;
	}
}
