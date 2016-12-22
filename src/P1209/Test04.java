package P1209;

public class Test04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sam041 s = new Sam041();
		s.abc((byte) 5);
	}
}

class Sam041{
	void abc(){
		System.out.println("0번");
	}	
	//같은 이름의 함수를 같은 클래스 안에 만드는 행위를 우리는 "함수를 오버로딩 했다."라고 표현한다.
	// 이때 규칙은 매개변수의 개수, 순서, 형태 중 한개이상이 달라야 한다.
	void abc(int a){
		System.out.println("인티져 1번");
	}
	void abc(long a){
		System.out.println("로~옹 1번");
	}
	void abc(float a){
		System.out.println("플롯트 2번");		
	}
	
	void abc(double a){
		System.out.println("Double 3번");
	}
	
	void abc(int a, int b){
		System.out.println("인수2개 4번");
	}
}

