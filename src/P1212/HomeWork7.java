package P1212;

/**
 ����7
	'A'���� 'Z'������ ������ ���� 10���� �迭�� ���� ������ ��
	�� �迭�� �̿��ؼ�  String Ŭ������ ������ ������.

	int[]	nums = new int[10];
 */
public class HomeWork7 {
	public static void main(String[] args) {
		
		int[] num = new int[10];
		for(int i = 0; i < num.length; i++){
			
			//A~Z������ ������ ����
			num[i] = (int)(Math.random() * ('Z' - 'A' + 1) +'A');
		}
		String str = new String(num, 0, 10);
		System.out.println("str" + str);
	}
}
