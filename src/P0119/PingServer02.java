package P0119;
/*
 * 	���� Ŭ���̾�Ʈ�� ������ �޾Ƽ� �� ��ų�� �ִ� ������ ������.
 * 
 * 	m51-849-186
 */
import	java.net.*;
import	java.io.*;
public class PingServer02 {
	public PingServer02() {
		//	1.	������ ó���� ������ �ʿ��ϴ�.
		ServerSocket	server = null;
		try {
			server = new ServerSocket(7777);
		}
		catch(Exception e) {
			//	���� ��� ������ ����µ� ������ �����....
			System.out.println(e);
			//	�� ���α׷��� �󾲴� ���α׷��̴�.
			System.exit(0);
		}
		
		//	����ؼ� ������ �޾ƾ� �ϹǷ�...
		//	�ݺ� ó���Ѵ�
//		try {		
		//	�̷��� �ϸ� �������� ������ �ϴٰ� ������ �����
		//	while�� ������������ ���̻� ������ ���� ���ϰ� �ȴ�. 
		System.out.println("���� ���� ���");
		while(true) {
			try {	//	2
				//	�̷��� �ϸ� ������ ������ �ϴٰ� 
				//	������ �������
				//	while ����� �����ϹǷ�
				//	���� ������ ���� �� �ְ� �ȴ�.
				Socket	socket = server.accept();
				
				InetAddress inet = socket.getInetAddress();  
				String	ip = inet.getHostAddress();
				System.out.println("[" + ip + "] �� ����");
				
				InputStream		in = socket.getInputStream();
				OutputStream	out = socket.getOutputStream();
				
				//	���� �����͸� ����
				byte[]	buff = new byte[1024];
				int	len = in.read(buff);
				String	str = new String(buff, 0, len);
				System.out.println("������ ���� ������ = " +  str);
				
				//	������ ������ �ٽ� ������(�����Ѵ�.)
				str = str + " : �� �޾Ҿ��";
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
