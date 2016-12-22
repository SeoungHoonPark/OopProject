/**
 * 
 */
package P1220;

/**
 * @author hong
 *
 */
public class Test04 {	
	public static void main(String[] args) {
		//변수를 만드는 것까지는 허락한다.
		MyInter04 in = null;
		
//		in = new MyInter04();
		in = new MyClass04();
		in.abc();
		in.xyz();
		
		if(in instanceof MyClass04){
			System.out.println("예 나는 MyClass04이다");
		}else{
			System.out.println("아니요 나는 MyClass04가 아니다");
		}
		if(in instanceof MyInter04){
			System.out.println("예 나는 MyClass04이다");
		}else{
			System.out.println("아니요 나는 MyClass04가 아니다");
		}
		
	}
}

interface MyInter04{
	//인터페이스 안에는 추상적인 함수만 만들 수 있다.
	void abc();
	void xyz();
	// 몸체(기능)이 존재하는 함수는 절대로 인터페이스 안에 존재할 수 없다
	//void lmn(){}
	
	default void imn(){}	
	// 굳이 일반 함수가 필요하다면 default 속성을 선언해야 한다.
	//이 함수는 추상적인 함수가 아니므로 오버라이드 하지 않아도 상관이 없다.
	
}

class MyClass04 implements MyInter04{
	public void abc() {
		System.out.println("나는 abc함수");
	}
	public void xyz() {
		System.out.println("나는 xyz함수");
	}
}