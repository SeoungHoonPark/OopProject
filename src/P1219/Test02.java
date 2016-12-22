package P1219;

/**
 * 삼각형을 처리하는 프로그램을 작성하세요.
 * 다형성 구현방법
 */
public class Test02 {
	public static void main(String[] args) {
		SamGak02  s = new SamGak02();
		s.display();
	}
}

// 관련된 클래스는 상위 클래스를 상속 받아서 만들기로 한다.

class SamGak02{
	void display(){
		System.out.println("나는 삼각형이다");
	}
}

class SaGak02{
	void display(){
		System.out.println("나는 삼각형이다");
	}
}
