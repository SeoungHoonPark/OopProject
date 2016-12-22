package P1220;

/**
 * 다른 패키지에 만들어진 인터페이스 소속 변수를 사용해보자
 */
import Other.*;
public class Test01 {
	public static void main(String[] args) {
		// 인터페이스 소속 변수는 static 변수가 된다.
		// 다른 패키지에 있는 변수를 사용할 수 있는 것으로 봐서
		// 이 변수는 public 이다.
		
		System.out.println(MyInter.num);
		
		// 에러가 나는 것으로 봐서
		// 이 변수는 final 변수가 된다.
		//MyInter.num = 200;
	}
}
