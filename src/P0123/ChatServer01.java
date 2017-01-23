package P0123;
/*
 * 	ä�� ���� ����
 */
import		java.net.*;
import		java.io.*;
import		java.util.*;
public class ChatServer01 {
	ServerSocket	server;
	ArrayList		clientList;	//	�����ڸ� ������ ��������
	public ChatServer01() {
		//	����
		//	1.	��ǥ��ȭ �غ��Ѵ�.
		try {
			server = new ServerSocket(8877);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		System.out.println("���� ������");
		while(true) {
			try {
				//	2.	������ �޴´�.
				Socket	socket = server.accept();
				//	3.	�ش� Ŭ���̾�Ʈ�� ����� ����
				//		���α׷��� ���� �����Ѵ�.
				//		�� ���α׷��� ���������� ����Ǿ�� �ϸ�
				//		������� ������ �Ѵ�.
				ClientThread	t = new ClientThread(this, socket);
				//	���� Ŭ������ ���������� Ŭ�����̹Ƿ�
				//	������ ����� start���� ���� ���̴�.
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
 * 	������ Ŭ���̾�Ʈ�� ����� �������� ���α׷��� ������ش�.
 */
class ClientThread extends Thread {
	ChatServer01	main;
	//	�ʼ�����	��� ����
	Socket			socket;		//	������ �̹� �����޾Ҵ�
								//	�װ��� �޾Ƽ� ����ϸ� �ȴ�.
	PrintWriter		pw;			//	������ �˸� ���� �� �ִ�.
	BufferedReader	br;
	//	��������	Ŭ���̾�Ʈ�� ������ ����ϸ� ���ڴ�.
	String			ip;
	String			nick;	//	�г����� Ŭ���̾�Ʈ�� �����ٶ� �� �� �ְ�
	String			room;	//	Ŭ���̾�Ʈ�� �濡 ���� �˼� �ְ�
	
	//	�ڡڡڡڡ�
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
		//	���� �𸣴� �������̹Ƿ� �ӽ÷� �ƹ��ų� �����
		nick = "����";
		room = "����";
	}
	void nickProc(String msg) {
		//	����
		//		�غ�� ������ ������ �̸� �����ϰ�
		nick = msg;
		//		�߹޾Ҵٰ� �����Ѵ�.
		String	sendMsg = "2101Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void enterRoom(String msg) {
		//	����
		//		���� ����ϰ�
		room = msg;
		//		������ ����ϴ� �޽����� ������.
		String	sendMsg = "2201Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void exitRoom(String msg) {
		//	����
		//		������ �����
		room = "����";
		//		������ ����ϴ� �޽����� ������.
		String	sendMsg = "2202Y";
		pw.println(sendMsg);
		pw.flush();
	}
	void sendMsg(String msg) {
		//	����
		//		������ �Ҽ� ��� ������� �ѹ��� �����͸�
		//		�����־�� �Ѵ�.
		String	sendMsg = "2301[" + nick + " �� ����] " + msg;

		//	������ Ŭ���̾�Ʈ�� ��� ������� �˾ƺ���.
		int	size = main.clientList.size();
		//	������ ����ȭ��
		//	Ư�� �����尡 Ư���� �۾��� �Ϸ��ϱ� ������
		//	�ٸ� ������� �� ������ �ǵ��� ���ϰ� �ϴ� ��
		synchronized(main.clientList) {
			for(int i = 0; i < size; i++) {
				//	�ѻ���� ������ ������
				ClientThread	temp = (ClientThread) 
						main.clientList.get(i);
				String	tempRoom = temp.room;
				if(this.room.equals(tempRoom)) {
					//	���� �� �Ҽ��̸�... �̻�����Ը� ��������
					temp.pw.println(sendMsg);
					temp.pw.flush();
				}
			}
		}
	}
	
	public void run() {
		try {
			//	���� Ŭ���̾�Ʈ�� �������.
			while(true) {
			//	����� Ŭ���̾�Ʈ�� �� ������ �޾Ƽ�
				String	msg = br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
			//	�����Ѵ�.
				//	1.	�������� ������ �Ѵ�.
				String	strP = msg.substring(0,  4);
				int		intP = Integer.parseInt(strP);
				msg = msg.substring(4);
				switch(intP) {
				case	1101:	//	�г����̴�
					nickProc(msg);
					break;
				case	1201:	//	�������̴�
					enterRoom(msg);
					break;
				case	1202:	//	�������̴�
					exitRoom(msg);
					break;
				//	��������� �� �����͸� ���� ������Ը�
				//	�����ϸ� �ȴ�.
				case	1301:	//	��ȭ�����̴�
					sendMsg(msg);
					break;
				//	�̰��� ���� �� �Ҽ��� ��� �������
				//	�������ؾ� �Ѵ�.
				}
			}
		}
		catch(Exception e) {
		}
		finally {
			//	������ ���ܼ� �����尡 ����� �ʿ䰡 �ִ�
			//	�׷���.....
			//	������ ��ܿ��� �� ����� ���־�� �Ѵ�.
			main.clientList.remove(this);
			//	�ڿ��� ȸ������
			try {
				pw.close();
				br.close();
				socket.close();
			}
			catch(Exception e) {}
		}
	}
}






