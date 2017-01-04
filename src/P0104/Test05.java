package P0104;

public class Test05 {

	public Test05() {
		MyThread051	t = new MyThread051();
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("나는 메인입니다.");
			try {
				Thread.sleep(200);
			}
			catch(Exception e) {
			}
		}
		//	이제 메인이 종료된다.
		//	그래서 프로그램을 종료하고 싶다.
		//	그러면 스레드도 종료해야 한다.
		t.isStart = false;
//		try {
//			Thread.sleep(500);
//		}
//		catch(Exception e) {}
//		System.out.println("스레드 한번 끝나고 다시 실행한다.");
//		t.isStart = true;
//		t.start();
	}
	public static void main(String[] args) {
		new Test05();
		System.out.println("나 끝나요");
	}
}

class MyThread051 extends Thread {
	//	이 변수가 하는 역활은 언제까지 런함수가 실행될지를
	//	기억하는 변수의 역활을 할 예정이다.
	boolean		isStart = true;
	public void run() {
		//	이제 이 스레드는 무한루프로 반복할 예정이다.
		//	하지만 만약 isStart = false가 되면.....
		//	while이 종료될 것이다.
		while(isStart) {
			System.out.println("나는 홍길동이다.");
			try {
				Thread.sleep(200);
			}
			catch(Exception e) {
			}
		}	//while
	}	//	run
}
