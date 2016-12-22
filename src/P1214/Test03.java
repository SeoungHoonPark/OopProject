/**
 * 
 */
package P1214;

/**
 *
 */
public class Test03 {
	public static void main(String[] args) {
			Son03 s = new Son03();
			// 상속을 받았으므로 super의 기능을 다 사용할 수 있다.
			s.abc();
			s.xyz();
			s.lmn();
	}
}

class Father03{
		void abc(){
			System.out.println("abc 함수");
		}
		void xyz(){
			System.out.println("abc 함수");			
		}
}

class Son03 extends Father03{
	// 이 안에는 abc(), xyz가 존재한다.
	// 상속을 받는 목적은 비슷한 기능의 부품의 기능을 이용하면서
	// 없는 기능을 
	
		void lmn(){
			System.out.println("lmn 함수");
		}
}
