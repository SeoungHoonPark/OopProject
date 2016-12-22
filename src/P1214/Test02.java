package P1214;

/**
 *
 */
public class Test02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son02 s = new Son02();
		
	}
}

class Grand02{
	public Grand02() {
		System.out.println("나는 할아버지 생성자");
	}
}

class Father02{
//	Father02(){
//		System.out.println("아버지 생성자");
//	}
	Father02(int a){	
	}
	Father02(int a, int b){
	}
	Father02(float a){
	}
}

class Son02 extends Father02{
	Son02(){
		super(5);
			System.out.println("나는 아들 생성자");
	}
	Son02(int a){
		super(a);
		System.out.println("인수1개 나는 아들 생성자");		
	}
	
	Son02(int a, int b){
		super(a, b);
		System.out.println(" 인수2개 나는 아들 생성자");
	}
	
	Son02(float a){
		super(a);
		System.out.println(" float 나는 아들 생성자");
	}
	
}