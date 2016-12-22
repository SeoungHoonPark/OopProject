package Other;

/* 
 * 이클래스는 누군가에서 받은 클래스이다
 *  이클래스 안에 있는 변수를 어떤 클래스에서 사용할 수 있는지 
 *   범위를 알아보자.
*/

public class MyClass01 {
	
	public MyClass01(){
		
	}
	
	MyClass01(int a){
	}
	public int 			pub = 100;
	protected int	 pro = 200;
	int		pack	= 300;
	private int 		pri = 400;
	
	// 변수를 4개를 만드는데
	// 각각의 변수는 접근 지정을 다르게 할 예정이다.
	/*
	 * 1. 같은 클래스 안에서는 어디까지 사용할 수 있는가?
	 * 	변수를 사용하기 위해서는 함수가 있어야 한다.
	 */
	
	void test(){
		//	자기 자신은 접근 지정에 관계없이 모든 멤버를 사용할 수 있다
		pub = 1000;
		pro = 2000;
		pack = 3000;
		pri = 4000;
	}
}
