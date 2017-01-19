package P0119;
/*
 * 	여러 클라이언트의 접속을 받아서 핑 시킬수 있는 서버를 만들어보자.
 * 
 * 	m51-849-186
 */
import	java.net.*;
import	java.io.*;
public class PingServer02 {
	public PingServer02() {
		//	1.	접속을 처리할 소켓이 필요하다.
		ServerSocket	server = null;
		try {
			server = new ServerSocket(7777);
		}
		catch(Exception e) {
			//	접속 대기 소켓을 만드는데 문제가 생기면....
			System.out.println(e);
			//	이 프로그램은 몬쓰는 프로그램이다.
			System.exit(0);
		}
		
		//	계속해서 접속을 받아야 하므로...
		//	반복 처리한다
//		try {		
		//	이렇게 하면 누군가가 접속을 하다가 문제가 생기면
		//	while을 빠져나감으로 더이상 접속을 받지 못하게 된다. 
		System.out.println("서버 접속 대기");
		while(true) {
			try {	//	2
				//	이렇게 하면 누군가 접속을 하다가 
				//	문제가 생기더라도
				//	while 명령은 유지하므로
				//	다음 접속을 받을 수 있게 된다.
				Socket	socket = server.accept();
				
				InetAddress inet = socket.getInetAddress();  
				String	ip = inet.getHostAddress();
				System.out.println("[" + ip + "] 님 접속");
				
				InputStream		in = socket.getInputStream();
				OutputStream	out = socket.getOutputStream();
				
				//	먼저 데이터를 받자
				byte[]	buff = new byte[1024];
				int	len = in.read(buff);
				String	str = new String(buff, 0, len);
				System.out.println("서버가 받은 데이터 = " +  str);
				
				//	적당한 내용을 다시 보낸다(응답한다.)
				str = str + " : 잘 받았어요";
				buff = str.getBytes();
				out.write(buff);
			}
			catch(Exception e){}	//	2
		}	//	while
//		catch(Exception e){}
	}

	public static void main(String[] args) {
		new PingServer02();
	}
}
