package P0113;
/*
 * 	문제
 * 		앞에서 만든 InputTest01.java 파일의 내용을 읽어보자.
 */
import	java.io.*;
public class FileInputTest01 {
	public FileInputTest01() {
		//	파일로 연결된 스트림을 준비해야 한다.
		FileInputStream	fin = null;
		try {
			fin = new FileInputStream("src/M01/P0113/InputTest01.java");
			//	1.	한글자만 읽자
//			int	ch = fin.read();
//			System.out.println((char)ch);
			//	2.	여러 글자를 읽자
//			byte[]	buff = new byte[1024];
//			int	len = fin.read(buff);
//			String	str = new String(buff, 0, len);
//			System.out.println(str);
			
			//	파일의 전체 내용을 읽어보자.
			//	몇글자를 읽어야 끝날지 모르므로....
			while(true) {
				//	일단 한번에 적당량을 읽어보자.
				byte[]	buff = new byte[1024];
				int	len = fin.read(buff);
				//	반환값은 읽은 데이터의 양이다.
				if(len == -1) {
					//	더이상 읽은 데이터가 없으면 반복을 중지한다.
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
