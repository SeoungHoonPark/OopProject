/**
 * 
 */
package P1216;

/**
 *
 */
public class Test04 {
	public static void main(String[] args) {
	
	}
}

class Father04{
	protected void abc(){
		System.out.println("나는 아버지");
	}
}
class Son04 extends Father04{
	//성공하는 경우
	//	protected void abc(){
	//		System.out.println("나는 아들");
	//	}
	//	public void abc(){	
	//	}
	
	// 실패하는 경우
	// 접근지정자가 좁은 방향으로 되었기 때문에 실패한다.
	//	void abc(){
	//		System.out.println("나는 아들");
	//}
}
