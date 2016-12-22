/**
 * 
 */
package P1222;

/**
 * 
 */
public class Test02 {
	public Test02() {
		Sam02 s1 = new Sam02();
		
		//s 변수에는 주소가 기억되어 있다.
		// 이것을 출력하면 당연히 주소가 나와야 하는데..
		// 자바는 주소를 노출하지 않는다.
		
		System.out.println(s1);
		// 자바는 주소를 출력하면 [클래스이름@해쉬코드값] 을 출력한다.
		
		// 이것을 만들어 주는 함수가 toString()이다
		
		String test = s1.toString();
		
		System.out.println(test);
		
		String str = new String("hong");
		System.out.println(str);
		
	}

	public static void main(String[] args) {

	}
}

class Sam02{
	
}