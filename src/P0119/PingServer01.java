package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*	*
 *	Ŭ���̾�Ʈ�� �����ϸ� ������ �ް� �����͸� ������ �����ϴ� ������ ������
 */
public class PingServer01 {

	public PingServer01() {
		// ��ǥ��ȭ(���Ӹ� �޴� ��ȭ��)�� ����� ���´�.
		ServerSocket server = null;
		
		try{
			server = new ServerSocket(7777);
			// 7777������ ������ ��û�ϴ� ���� ��� ���� �غ� �Ѵ�.
			System.out.println("���� ���� ���...");
			
			//accept() : ������ ������ �޾��ִ� �Լ�			
		    Socket socket = server.accept();
			// �� �Լ��� blocking �Լ��̴�.
			// ? Ư���� ����� �������� ������ ������� �ʴ� �Լ��̴�.
			// ���� �츮�� ��� �Լ��߿��� System.in.read()�� blocking �Լ��̴�
			// accept()�� �������� ������ �ؾ߸� �����ϴ� �Լ��̴�.
			// �� �Լ��� ����Ǿ��ٴ� �ǹ̴� �������� ������ �ߴٴ� ���̰�
			// �׷��� ����� ��ȭ�⸦ ������ �־�� �Ѵ�.
		    
			// �� ��ȯ������ ������ ����� ��ȭ�⸦ �����Ѵ�.
		    
			System.out.println("���� ���� �Ϸ�");
			
			// ������� ����Ǿ��ٴ� ���� �������� ������ �ߴٴ� ���̴�.
			// �׸��� �� ����ϰ� ����� ��ȭ�⵵ �����޾Ҵ�.
			// �׷��� �� ��ȭ�⸦ �̿��ؼ� ����� ����� �� �� ���� ���̰�..
			// �ڹ� ��� ��Ʈ��������� ����� �ؾ��Ѵ�.
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// ���� �����͸� ����
			byte[] buff = new byte[1024];
			int len= in.read(buff);
			
			String str = new String(buff, 0, len);
			System.out.println("������ ���� �����ʹ� " + str);
			
			// ������ ������ �ٽ� ������.
			
			str = str + " : �� �޾ҽ��ϴ�.";
			
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
