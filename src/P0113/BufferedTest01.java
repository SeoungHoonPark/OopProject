package P0113;
/*
 * 	���Ͽ� �����ϴ� ���α׷��� ���弼��
 * 	�� Buffered �� ����ϼ���.
 */
import	java.io.*;
public class BufferedTest01 {

	public BufferedTest01() {
		//	1	�ݵ�� Ÿ��(�⺻)�� �ʿ��ϴ�
		FileOutputStream	fout = null;
		//	2.	�ʿ信 ���� ����(����)�� ������ �� �ִ�.
		BufferedOutputStream	bout = null;
		try {
			fout = new FileOutputStream("D:\\����.txt");
			bout = new BufferedOutputStream(fout);
			
			String	str = "������ �����ϼ�(���ó�)";
			byte[] buff = str.getBytes();
			bout.write(buff);
			//	���� �۹��� ���� �ʾ����Ƿ� ������ ������
			//	FileOuputStream���� ���� �ʾҴ�.
			//	�׷��� ������ ���� �ʾҴ�.
			
			//	�ݵ�� ���������� �Ϸ�� �������� ���۸�
			//	���� ������ ������.
			bout.flush();
			
			System.out.println("���峡");
		}
		catch(Exception e) {
			System.out.println("���� = " +  e);
		}
	}

	public static void main(String[] args) {
		new BufferedTest01();
	}
}
