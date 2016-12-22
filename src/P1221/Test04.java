/**
 * 
 */
package P1221;

/**
 * @author hong
 *
 */
public class Test04 {
	public Test04() {
		int a = 5;
		int b = 25;
		int c = 0;
		try{
			
		}catch (Exception e) {
			/* Exception e의 의미는 jvm이 알려주는 예외 정보
			클래스를 받을 준비를 하는 것이다.
			즉, 함수의 매개변수 역할을 하는 것이다.
			그리고 이 변수는 발생한 예외의 종류에 ㄸ라서 클래스가 달라져서 들어온다.
			예) 0으로 나눈 에러 Arithmetic Excetion가 들어오며
				배열의 범위를 벗어난 에러 ArrayIndexOutOfBoundsException
			
			모든 예외 클래스는 공통적으로 Exception 클래스를 가지고 있다.
			상위 클래스의 주소는 하위 클래스를 받을 수 있다.
			*/
			c = b;
		}
		
	}
	public static void main(String[] args) {
		new Test04();
		
	}
}
