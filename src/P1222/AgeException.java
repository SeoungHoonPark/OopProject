/**
 * 
 */
package P1222;

/**
 * 	예외 클래스가 되기 위해서는 Exception 클래스를 상속 받는다.
 * 	그래야지만 예외에 관련된 기능을 이용 할 수 있다.
 */
public class AgeException extends Exception {
	
	// 예외의 정보를 출력하기 위해서는
	// toString()를 오버라이드하여 필요한 정보를 출력하면 된다.	
	public String toString(){
		String temp = "나이는 임수로 입력될 수 없다";
		return temp;
	}
}
