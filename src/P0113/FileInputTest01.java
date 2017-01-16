package P0113;
/*
 * 	����
 * 		�տ��� ���� InputTest01.java ������ ������ �о��.
 */
import	java.io.*;
public class FileInputTest01 {
	public FileInputTest01() {
		//	���Ϸ� ����� ��Ʈ���� �غ��ؾ� �Ѵ�.
		FileInputStream	fin = null;
		try {
			fin = new FileInputStream("src/M01/P0113/InputTest01.java");
			//	1.	�ѱ��ڸ� ����
//			int	ch = fin.read();
//			System.out.println((char)ch);
			//	2.	���� ���ڸ� ����
//			byte[]	buff = new byte[1024];
//			int	len = fin.read(buff);
//			String	str = new String(buff, 0, len);
//			System.out.println(str);
			
			//	������ ��ü ������ �о��.
			//	����ڸ� �о�� ������ �𸣹Ƿ�....
			while(true) {
				//	�ϴ� �ѹ��� ���緮�� �о��.
				byte[]	buff = new byte[1024];
				int	len = fin.read(buff);
				//	��ȯ���� ���� �������� ���̴�.
				if(len == -1) {
					//	���̻� ���� �����Ͱ� ������ �ݺ��� �����Ѵ�.
					break;
				}
				String	str = new String(buff, 0, len);
				System.out.print(str);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new FileInputTest01();
	}
}
