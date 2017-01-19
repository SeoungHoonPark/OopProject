package P0119;

import java.net.InetAddress;

/**
 *	��Ʈ��ũ���� ���� �߿��� ��Ҵ� ip �ּ��̴�.
 * �ڹٴ� ip�ּ��� ������ �����ϴ� Ŭ������ �����ϰ� �ִ�. => InetAddress
 * 
 * 	1. �� ��ǻ���� ip�ּҸ� �˾ƺ���.
 * 	2. ���̹� ������ ip �ּҸ� �˾ƺ���.
 */
public class AddrTest {

	public AddrTest() {
		// �������
		// getByName(Strign host)
		//	=> ������ �ּҸ� �̿��ؼ� ip�ּҸ� ����
		// getLocalHost()
		// => ���� �ý����� ip �ּҸ� ����
		
		InetAddress inet = null;
		
		try{
//			inet = InetAddress.getLocalHost();
			inet = InetAddress.getByName("www.naver.com"); 
			// ������ �����ϴ� Ŭ���� �̹Ƿ� ������ ������ �Լ��� �߿��Լ�
			// 1. ip�ּ�
			// getHostAddress();
			// 2. ������ �ּ�
			// getHostName();
			
			String ip = inet.getHostAddress();
			String name = inet.getHostName();
			System.out.println("ip�� " + ip);
			System.out.println("����̸��� " + name);
			
			
		}catch(Exception e){
			
		}
		
	}

	public static void main(String[] args) {
		new AddrTest();
	}
}
