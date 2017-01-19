package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *		���� Ŭ���̾�Ʈ�� ������ �޾Ƽ� �� ��ų �� �ִ� ������ ����� ����.
 */
public class PingServer02 {
	public PingServer02() {
		// 1. ���Ӹ��� ���� ������ �ʿ��ϴ�
		ServerSocket server = null;
		
		try{
			server = new ServerSocket(7777);
			
			Socket socket = server.accept();
			
			InetAddress inet = socket.getInetAddress();
			
			String ip = inet.getHostAddress();
			
			System.out.println("[ " +  ip + "] ��  ����");
						
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
			// ���� ��� ������ ����µ� ������ �����
			System.out.println(e);
			//�� ���α׷��� ������ ���α׷��̴�.
			System.exit(0);
		}
		// ����ؼ� ������ �޾ƾ� �ϹǷ�..
		// �ݺ� ó���Ѵ�.
			while(true){
				try{	// ������ �ϴ� ���� ������ ������� ���� ������ �޾ƾ� �ϹǷ� try..catch�� ���� �����Ѵ�.
					
					Socket socket = server.accept();
					// �� �Լ��� ���ŷ �Լ��̰�
					// �� �Լ��� ����ȴٴ� ���� ������ �������� �Ǿ��ٴ� ���̰�, 
					// �� Ŭ���̾�Ʈ�� ����� ��ȭ�⸦ ����� �ش�.
				}catch(Exception e){ }
				
			}
	}

	public static void main(String[] args) {
		new PingServer02();
	}
}
