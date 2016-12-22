package P1219;

/**
 * 
 */
public class Test03 {
	public static void main(String[] args) {
//		 Grand03 g = new Son03();
		 // 자동 형변환에 의해서 사용이 가능하다.
//		 g.abc();
		 // Grand03 부터 Son03까지 계층추적한 후 
		 // 가장 마지막에 만나는 함수를 호출하게 된다.
		
		Object g = new Father03();
		
//		Grand03 g = new Father03();
		((Father03) g).abc();
	}
}

class Grand03 {
	void abc(){
		System.out.println("나는 할아버지");
	}
}
class Father03 extends Object{
	void abc(){
		System.out.println("");
	}
}

class Son03 extends Father03{
	void abc(){
		System.out.println("나는 아들");
	}
}

