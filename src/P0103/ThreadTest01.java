package P0103;

/**
 *
 */
public class ThreadTest01{
	public ThreadTest01() {
		// 스레드 프로그램을 반드시 new born 상태로 만들어야 한다.
		//		new born 상태란?
		//		실행 가능한 프로그램으로 만든다는 의미이다.
		// 	 이것은ㅇ 자바에서 new 시킨면 된다.
		MyThread001 my1 = new MyThread001();
		MyThread002 my2 = new MyThread002();
		
		//이것을 실행하기 위해서는 스레드 프로그램이 시작되었으면
		// 하는 시점에서 할 일은 runnable 상태로 전위만 시키면 된다.
		my1.start();
		my2.start();	
		
//	new MyThread001().start();
//	new MyThread002().start();
		
	}

	public static void main(String[] args) {
		// 스레드 프로그램은 반드시 프로세스 프로그램이 존재해야만 실행 할 수 있다.
		
		new ThreadTest01();
	}
}

// 두개의 스레드 프로그램을 만들어보자.
class MyThread001 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i< 1000; i++){
			System.out.println("갑돌이가 장가를 간다"+ i);
		}
	}
}

class MyThread002 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i< 1000; i++){
		System.out.println("\t\t갑순이가 시집를 간다"+ i);
		}
	}
}