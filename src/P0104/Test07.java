package P0104;

public class Test07 {
	int[]	num = new int[5];
	public Test07() {
		Thread071	t1 = new Thread071(this);
		Thread072	t2 = new Thread072(this);
		t1.start();
		t2.start();
	}
	public static void main(String[] args) {
		new Test07();
	}

}

class Thread071 extends Thread {
	Test07	main;
	public Thread071() {}
	public Thread071(Test07 m) {
		main = m;
	}
	public void run() {
		//	이 스레드에서는 배열변수에 데이터를 기억하는 역활을 할 예정이다.
		//	이 스레드가 5개의 데이터를 완성할때까지는
		//	다른 스레드는 배열을 사용하지 못하게 하고싶다.
		System.out.println("이제 저장할 차례이다.");
		synchronized(main.num) {
			for(int i = 0; i < 5; i++) {
				int temp = (int)(Math.random() * 101);
				main.num[i] = temp;
				System.out.println(temp + "를 기억했어요");
				//	쉬는시간을 0.5~2초 사이로 랜덤하게 정할 예정이다. 
				int	sleep = (int)(Math.random() * (2000 - 500) + 500);
				try {
					Thread.sleep(sleep);
				}
				catch(Exception e) {}
			}
			System.out.println("이제 저장이 끝났다.");
		}
	}
}

class Thread072 extends Thread {
	Test07	main;
	public Thread072() {}
	public Thread072(Test07 m) {
		main = m;
	}
	public void run() {
		//	이 스레드에서는 배열변수의 데이터를 꺼내서 사용하는 역활을 할 예정이다.
		System.out.println("이제 사용할 차례이다.");
		synchronized(main.num) {
			for(int i = 0; i < 5; i++) {
				int temp = main.num[i];
				System.out.println(temp + "를 사용했어요");
				//	쉬는시간을 0.5~2초 사이로 랜덤하게 정할 예정이다. 
				int	sleep = (int)(Math.random() * (2000 - 500) + 500);
				try {
					Thread.sleep(sleep);
				}
				catch(Exception e) {}
			}
			System.out.println("이제 사용이 끝났다.");
		}
	}
}
