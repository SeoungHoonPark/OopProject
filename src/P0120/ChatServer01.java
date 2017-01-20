package P0120;
/*
 * 	채팅을 관리하는 서버를 만들어보자
 * 
 * 	1.	접속 대기 소켓을 준비한다.
 * 	2.	접속을 받는다.
 */
import	java.net.*;
import	java.io.*;
import	java.util.*;
public class ChatServer01 {
	ServerSocket	server;
	//	내가 준 데이터는 다른 클라이언트에게도 전달해야 한다.
	//	그러므러 서버입장에서는
	//	자신에게 접속한 클라이언트의 정보를 알고 있어야 한다.
	
	//	자신에게 접속한 클라이언트의 정보를 누적해서 기억할 변수
	ArrayList		clientList;
	public ChatServer01() {
		//	접속 대기 소켓을 준비한다.
		try {
			server = new ServerSocket(7788);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		//	접속을 받는데... 계속해서 받아야 하므로
		//	반복처리한다.
		while(true) {
			try {
				Socket	socket = server.accept();
				//	여기서 직접 대화를 나눴다.
				//	오늘은 각각의 클라이언트와 대화하는 프로그램을
				//	독립적으로 만들 예정이다.
				//	그래야 메인 프로그램이 다시 접속을 받을 수 
				//	있기 때문이다.
				
				//	이 접속자와 실제 통신을 아래쪽에 있는 
				//	프로그램을 기동시켜 주어야 한다.
				ClientThread	t = new ClientThread(this, socket);
				clientList.add(t);
				//	t 안에는 그 클라이언트에 대한 모든 정보롤
				//	변수로 준비하고 있으므로 t를 통채로 넣어주면
				//	필요할때 필요한 정보를 꺼내서 사용할 수 있을 것이다.
				t.start();
			}
			catch(Exception e ){
				System.out.println("접속 불량 " + e);
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer01();
	}
}
/*
 * 	각각의 접속한 클라이언트와 대화를 나눌 프로그램을 독립적으로
 * 	제작해서 사용할 예정이다.
 */
class ClientThread extends Thread {
	//	이프로그램은 클라이언트와 대화를 할 목적으로 만든것이다.
	//	당연히 앞쪽에 있는 메인하고 상호 참조를 해야할 것 같다.
	ChatServer01	main;
	//	필수 변수
	//		통신 변수
	Socket			socket;	//	앞에서 이미 이 클라이언트와
							//	통신할 전화기를 만들어 놓았다.
	//	그 전화기를 받아서 사용하자.
	
	PrintWriter		pw;		//	소켓을 알면 만들 수 있는 변수
	BufferedReader	br;
	//	선택 변수
	//		지금 대화하는 클라이언트의 정보를 기억할 변수
	String			ip;		//	소켓을 알면 얻을 수 있는 정보
	
	public ClientThread(ChatServer01 m, Socket s) throws Exception {
		main = m;
		socket = s;
		//	이 부분은 예외처리를 해야하는 부분이다.
		//	문제.....
		//		이 클래스의 목적은 해당 클라이언트와 통신할 목적이다.
		//	근데....
		//		스트림을 만들지 못하면 대화할 수 없다.
		//		이 프로그램의 존재의 이유가 없다.
		InputStream		in = socket.getInputStream();
		OutputStream	out = socket.getOutputStream();
		
		pw = new PrintWriter(out);
		InputStreamReader	temp = new InputStreamReader(in);
		br = new BufferedReader(temp);
	
		InetAddress	inet = socket.getInetAddress();
		ip = inet.getHostAddress();
	}
	void sendRecive(String msg) {
		//	msg 안에는 클라이언트가 준 대화내용이 기억되어있다.
		//		"안녕"		이라고 기억되어 있다.
		//	나는	응답을	[???? 님 말씀] 안녕		이라고 하고싶다.
		
		//	응답할 내용을 꾸며주자
		msg = "[" + ip + " 님 말씀] " + msg;
		
		//	이 내용을 접속한 모든 클라이언트에게 줘야한다.
		int	size = main.clientList.size();
		
		//	참고
		//		응답은 동시에 하지 못하고 한사람씩 반복하면서
		//		응답해야 한다.
		synchronized(main.clientList) {
			for(int i = 0; i < size; i++) {
				//	클라이언트 정보를 꺼낸다.
				ClientThread	temp = 
						(ClientThread) main.clientList.get(i);
				temp.pw.println(msg);
				temp.pw.flush();
			}
		}
	}
	public void run() {
		//	할일
		try {
			while(true) {
				//		요청 받고
				String	msg = br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
				//		응답하고
				sendRecive(msg);
			}
		}
		catch(Exception e) {
			//	이제 이 스레드는 사용을 할 수 없는 스레드이다.
			//	고로..
			//	자신이 사용하던 모든 자원을 닫아주어야겠다.
			try {
				pw.close();
				br.close();
				socket.close();
			}
			catch(Exception e1) {}
			//	이제 이 클라이언트는 접속이 단절되었으므로
			//	접속자 리스트에서 빼주어야 한다.
			main.clientList.remove(this);
		}
	}
}


