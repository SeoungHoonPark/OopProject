/**
 * 
 */
package P0103;

/**
 * @author hong
 *
 */
public class ThreadTest05 {

	public ThreadTest05() {
		MyThread051 t1 = new MyThread051();
		MyThread052 t2 = new MyThread052();
		
		t1.start();
		t2.start();		
	}

	public static void main(String[] args) {
		new ThreadTest05();
	}

}

class MyThread051 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println( "내가  간다. " + i);
			// 한번 출력하고 다른 프로그램에 양보하세요.
			// 
			yield();
		}
		super.run();
	}
}

class MyThread052 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println( "\t\t당신이  간다. " + i);
			yield();
		}
		super.run();
	}
}