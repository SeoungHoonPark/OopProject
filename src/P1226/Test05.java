/**
 * 
 */
package P1226;

import java.util.StringTokenizer;

/**
 *		특정 사이트 주소를 입력한 후 : [/ .] 을 중심으로 분리해서 처리하세요.
 */
public class Test05 {
	public Test05() {
		String url = "http://daum.net:8080/Test/sample.jsp";
		StringTokenizer token = new StringTokenizer(url, ":/.");
		//StringTokenizer token = new StringTokenizer(url, ":/." true);
		// 참고 나눌 문자열은 여러개를 입력하더라도
		//	그 중 하나만 만족하면 토큰 분리가 된다.
		
		while(token.hasMoreTokens()){
			String temp = (String) token.nextElement();
			System.out.println(temp);
		}
	}
	public static void main(String[] args) {
		new Test05();
	}

}
