package P0104;

/**
 * 상호참조의 옳은 예
 */
public class Test02 {
	Test021 downT;
	int num = 20;
	public void display(){
		System.out.println("클래스 변수값은 " + num);
	}
	public void setNum(){
		num++;
	}
	public Test02() {
		// 먼저실행될 곳에서는 다음에 실행될 것을 new시키면 된다.
		downT = new Test021();
		// 대신 다음 실행될 클래스에 자신의 주소를 알려준다.
		downT.setUp(this);
		downT.setNum();
		downT.display();
	}

	public static void main(String[] args) {
		new Test02();
	}
}

class Test021{
	Test02 upT;
	int num = 20;
	public void display(){
		System.out.println("클래스 변수값은 " + num);
	}
	public void setNum(){
		num++;
	}
	
	//상대방 주소를 받을 함수를 만들자.
	// 나중에 실행될 클래스는 먼저 실행된 클래스의 주소를 받아서 사용해야 한다.
	public void setUp(Test02 temp){
			this.upT = temp;
			upT.setNum();
			upT.display();
	}
}
