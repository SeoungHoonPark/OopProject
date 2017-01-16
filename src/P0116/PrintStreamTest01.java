package P0116;

/*
 * 	문제
 * 		시를 한수 파일에 저장해보자.
 */
import		java.io.*;
public class PrintStreamTest01 {
	public PrintStreamTest01() {
		PrintStream		ps = null;
		try {
			ps = new PrintStream("D:\\시.txt");
			//	직접 파일에 연결된 스트림을 만드는 보조스트림이다.
			ps.println("진달래꽃");
			ps.println("김소월");
			ps.println();
			ps.println("나보기가 역겨워 가실때에는");
			ps.println("말없이 고이 보내드리우리다");
			ps.println();
			ps.println("영변의 약산 진달래꽃");
			ps.println("가실길에 아름따다 뿌리우리다.");
			ps.println();
			ps.println("가시는 걸음걸음 놓인 그꽃을");
			ps.println("사뿐이 즈려밟고 가시옵소서");
			ps.println();
			ps.println("나보기 역겨워 가실때에는");
			ps.println("죽어도 아니눈물 흘리우리다.");
			
			ps.flush();
			//	내부적으로  Buffer의 기능을 가지고 있으므로
			//	반드시 내보기가 끝났으면 버퍼를 비워야 한다.
		}
		catch(Exception e) {
			System.out.println("에러 = " +  e);
		}
		finally {
			try {
				ps.close();
				//	close() 명령 안에는 내부적으로  flush 
				//	기능을 포함하고 있다.
				//	close() 를 내리면 자동 flush()가 된다.
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		new PrintStreamTest01();
	}
}
