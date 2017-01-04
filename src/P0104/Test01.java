package P0104;

/**
 *	상호참조의 잘못된 점
 */
public class Test01 {
	Test011 downT;
		
	int num = 20;
	public void Display(){
		System.out.println("Test01의 변수값 = " + num );
	}
	void setNum(){
		num++;
	}
	public Test01() {
		// 아래쪽 클래스를 참조하기 위해서 new시킨다.
		downT = new Test011();
		downT.setUp();
	}

	public static void main(String[] args) {
		new Test01();
	}
}

class Test011{
	Test01 upT;
	int num = 10;
	public void Display(){
		System.out.println("Test011의 변수값 = " + num);
	}
	
	public void setUp(){
		upT = new Test01();
	}
}