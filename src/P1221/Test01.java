/**
 * 
 */
package P1221;

/**
 * 
 */
public class Test01 {
	
	public Test01(){
		// 이 안에서 필요한 작업을 시작하도록 한다.
		// 왜냐하면 생성자 함수는 new시키는 순간 자동실행되고 인스턴스가 만들어지게 
		//되므로 this가 생격나고
		// 이 함수 안에서는 아무런 제약없이 모든 멤버를 사용할 수 있기 때문이다.
		
		int a = 5;
		int b = 25;
		int c = 0;
		
		// 문제점
		//	어떤 상황에서 예외가 발생할지를 개발자가 일일이 알고 있어야 한다.
		if(a != 0){
			c = b / a;
		}else{
			// 사용자가 데이터를 잘 못 입력한 경우
			//개발자가 그 잘못을 수정해서 치라하도록 노력해야 한다.
			c = b;
		}
		System.out.println("결과는  = " + c);
	}
	public static void main(String[] args) {
		/*	
		 	지금까지는 main 함수에서 뭔가를 테스트했어다.
			하지만 실무에서는 main에서 뭔가를 코딩하는 것은 매우 불합리한 행위이다.
			왜냐하면 main 함수는 static함수이므로 활동에 있어서 제약이 받는다.
			실무에서는 main에서 코딩을 하지 않고 생성자 함수에서 프로그램을 시작하도록 한다.
			
			문제는 jvm은 main만 호출하고 생성자 함수는 호출하지 않는다.
			그럼 생성자 함수를 강제로 실행하면 된다.
			
		*/
		new Test01();		
		
	}
}
