package P0116;

import java.io.FileReader;

/**
 *	�տ��� ������ ���� ������ �о��
 */
public class FileReaderTest01 {
	
	public FileReaderTest01() {
		FileReader fr = null;
		try{
			fr = new FileReader("d:\\�����׽�Ʈ.txt");
			
			// 1. �ѱ��ڸ� �о��.
//			int ch = fr.read();
//			System.out.println((char) ch);
			
			// 2. ���� ���ڸ� �о��
			char[] buff = new char[1024];
			int len = fr.read(buff);
			
			String str = new String(buff, 0, len);
			
			System.out.println(str);
			
		}catch(Exception e){
			try{
				fr.close();
			}catch(Exception ee){
				
			}
		}
	}
	public static void main(String[] args) {
		new FileReaderTest01();		
	}
}
