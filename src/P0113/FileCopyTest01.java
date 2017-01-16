package P0113;
/*
 * 	파일을 복사하는 프로그램을 만들어보자.
 */
import		java.io.*;
public class FileCopyTest01 {

	public FileCopyTest01() {
		//	할일
		//		스트림을 단방향이다.
		//		복사라는 개념은 한곳에서 읽어서 다른곳에 그대로 쓰면 된다.
		//		그러므로 스트림이 두개 준비되어야 한다.
		FileInputStream		fin = null;		//	원본
		FileOutputStream	fout = null;	//	복사본
		try {
			//	할일
			//		스트림 2개를 연다.
			fin = new FileInputStream("D:\\tae.jpg");
			fout = new FileOutputStream("D:\\질문폴더\\yun.jpg");
			//		한곳에서 읽어서 그대로 다른곳에 쓴다.
			//	몇번 읽어야 할지 모른다.
			while(true) {
				byte[]	buff = new byte[1024];
				int	len = fin.read(buff);
				if(len == -1) {
					break;
				}
				fout.write(buff, 0, len);
			}
			System.out.println("빨래끝");
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
