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
		MyThread031 t1 = new MyThread031("������");
		// �׷��� �ϳ��� newBorn �� ���̴�.
		MyThread031 t2 = new MyThread031("������");
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new ThreadTest03();
	}
}

class MyThread031 extends Thread{
		// ��ó�� �ϳ��� ���α׷��� �̿��ؼ� ������ ������ ��� �̰��� ������ �ʿ䰡 ���� ���̴�.
		// �����ϴ� ���
		// 1. ������ �ϳ� ����� �� ������ ���� �ٸ��� �Է��ؼ� �����ϴ� ���
		// 2. �ƿ� ������ ��ü�� �̸��� �ο��ϴ� ����� �ִ�.
		// 	�̶� �ƹ��� Ŭ������ Thead�� Thread(String name)�� �̿��ϸ� �ȴ�.
		//	��, �ƹ��� Ŭ������  ����Ʈ �����ڰ� �ƴ� �ٸ� �����ڸ� �̿��ϸ� �����忡 �̸��� ���� �� �ִ�.
		// super()  �̸���� 1. �ݵ�� ������ �ȿ����� ����ؾ� �ϰ�
		//							2. �ݵ�� ù�ٿ��� ����ؾ� �Ѵ�.
	
	public MyThread031() {
		//super("ȫ�浿");
		// �׷��� ������ �����ϴ��� �׻� �̸��� ȫ�浿�� �ȴ�.
		// �̸��� �ٲ� �� ����?
	}
	
	public MyThread031(String name){
		super(name);
	}
	
	@Override
	public void run() {
		//������ �̸� �̿���
		//getName()�� �̸��� �˾Ƴ��� �Լ�
		// ���� run�� �ι� ����ȴ�.
		// �װ͵� ������ ������ ���� ó���� �ȴ�.
		// ���� � �����尡 ����Ǵ� ���� ���� �˾ƾ� �Ѵ�.
		// ���� �������� �����带 �˾Ƴ��� �Լ�
		// currentThread()
		for(int i = 0; i < 1000; i++){
			Thread t = Thread.currentThread();
			String name = t.getName();
			System.out.println(name + "�� ������ ����. " + i);
		}
		super.run();
	}
}
