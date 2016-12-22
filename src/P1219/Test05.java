/**
 * 
 */
package P1219;

/**
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Father05 f = new Son05();
		
		System.out.println(f.a); // 100
		// 이 경우에는 레퍼런스쪽 변수를 이용하게 된다.
		// 그러므로 레퍼런스쪽 변수가 존재하지 않으면 에러가 발생한다.
		
		Son05  s = new Son05();
		System.out.println(s.a); // 200
		
		Father05 f2 = new Son05();
		f2.abc();
	}
}

class Father05{
	int a = 100;
	void abc(){
		System.out.println("A = " + a);
	}
}
class Son05 extends Father05{
	int a = 200;
	void abc(){
		System.out.println("A = " + a);
	}	
}