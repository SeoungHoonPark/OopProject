package P0116;

import java.io.FileWriter;

/**
 * char������ ���Ͽ� �����͸� �����ϴ� ���α׷��� �ۼ��ϼ���.
 */
public class FileWriterTest01 {
	public FileWriterTest01() {
		FileWriter fw = null;
		char[] buff = null;
		try{
			fw = new FileWriter("d:\\�����׽�Ʈ.txt", true);
			// 1. �ѱ��ڸ� �����غ���
//			char  ch = '��';
//			fw.write(ch);
			
			// 2. ���� ���ڸ� ������ ����.
//			String str = "�ϴ��� �췯�� ���� �β��� ���⸦";
//			String str2 = "���Դϴ�.";
//			
//			char[] buff = str.toCharArray();
//			buff = str2.toCharArray();
//			fw.write(buff);
			// ����
			// char ������ �ؽ�Ʈ �����͸� ó���ϵ��� �Ǿ��ֱ� ������
			// �⺻ �Լ��� + ���� ó�� ����� �߰��Ǿ���.
			String str = "�ϴ��� �췯�� ���� �β��� ���⸦";
			fw.write(str);
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				fw.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new FileWriterTest01();
	}

}
