package P0113;
/*
 * 	����
 * 		���������� �ڹ� ���� �ȿ��ִ� ������ ����� �˾Ƴ���
 */
import	java.io.*;
public class FileTest02 {
	public FileTest02() {
		//	����� �˾Ƴ��� ���� ������ ���Ϸ� �����.
		File	dir = new File("D:\\��������\\Java");
		
//		String[]	list = dir.list();
//		for(int i = 0; i < list.length; i++) {
//			String	fileName = list[i];
//			System.out.println(fileName);
//		}
		
//		File[]	list = dir.listFiles();
//		for(int i = 0; i < list.length; i++) {
//			File	fileInfo = list[i];
//			String	fileName = fileInfo.getName();
//			long	len = fileInfo.length();
//			System.out.println(fileName + " : " + len);
//		}
	
		//	Ȯ���ڰ� xlsx�ΰ͸� ��� ����ϰ�ʹ�.
		String[]	list = dir.list(new MyFillter());
		for(int i = 0; i < list.length; i++) {
			String	fileName = list[i];
			System.out.println(fileName);
		}
	}
	public static void main(String[] args) {
		new FileTest02();
	}
}
//	����
//		Ư�� ������ �ִ� ���� �߿��� �̸��� A�� �����ϰ� 
//		Ȯ���ڰ� ???�� ���ϸ� ��� ����غ��ÿ�. 

class MyFillter implements FilenameFilter {
	public boolean accept(File dir, String name)  {
		//	�Ű������� ��Ȱ
		//		File dir		���� ������ ������ �˷��ְ�
		//		String name		���� ������ �̸��� �˷��ش�.
		
		//	�� �Լ��� ���� �ڵ� ȣ���Լ��̴�.
		//	����� ���ϴ� ������ �ϳ��� �߰��Ҷ����� �� �Լ��� ȣ��ȴ�.
		//	�� �Լ����� true�� ��ȯ�ϸ� ��Ͽ� �����ϰ�
		//	�� �Լ����� false�� ��ȯ�ϸ� ��Ͽ��� �����Ѵ�.
		
		if(name.endsWith("xlsx")) {
			return true;			
		}
		else {
			return false;
		}
	}
}







