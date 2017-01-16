package P0113;
/*
 * 	키보드를 이용해서 문자를 입력 받아보자.
 */
import	java.io.*;
import java.util.Arrays;
public class InputTest01 {
	public InputTest01() {
		//	참고	키보드 역시 외부장치이다.
		//			자주 사용하는 외부장치이기 때문에...
		//			이미 스트림을 준비한 변수가 존재한다.
		//		System.in 이다.
		System.out.println("한글자를 입력해 주세요");
		int	ch = 0;
		try {
			//	1.
//			ch = System.in.read();
//			System.out.println("당신이 입력한 문자 = " + (char) ch);
//			System.out.println("당신이 입력한 문자 = " + ch);
			//	2.	★★★
			//	읽은 결과를 기억할 변수를 준비한다.
//			byte[]	buff = new byte[256];
			//	256의 숫자에 따라서 한번에 읽은 데이터 양이 정해진다.
//			int	len = System.in.read(buff);
			//	읽은 결과를 문자로 변환해서 출력하자.
//			String	str = new String(buff, 0, len);
//			System.out.println("당신이 입력한 문자 = " + str);
			//	3.	(주로 네트워크 처리를 할때 많이 사용한다.)
			byte[]	buff = new byte[256];
			Arrays.fill(buff, (byte)'A');
			int	len = System.in.read(buff,  10, 100);
			//	준비된 배열인 buff에 10번방부터 읽은 내용을 기억하세요
			//	최대 100개까지만 읽으세요(100글자만 입력받는다)
			String	str = new String(buff, 0, len + 10);
			System.out.println("당신이 입력한 문자 = " + str);
		}
		catch(Exception e) {}
	}
	public static void main(String[] args) {
		new InputTest01();
	}
}
