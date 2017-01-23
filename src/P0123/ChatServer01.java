package P0123;
/*
 * 	채팅 서버 제작
 */
import		java.net.*;
import		java.io.*;
import		java.util.*;
public class ChatServer01 {
	ServerSocket	server;
	ArrayList		clientList;	//	접속자를 관리할 목적으로
	public ChatServer01() {
		//	할일
		//	1.	대표전화 준비한다.
		try {
			server = new ServerSocket(8877);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		System.out.println("서버 실행중");
		while(true) {
			try {
				//	2.	접속을 받는다.
				Socket	socket = server.accept();
				//	3.	해당 클라이언트와 통신할 전담
				//		프로그램을 만들어서 배정한다.
				//		이 프로그램은 독립적으로 실행되어야 하며
				//		스레드로 만들어야 한다.
				ClientThread	t = new ClientThread(this, socket);
				//	위의 클래스는 예외전위된 클래스이므로
				//	문제가 생기면 start되지 않을 것이다.
				clientList.add(t);
				t.start();
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		new ChatServer01();
	}
}
/*
 * 	각각의 클라이언트와 통신할 독립적인 프로그램을 만들어준다.
 */
class ClientThread extends Thread {
	ChatServer01	main;
	//	필수변수	통신 변수
	Socket			socket;		//	위에서 이미 배정받았다
								//	그것을 받아서 사용하면 된다.
	PrintWriter		pw;			//	소켓을 알면 만들 수 있다.
	BufferedReader	br;
	//	보조변수	클라이언트의 정보를 기억하면 좋겠다.
	String			ip;
	String			nick;	//	닉네임을 클라이언트가 보내줄때 알 수 있고
	String			room;	//	클라이언트가 방에 들어가면 알수 있고
	
	//	★★★★★
	public ClientThread(ChatServer01 m, Socket s) throws Exception {
		main = m;
		socket = s;
		InputStream		in = socket.getInputStream();
		OutputStream	out = socket.getOutputStream();
		pw = new PrintWriter(out);
		InputStreamReader temp = new InputStreamReader(in);
		br = new BufferedReader(temp);

		InetAddress inet = socket.getInetAddress();
		ip = inet.getHostAddress();
		//	아직 모르는 데이터이므로 임시로 아무거나 써놓자
		nick = "무명씨";
		room = "대기방";
	}
	void nickProc(String msg) {
		//	할일
		//		준비된 변수에 도착한 이름 저장하고
		nick = msg;
		//		잘받았다고 응답한다.
		String	sendMsg = "2101Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void enterRoom(String msg) {
		//	할일
		//		정보 기억하고
		room = msg;
		//		입장을 허락하는 메시지를 보낸다.
		String	sendMsg = "2201Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void exitRoom(String msg) {
		//	할일
		//		정보를 지우고
		room = "대기방";
		//		퇴장을 허락하는 메시지를 보낸다.
		String	sendMsg = "2202Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void sendMsg(String msg) {
		//	할일
		//		같은방 소속 모든 사람에게 한번씩 데이터를
		//		보내주어야 한다.
		String	sendMsg = "2301[" + nick + " 님 말씀] " + msg;

		//	접속한 클라이언트가 모두 몇명인지 알아보자.
		int	size = main.clientList.size();
		//	변수의 동기화란
		//	특정 스레드가 특정한 작업을 완료하기 전에는
		//	다른 스레드는 그 변수를 건딜지 못하게 하는 것
		synchronized(main.clientList) {
			for(int i = 0; i < size; i++) {
				//	한사람씩 정보를 꺼내자
				ClientThread	temp = (ClientThread) 
						main.clientList.get(i);
				String	tempRoom = temp.room;
				if(this.room.equals(tempRoom)) {
					//	같은 방 소속이면... 이사람에게만 보내주자
					temp.pw.println(sendMsg);
					temp.pw.flush();
				}
			}
		}
	}
	
	public void run() {
		try {
			//	이제 클라이언트와 통신하자.
			while(true) {
			//	통신은 클라이언트가 준 데이터 받아서
				String	msg = br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
			//	응답한다.
				//	1.	프로토콜 구분을 한다.
				String	strP = msg.substring(0,  4);
				int		intP = Integer.parseInt(strP);
				msg = msg.substring(4);
				switch(intP) {
				case	1101:	//	닉네임이니
					nickProc(msg);
					break;
				case	1201:	//	방입장이니
					enterRoom(msg);
					break;
				case	1202:	//	방퇴장이니
					exitRoom(msg);
					break;
				//	여기까지는 이 데이터를 보낸 사람에게만
				//	응답하면 된다.
				case	1301:	//	대화내용이니
					sendMsg(msg);
					break;
				//	이것은 같은 방 소속의 모든 사람에게
				//	응답을해야 한다.
				}
			}
		}
		catch(Exception e) {
		}
		finally {
			//	문제가 생겨서 스레드가 종료될 필요가 있다
			//	그러면.....
			//	접속자 명단에서 이 사람은 빼주어야 한다.
			main.clientList.remove(this);
			//	자원을 회수하자
			try {
				pw.close();
				br.close();
				socket.close();
			}
			catch(Exception e) {}
		}
	}
}






