package P0119;

import java.net.InetAddress;

/**
 *	네트워크에서 가장 중요한 요소는 ip 주소이다.
 * 자바는 ip주소의 정보를 관리하는 클래스를 제공하고 있다. => InetAddress
 * 
 * 	1. 내 컴퓨터의 ip주소를 알아보자.
 * 	2. 네이버 서버의 ip 주소를 알아보자.
 */
public class AddrTest {

	public AddrTest() {
		// 생성방법
		// getByName(Strign host)
		//	=> 지정한 주소를 이용해서 ip주소를 관리
		// getLocalHost()
		// => 현재 시스템의 ip 주소를 관리
		
		InetAddress inet = null;
		
		try{
//			inet = InetAddress.getLocalHost();
			inet = InetAddress.getByName("www.naver.com"); 
			// 정보를 관리하는 클래스 이므로 정보를 꺼내는 함수가 중요함수
			// 1. ip주소
			// getHostAddress();
			// 2. 도메인 주소
			// getHostName();
			
			String ip = inet.getHostAddress();
			String name = inet.getHostName();
			System.out.println("ip는 " + ip);
			System.out.println("장비이름은 " + name);
			
			
		}catch(Exception e){
			
		}
		
	}

	public static void main(String[] args) {
		new AddrTest();
	}
}
