package P1216;

import Other.*;

/**
 * 4.
 * 다른 패키지에 있는데 상속 받은 클래스인 경우에는?
 */
public class Test01 extends MyClass01 {
	/**
	 * 
	 */
	Test01() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 상속 받았기 때문에 4개의 변수가 존재한다.
	void test(){
		pub = 1000;
		
		// 상속이거나 같은 패키지 일때 사용
		pro = 2000;
		
		// 생략된 경우는 같은 패키지 소속인 경우에만 사용 할 수 있기 때문이다.
		// 지금은 패키지가 다른 경우이다.
//		pack = 3000;
//		pri = 4000;
	}
	public static void main(String[] args) {
		
		
	}
}
