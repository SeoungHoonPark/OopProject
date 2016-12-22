/**
 * 
 */
package P1219;

/**
 *	 	랜덤하게 숫자를 발생하여
 * 	그 숫자가 짝수이면 삼각형을 처리하고
 * 	그 숫자가 홀수이면 사각형을 처리하라.
 */
public class Test01 {
	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 101);
		
		Father01 f = null;
		
		if(num % 2 == 0){
			f = new SamGak01();
		}else{
			f = new SaGak01();
		}
		
		if(num % 2 == 0){
			f.display();
		}else{
			f.display();
		}
	}
}

// 관련된 클래스를 대표하는 상위 클래스를 만들어 놓기로 약속했다.
// 
class Father01 {
	void display(){
		System.out.println("나는 아버지이다.");
	}
}

// 이 클래스는 삼각형을 처리하기 위한 클래스이다
class SamGak01 extends Father01{
	void display(){
		System.out.println("나는 삼각형이다");
	}
}
// 이 클래스는 사각형을 처리하기 위한 클래스이다.
class SaGak01 extends Father01{
	void display(){
		System.out.println("나는 사각형이다");
	}
}
