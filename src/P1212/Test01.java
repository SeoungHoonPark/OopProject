/**
 * 
 */
package P1212;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("변수 생성");
		Sam011 s;
		System.out.println("오브젝트 생성");
		s= new Sam011();
		System.out.println("프로그램 종료");
	}
}

class Sam011{
	//이것이 생성자 함수이다
	Sam011(){
		System.out.println("생성자 함수");
	}
}