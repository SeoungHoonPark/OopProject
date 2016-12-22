/**
 * 
 */
package P1220;

import P1220.Outer05.Inner05;

/**
 * @author hong
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//inner 클래스 사용
			//Inner05 in = new Inner05();	//에러
			// 왜냐하면 inner 클래스 특징은 클래스이름이 바깥클래스이름.안쪽클래스이름으로 구성
			Outer05.Inner05 in = new Outer05.Inner05();
			in.abc();
	}
}

class Outer05{
	
	static class Inner05{
		int a = 10;
		void abc(){
			System.out.println("나는 안쪽 abc이다.");
		}
	}
}
