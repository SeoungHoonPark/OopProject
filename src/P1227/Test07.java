/**
 * 
 */
package P1227;

import java.text.MessageFormat;

/**
 *	
 */
public class Test07 {
	public Test07() {
		// 나는 
		// "Name : 홍길동. tel : 010-1111-2222, age : 24";
		// "Name : 박아지. tel : 010-1234-5678, age : 34";
		
		MessageFormat f 
		= new MessageFormat("Name : {0}, tel : {1}, age : {2}");
		
		Object[] date = {"홍길동", "010-1111-2222", 24};
		// {0} ... 에 들어갈 데이터를 배열로 준비한다.
		
			String result = f.format(date);
			System.out.println(result);
			
	}

	public static void main(String[] args) {
		new Test07();
	}
}
