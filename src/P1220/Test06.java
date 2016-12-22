package P1220;

/**
 *
 */
public class Test06 {
	public static void main(String[] args) {
		// 전역 내부 클래스는 바깥 클래스와 밀접한 관계가 있다.
		//Outer06.Inner06 in = new Outer06.Inner06();
		// 반드시 전역 내부 클래스는 바깥 클래스가 생성된 후 만들수 있다.
		
		Outer06 out = new Outer06();
		Outer06.Inner06 in = out.new Inner06();
		// 이 문법을 반드시 외우세요.
		// 바깥 클래스의 주소를 이용해서 안쪽 클래스를 생성해야 한다.
		
		in.xyz();
		
	}
}

class Outer06{
	int a = 10;
	void abc(){
		System.out.println("A = " + a);
		//xyz(); 에러	바깥 클래스는 안쪽 클래스를 사용 할 수 없다.
		//만약 사용하기를 원하면 new 시켜서 사용해라
		Inner06 in = new Inner06();
		in.lmn();
		
	}
	// 이런 유형의 내부 클래스를 전역 내부 클래스라고 부른다.
	public class Inner06{
		int b = 100;
		int a = 500;
		void lmn(){
			System.out.println("lmn에서 출력 B = " + b);
		}
		void xyz(){
			System.out.println("B = " + b);
			// 바깥 클래스의 멤버는 마치 자기것처럼 아무 조건없이 사용할 수 있다.
			abc();
			System.out.println("A = " + a);
			// 자바는 자기와 가장 가까운 변수를 먼저 사용한다고 횄기에 자신의 a 변수를 사용한다.
			
			// 만약 이 경우 바깥 a를 사용하고자 하면
			//클래스이름.this.멤버(외울것)
			System.out.println("A = " + Outer06.this.a);
			
		}
	}
}
