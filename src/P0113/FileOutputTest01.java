package P0113;/*
 * 	����
 * 		������ ���Ͽ� ������ �����ϴ� ���α׷��� ������.
 */

import		java.io.*;
public class FileOutputTest01 {

	public FileOutputTest01() {
		//	���Ͽ� �����ϱ� ���ؼ��� ���Ϸ� ����� ��Ʈ���� �ʿ��ϴ�.
		FileOutputStream	fout = null;
		try {
			fout = new FileOutputStream("d:\\FileText.txt");
			//	������ �������� �ʾƵ� �ڵ����� ������ش�....
			//	1.	�ѱ��ڸ� �Է�����.
//			fout.write('A');
			//	2.	���� ���ڸ� ����������.
//			String	str = "�״³����� �ϴ��� �췯�� ���� �β��� ���⸦";
//			byte[]	buff = str.getBytes();
//			fout.write(buff);
			
			String	str = "I Am A Boy, My Name is Hong Gil Dong";
			byte[]	buff = str.getBytes();
			fout.write(buff, 12, buff.length - 12);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			//	�ܺ���ġ�� ����� ���� �ش� �ܺ���ġ�� ����� 
			//	������ �ݾ��ִ� ���� ��Ģ�̴�.
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new FileOutputTest01();
	}
}
