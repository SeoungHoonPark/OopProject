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
			System.out.println( "����  ����. " + i);
			// �ѹ� ����ϰ� �ٸ� ���α׷��� �纸�ϼ���.
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
			System.out.println( "\t\t�����  ����. " + i);
			yield();
		}
		super.run();
	}
}