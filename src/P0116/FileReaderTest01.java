package P0116;

import java.io.FileReader;

/**
 *	앞에서 저장해 놓은 파일을 읽어보자
 */
public class FileReaderTest01 {
	
	public FileReaderTest01() {
		FileReader fr = null;
		try{
			fr = new FileReader("d:\\파일테스트.txt");
			
			// 1. 한글자만 읽어보자.
//			int ch = fr.read();
//			System.out.println((char) ch);
			
			// 2. 여러 글자를 읽어보자
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
