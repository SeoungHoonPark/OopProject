/**
 * 
 */
package P1226;

import java.util.StringTokenizer;

/**
 *		Ư�� ����Ʈ �ּҸ� �Է��� �� : [/ .] �� �߽����� �и��ؼ� ó���ϼ���.
 */
public class Test05 {
	public Test05() {
		String url = "http://daum.net:8080/Test/sample.jsp";
		StringTokenizer token = new StringTokenizer(url, ":/.");
		//StringTokenizer token = new StringTokenizer(url, ":/." true);
		// ���� ���� ���ڿ��� �������� �Է��ϴ���
		//	�� �� �ϳ��� �����ϸ� ��ū �и��� �ȴ�.
		
		while(token.hasMoreTokens()){
			String temp = (String) token.nextElement();
			System.out.println(temp);
		}
	}
	public static void main(String[] args) {
		new Test05();
	}

}
