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
		// �������� �����尡 �ƴϴ�.
		
		Thread t1 = new Thread(temp, "�豸��");
		Thread t2 = new Thread(temp, "�豹��");
		
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
			System.out.println(name + "�̰�  ����. " + i);
		}
	}	
}
