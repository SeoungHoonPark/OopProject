package P0113;
/*
 * 	Ű���带 �̿��ؼ� ���ڸ� �Է� �޾ƺ���.
 */
import	java.io.*;
import java.util.Arrays;
public class InputTest01 {
	public InputTest01() {
		//	����	Ű���� ���� �ܺ���ġ�̴�.
		//			���� ����ϴ� �ܺ���ġ�̱� ������...
		//			�̹� ��Ʈ���� �غ��� ������ �����Ѵ�.
		//		System.in �̴�.
		System.out.println("�ѱ��ڸ� �Է��� �ּ���");
		int	ch = 0;
		try {
			//	1.
//			ch = System.in.read();
//			System.out.println("����� �Է��� ���� = " + (char) ch);
//			System.out.println("����� �Է��� ���� = " + ch);
			//	2.	�ڡڡ�
			//	���� ����� ����� ������ �غ��Ѵ�.
//			byte[]	buff = new byte[256];
			//	256�� ���ڿ� ���� �ѹ��� ���� ������ ���� ��������.
//			int	len = System.in.read(buff);
			//	���� ����� ���ڷ� ��ȯ�ؼ� �������.
//			String	str = new String(buff, 0, len);
//			System.out.println("����� �Է��� ���� = " + str);
			//	3.	(�ַ� ��Ʈ��ũ ó���� �Ҷ� ���� ����Ѵ�.)
			byte[]	buff = new byte[256];
			Arrays.fill(buff, (byte)'A');
			int	len = System.in.read(buff,  10, 100);
			//	�غ�� �迭�� buff�� 10������� ���� ������ ����ϼ���
			//	�ִ� 100�������� ��������(100���ڸ� �Է¹޴´�)
			String	str = new String(buff, 0, len + 10);
			System.out.println("����� �Է��� ���� = " + str);
		}
		catch(Exception e) {}
	}
	public static void main(String[] args) {
		new InputTest01();
	}
}
