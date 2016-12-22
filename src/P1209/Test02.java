package P1209;

// 원칙은 클래스는 하나의 파일에 하나만 만드는 것이 원칙이다.
// 하지만 지금은 테스트 이므로 ...
public class Test02 {
	public static void main(String[] args) {
		
	//	sam021이라는 클래스를 사용하고자하면
	//	반드시 오브젝트로 만들어야 한다.
		
		Sam021 s1 = new Sam021();
		// 이 부품을 이용해서 원하는 작업을 진행하면 된다.
		// a 변수에 데이터를 넣고 싶다.
		s1.a = 10;
		// b 변수에 데이터를 넣고 싶다.
		s1.b = 3.14f;
		
		// a에 무엇이 있는지 출력하자=> abc()함수를 실행하면 된다
		s1.abc();
		// b에 무엇이 있는지 출력하자=> abc()함수를 실행하면 된다
		s1.xyz();
	}
}

class Sam021{
	int a;
	float b;
	char c;
	
	void abc(){
		System.out.println("A = " + a);
	}
	void xyz(){
		System.out.println("B = " + b);		
	}
}
