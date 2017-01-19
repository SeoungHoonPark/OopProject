package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*	*
 *	클라이언트가 접속하면 접속을 받고 데이터를 보내면 응답하는 서버를 만들어보자
 */
public class PingServer01 {

	public PingServer01() {
		// 대표전화(접속만 받는 전화기)를 만들어 놓는다.
		ServerSocket server = null;
		
		try{
			server = new ServerSocket(7777);
			// 7777번으로 접속을 요청하는 것을 모두 받을 준비를 한다.
			System.out.println("서버 접속 대기...");
			
			//accept() : 실제로 접속을 받아주는 함수			
		    Socket socket = server.accept();
			// 이 함수는 blocking 함수이다.
			// ? 특정한 요건이 만족하지 않으면 실행되지 않는 함수이다.
			// 참고 우리가 배운 함수중에서 System.in.read()도 blocking 함수이다
			// accept()는 누군가가 접속을 해야만 실행하는 함수이다.
			// 이 함수가 실행되었다는 의미는 누군가가 접속을 했다는 것이고
			// 그러면 담당자 전화기를 배정해 주어야 한다.
		    
			// 즉 반환값으로 실제로 통신할 전화기를 배정한다.
		    
			System.out.println("서버 접속 완료");
			
			// 여기까지 실행되었다는 말은 누군가가 접속을 했다는 말이다.
			// 그리고 그 사람하고 통신할 전화기도 배정받았다.
			// 그러면 그 전화기를 이용해서 상대방과 통신을 할 수 있을 것이고..
			// 자바 답게 스트림방식으로 통신을 해야한다.
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 먼저 데이터를 받자
			byte[] buff = new byte[1024];
			int len= in.read(buff);
			
			String str = new String(buff, 0, len);
			System.out.println("서버가 받은 데이터는 " + str);
			
			// 적당한 내용을 다시 보낸다.
			
			str = str + " : 잘 받았습니다.";
			
			buff = str.getBytes();
			out.write(buff);
			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new PingServer01();
	}
}
