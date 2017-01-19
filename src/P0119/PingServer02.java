package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *		여러 클라이언트의 접속을 받아서 핑 시킬 수 있는 서버를 만들어 보자.
 */
public class PingServer02 {
	public PingServer02() {
		// 1. 접속만을 위한 소켓이 필요하다
		ServerSocket server = null;
		
		try{
			server = new ServerSocket(7777);
			
			Socket socket = server.accept();
			
			InetAddress inet = socket.getInetAddress();
			
			String ip = inet.getHostAddress();
			
			System.out.println("[ " +  ip + "] 님  접속");
						
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
			// 접속 대기 소켓을 만드는데 문제가 생기면
			System.out.println(e);
			//이 프로그램은 못쓰는 프로그램이다.
			System.exit(0);
		}
		// 계속해서 접속을 받아야 하므로..
		// 반복 처리한다.
			while(true){
				try{	// 접속을 하던 도중 문제가 생기더라도 다음 접속은 받아야 하므로 try..catch를 좁게 설정한다.
					
					Socket socket = server.accept();
					// 이 함수는 블로킹 함수이고
					// 이 함수가 실행된다는 말은 접속이 누군가가 되었다는 말이고, 
					// 그 클라이언트를 담당할 전화기를 만들어 준다.
				}catch(Exception e){ }
				
			}
	}

	public static void main(String[] args) {
		new PingServer02();
	}
}
