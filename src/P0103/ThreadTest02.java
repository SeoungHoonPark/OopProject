package P0103;

/**
 *
 */
public class ThreadTest02  {

	public ThreadTest02() {
		// 시작하는 방법이 조금 다르다.
		MyThread021 temp1 = new MyThread021();
		MyThread022 temp2 = new MyThread022();
		//=> 여기까지는 NEW BORN 된것이 아니고 일반적으로 클래스를 사용하기 위해서 NEW시킨 것이다
		// Runable은 아직 thread가 아니다
		
		Thread t1 = new Thread(temp1);
		Thread t2 = new Thread(temp2);
		// 드디어 thread가 만들어 졌고 new born된 것이다.
		
		//다른 프로그램 진행하다가 스레드가 필요하면 runable 상태로 전위 시키면 된다.
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new ThreadTest02();
	}
}

class MyThread021 implements Runnable{
	@Override
	public void run() {
		display();
	}	
	
	public void display(){
		for(int i = 0; i< 1000; i++){
			System.out.println("될쇠가 나무를 한다 "+ i);
		}
	}
}

class MyThread022 implements Runnable{
	@Override
	public void run() {
		display();
	}	
	public void display(){
		for(int i = 0; i< 1000; i++){
			System.out.println("\t\t순이가 밥을 짓는다 "+ i);
		}
	}
}