package P0119;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *	������ ������ ��
 *	Ư�� �����͸� ������ ������
 *	������ �ٽ� �����ϴ� ���α׷��� ������.
 */

public class PingClient01 {
	public PingClient01() {
		// ����� ����� �ϱ� ���ؼ��� ��ŵ����� �ʿ��ϴ�
		// �� ��� ������ ��Ȱ�� �ϴ� Ŭ������ socket�̴�.
		
		Socket socket = null;
				
		try{
			// Socket�� ����� �ڵ������� ����� ������ �̷������.
			socket = new Socket("192.168.35.72", 7777);
			// ��Ʈ ��ȣ�� ���ӹ��� ���α׷����� ������ ��ȣ�̾�� �Ѵ�.
			
			// ���� ������ �Ǿ����Ƿ�
			// ����� ����� �ϸ� �ȴ�.
			// ��� ����� ��Ʈ���� �̿��ؼ� ó���Ѵ�.
			
			// 1. Ÿ�� ��Ʈ�� 
			// getInputStream()	/ getOutputStream()
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 1 - 1���� �����͸� ������ ������
			String str = "ù��° ��Ʈ��ũ ���α׷� ��";
			byte[] buff = str.getBytes();
			out.write(buff);
			
			// ������ �� �����͸� �޾ƺ���.
			buff = new byte[1024];
			int len = in.read(buff);
			str = new String(buff, 0, len);
			System.out.println("Ŭ���̾�Ʈ�� ���� ���� " + str);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PingClient01();
	}

}
