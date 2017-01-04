package P0104;

public class Test10 {

	public Test10() {
		Thread101	t = new Thread101();
		Thread102	t2 = new Thread102();
		t.start();
		t2.start();
		//	이제 이 메인은 t 스레드가 종료되기 전까지 실행하지
		//	못하도록 하고자 한다.
		//	이처럼 특정 스레드가 다른스레드에 실행이 될때
		//	실행하지 못하게 하는 방법	join
		try {
			t.join();
			t2.join();
			//	t 스레드가 Block이 되는것이 아니고
			//	지금 실행중인 프로그램(스레드 포함) =>	메인 프로세스
			//	이 중단되는 것이다.
			//	언제까지	지정한 스레드(t)가 마칠때까지	
		}
		catch(Exception e){}
		System.out.println("끝나요");
	}

	public static void main(String[] args) {
		System.out.println("시작해요");
		new Test10();
	}
}

class Thread101 extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("나는 왕이로소이다" + i);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {}
		}
	}
}

class Thread102 extends Thread {
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("나는 졸이로소이다" + i);
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {}
		}
	}
}

