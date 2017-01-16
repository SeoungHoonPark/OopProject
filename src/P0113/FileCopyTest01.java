package P0113;
/*
 * 	������ �����ϴ� ���α׷��� ������.
 */
import		java.io.*;
public class FileCopyTest01 {

	public FileCopyTest01() {
		//	����
		//		��Ʈ���� �ܹ����̴�.
		//		������ ������ �Ѱ����� �о �ٸ����� �״�� ���� �ȴ�.
		//		�׷��Ƿ� ��Ʈ���� �ΰ� �غ�Ǿ�� �Ѵ�.
		FileInputStream		fin = null;		//	����
		FileOutputStream	fout = null;	//	���纻
		try {
			//	����
			//		��Ʈ�� 2���� ����.
			fin = new FileInputStream("D:\\tae.jpg");
			fout = new FileOutputStream("D:\\��������\\yun.jpg");
			//		�Ѱ����� �о �״�� �ٸ����� ����.
			//	��� �о�� ���� �𸥴�.
			while(true) {
				byte[]	buff = new byte[1024];
				int	len = fin.read(buff);
				if(len == -1) {
					break;
				}
				fout.write(buff, 0, len);
			}
			System.out.println("������");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				fin.close();
				fout.close();
			}
			catch(Exception e) {}
		}
		
		
		
	}
	public static void main(String[] args) {
		new FileCopyTest01();
	}
}
