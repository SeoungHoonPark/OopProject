package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *	서버에 접속한 후
 *	특정 데이터를 서버에 보내면
 *	서버가 다시 응답하는 프로그램을 만들어보자.
 */

public class PingClient01 {
	public PingClient01() {
		// 상대방과 통신을 하기 위해서는 통신도구가 필요하다
		// 이 통신 도구의 역활을 하는 클래스가 socket이다.
		
		Socket socket = null;
				
		try{
			// Socket을 만들면 자동적으로 상대방과 접속이 이루어진다.
			socket = new Socket("192.168.35.72", 7777);
			// 포트 번호는 접속받은 프로그램에서 지정한 번호이어야 한다.
			
			// 이제 접속이 되었으므로
			// 상대방과 통신을 하면 된다.
			// 통신 방법은 스트림을 이용해서 처리한다.
			
			// 1. 타겟 스트림 
			// getInputStream()	/ getOutputStream()
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 1 - 1먼저 데이터를 서버에 보내자
			String str = "첫번째 네트워크 프로그램 핑";
			byte[] buff = str.getBytes();
			out.write(buff);
			
			// 서버가 준 데이터를 받아보자.
			buff = new byte[1024];
			int len = in.read(buff);
			str = new String(buff, 0, len);
			System.out.println("클라이언트가 받은 내용 " + str);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PingClient01();
	}

}
