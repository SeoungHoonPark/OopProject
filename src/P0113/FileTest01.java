package P0113;
/*	1.
 * 	D:\\ �����ϳ��� ������ ������
 * 	2.	
 * 	D:\\ ������ ������ ������ ������
 * 	3.
 * 	������� ������ �ϳ��� ��������.(���� ������ ����, ���� ������ ����)
 */
import	java.io.*;
public class FileTest01 {

	public FileTest01() {
		//	����� ���� ����(��� ���������) ���Ϸ� ������.
		//	1.
//		File	file = new File("D:\\����");
//		file.mkdir();
		
		//	2.
//		File	file = new File("D:\\�׽�Ʈ\\��¥\\�¿�");
//		file.mkdirs();
		
		//	3.
		//	������ ������ File�� �����.(�����ؾ� ����� �ִ�)
		File	file = new File("D:\\����");
		file.delete();
		
		//	4.	Ư�� ������ �̸��� �ٸ� �̸����� ��������.
		//		1)	���� ���ϰ� �ٲ��̸��� ������ �Ѵ� File�� �����.
		File	oldF = new File("d:\\sam.txt");
		File	newF = new File("d:\\sample.txt");
		//		2)	�ٲٸ� �ȴ�.(renameTo)
		oldF.renameTo(newF);
	}

	public static void main(String[] args) {
		new FileTest01();
	}
}
