/**
 * 
 */
package P0103;

/**
 * @author hong
 *
 */
public class ThreadTest04 {

	public ThreadTest04() {
		MyThread041 temp = new MyThread041();
		// 아직까지 스레드가 아니다.
		
		Thread t1 = new Thread(temp, "김구라");
		Thread t2 = new Thread(temp, "김국진");
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new ThreadTest04();
	}
}

class MyThread041 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			String name = Thread.currentThread().getName();
			System.out.println(name + "이가  간다. " + i);
		}
	}	
}
