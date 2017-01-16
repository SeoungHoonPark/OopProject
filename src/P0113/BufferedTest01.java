package P0113;
/*
 * 	파일에 저장하는 프로그램을 만드세요
 * 	단 Buffered 를 사용하세요.
 */
import	java.io.*;
public class BufferedTest01 {

	public BufferedTest01() {
		//	1	반드시 타겟(기본)을 필요하다
		FileOutputStream	fout = null;
		//	2.	필요에 따라서 보조(필터)를 연결할 수 있다.
		BufferedOutputStream	bout = null;
		try {
			fout = new FileOutputStream("D:\\버퍼.txt");
			bout = new BufferedOutputStream(fout);
			
			String	str = "열심히 공부하세(윤시네)";
			byte[] buff = str.getBytes();
			bout.write(buff);
			//	아직 퍼버가 차지 않았으므로 버퍼의 내용이
			//	FileOuputStream으로 가지 않았다.
			//	그래서 저장이 되지 않았다.
			
			//	반드시 습관적으로 완료된 시점에서 버퍼를
			//	비우는 습관을 가진다.
			bout.flush();
			
			System.out.println("저장끝");
		}
		catch(Exception e) {
			System.out.println("에러 = " +  e);
		}
	}

	public static void main(String[] args) {
		new BufferedTest01();
	}
}
