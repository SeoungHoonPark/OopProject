package P1214;

/**
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Son05 s = new Son05();
		s.abc();
		s.xyz();
	}
}

class Father05{
	void abc(){
		System.out.println("나는 아버지 abc이다");
	}
}
class Son05 extends Father05{
	void abc(){
		System.out.println("나는 아들 abc이다");
	}
	void xyz(){
		//super.abc(); 부모클래스의 함수가 호출
		//abc();	자식클래스의 함수가 호출
		
		// 당연하지만 super는 아무곳에서나 사용 할 수 없고
		// 반드시 하위 클래스에서만 사용 할 수 있다.
	}
}
