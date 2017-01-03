/**
 * 
 */
package P0103;

/**
 * @author hong
 *
 */
public class ThreadTest03 {
	
	public ThreadTest03() {
		MyThread031 t1 = new MyThread031("아이유");
		// 그러면 하나가 newBorn 된 것이다.
		MyThread031 t2 = new MyThread031("김유정");
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new ThreadTest03();
	}
}

class MyThread031 extends Thread{
		// 이처럼 하나의 프로그램을 이용해서 여러번 실행할 경우 이것을 구분할 필요가 있을 것이다.
		// 구분하는 방법
		// 1. 변수를 하나 만들고 그 변수에 값을 다르게 입력해서 구분하는 방법
		// 2. 아예 스레드 자체에 이름을 부여하는 방법이 있다.
		// 	이때 아버지 클래스인 Thead의 Thread(String name)를 이용하면 된다.
		//	즉, 아버지 클래스의  디폴트 생성자가 아닌 다른 생성자를 이용하면 스레드에 이름을 붙일 수 있다.
		// super()  이명령은 1. 반드시 생성자 안에서만 사용해야 하고
		//							2. 반드시 첫줄에서 사용해야 한다.
	
	public MyThread031() {
		//super("홍길동");
		// 그러면 여러번 생성하더라도 항상 이름이 홍길동이 된다.
		// 이름을 바꿀 수 없나?
	}
	
	public MyThread031(String name){
		super(name);
	}
	
	@Override
	public void run() {
		//스레드 이름 이용방법
		//getName()가 이름을 알아내는 함수
		// 지금 run은 두번 실행된다.
		// 그것도 순서를 무시한 병행 처리가 된다.
		// 지금 어떤 스레드가 실행되는 지를 먼저 알아야 한다.
		// 현재 실행중인 스레드를 알아내는 함수
		// currentThread()
		for(int i = 0; i < 1000; i++){
			Thread t = Thread.currentThread();
			String name = t.getName();
			System.out.println(name + "이 시집을 간다. " + i);
		}
		super.run();
	}
}
