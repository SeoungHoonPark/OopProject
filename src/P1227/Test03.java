package P1227;

import java.text.DecimalFormat;

/**
 *
 */
public class Test03 {
	public Test03() {
		float a = 34256.3546f;
		// �� ���ڰ� ���� ������ ��������.
		// ���� �� ���ڸ� 3�ڸ����� .�� ���̰� �Ҽ� ���ϴ� 3�ڸ��� ����ϵ��� �ϰ��� ����.
		
		DecimalFormat f = new DecimalFormat("#,###,###.000");
		
		String str = f.format(a);
		
		System.out.println(str);
		
		
	}
	public static void main(String[] args) {
		new Test03();
	}
}
