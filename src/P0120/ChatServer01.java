package P0120;
/*
 * 	ä���� �����ϴ� ������ ������
 * 
 * 	1.	���� ��� ������ �غ��Ѵ�.
 * 	2.	������ �޴´�.
 */
import	java.net.*;
import	java.io.*;
import	java.util.*;
public class ChatServer01 {
	ServerSocket	server;
	//	���� �� �����ʹ� �ٸ� Ŭ���̾�Ʈ���Ե� �����ؾ� �Ѵ�.
	//	�׷��Ƿ� �������忡����
	//	�ڽſ��� ������ Ŭ���̾�Ʈ�� ������ �˰� �־�� �Ѵ�.
	
	//	�ڽſ��� ������ Ŭ���̾�Ʈ�� ������ �����ؼ� ����� ����
	ArrayList		clientList;
	public ChatServer01() {
		//	���� ��� ������ �غ��Ѵ�.
		try {
			server = new ServerSocket(7788);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		//	������ �޴µ�... ����ؼ� �޾ƾ� �ϹǷ�
		//	�ݺ�ó���Ѵ�.
		while(true) {
			try {
				Socket	socket = server.accept();
				//	���⼭ ���� ��ȭ�� ������.
				//	������ ������ Ŭ���̾�Ʈ�� ��ȭ�ϴ� ���α׷���
				//	���������� ���� �����̴�.
				//	�׷��� ���� ���α׷��� �ٽ� ������ ���� �� 
				//	�ֱ� �����̴�.
				
				//	�� �����ڿ� ���� ����� �Ʒ��ʿ� �ִ� 
				//	���α׷��� �⵿���� �־�� �Ѵ�.
				ClientThread	t = new ClientThread(this, socket);
				clientList.add(t);
				//	t �ȿ��� �� Ŭ���̾�Ʈ�� ���� ��� ������
				//	������ �غ��ϰ� �����Ƿ� t�� ��ä�� �־��ָ�
				//	�ʿ��Ҷ� �ʿ��� ������ ������ ����� �� ���� ���̴�.
				t.start();
			}
			catch(Exception e ){
				System.out.println("���� �ҷ� " + e);
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer01();
	}
}
/*
 * 	������ ������ Ŭ���̾�Ʈ�� ��ȭ�� ���� ���α׷��� ����������
 * 	�����ؼ� ����� �����̴�.
 */
class ClientThread extends Thread {
	//	�����α׷��� Ŭ���̾�Ʈ�� ��ȭ�� �� �������� ������̴�.
	//	�翬�� ���ʿ� �ִ� �����ϰ� ��ȣ ������ �ؾ��� �� ����.
	ChatServer01	main;
	//	�ʼ� ����
	//		��� ����
	Socket			socket;	//	�տ��� �̹� �� Ŭ���̾�Ʈ��
							//	����� ��ȭ�⸦ ����� ���Ҵ�.
	//	�� ��ȭ�⸦ �޾Ƽ� �������.
	
	PrintWriter		pw;		//	������ �˸� ���� �� �ִ� ����
	BufferedReader	br;
	//	���� ����
	//		���� ��ȭ�ϴ� Ŭ���̾�Ʈ�� ������ ����� ����
	String			ip;		//	������ �˸� ���� �� �ִ� ����
	
	public ClientThread(ChatServer01 m, Socket s) throws Exception {
		main = m;
		socket = s;
		//	�� �κ��� ����ó���� �ؾ��ϴ� �κ��̴�.
		//	����.....
		//		�� Ŭ������ ������ �ش� Ŭ���̾�Ʈ�� ����� �����̴�.
		//	�ٵ�....
		//		��Ʈ���� ������ ���ϸ� ��ȭ�� �� ����.
		//		�� ���α׷��� ������ ������ ����.
		InputStream		in = socket.getInputStream();
		OutputStream	out = socket.getOutputStream();
		
		pw = new PrintWriter(out);
		InputStreamReader	temp = new InputStreamReader(in);
		br = new BufferedReader(temp);
	
		InetAddress	inet = socket.getInetAddress();
		ip = inet.getHostAddress();
	}
	void sendRecive(String msg) {
		//	msg �ȿ��� Ŭ���̾�Ʈ�� �� ��ȭ������ ���Ǿ��ִ�.
		//		"�ȳ�"		�̶�� ���Ǿ� �ִ�.
		//	����	������	[???? �� ����] �ȳ�		�̶�� �ϰ�ʹ�.
		
		//	������ ������ �ٸ�����
		msg = "[" + ip + " �� ����] " + msg;
		
		//	�� ������ ������ ��� Ŭ���̾�Ʈ���� ����Ѵ�.
		int	size = main.clientList.size();
		
		//	����
		//		������ ���ÿ� ���� ���ϰ� �ѻ���� �ݺ��ϸ鼭
		//		�����ؾ� �Ѵ�.
		synchronized(main.clientList) {
			for(int i = 0; i < size; i++) {
				//	Ŭ���̾�Ʈ ������ ������.
				ClientThread	temp = 
						(ClientThread) main.clientList.get(i);
				temp.pw.println(msg);
				temp.pw.flush();
			}
		}
	}
	public void run() {
		//	����
		try {
			while(true) {
				//		��û �ް�
				String	msg = br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
				//		�����ϰ�
				sendRecive(msg);
			}
		}
		catch(Exception e) {
			//	���� �� ������� ����� �� �� ���� �������̴�.
			//	���..
			//	�ڽ��� ����ϴ� ��� �ڿ��� �ݾ��־�߰ڴ�.
			try {
				pw.close();
				br.close();
				socket.close();
			}
			catch(Exception e1) {}
			//	���� �� Ŭ���̾�Ʈ�� ������ �����Ǿ����Ƿ�
			//	������ ����Ʈ���� ���־�� �Ѵ�.
			main.clientList.remove(this);
		}
	}
}


