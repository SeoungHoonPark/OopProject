package P0103;

/**
 *
 */
public class ThreadTest02  {

	public ThreadTest02() {
		// �����ϴ� ����� ���� �ٸ���.
		MyThread021 temp1 = new MyThread021();
		MyThread022 temp2 = new MyThread022();
		//=> ��������� NEW BORN �Ȱ��� �ƴϰ� �Ϲ������� Ŭ������ ����ϱ� ���ؼ� NEW��Ų ���̴�
		// Runable�� ���� thread�� �ƴϴ�
		
		Thread t1 = new Thread(temp1);
		Thread t2 = new Thread(temp2);
		// ���� thread�� ����� ���� new born�� ���̴�.
		
		//�ٸ� ���α׷� �����ϴٰ� �����尡 �ʿ��ϸ� runable ���·� ���� ��Ű�� �ȴ�.
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
			System.out.println("�ɼ谡 ������ �Ѵ� "+ i);
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
			System.out.println("\t\t���̰� ���� ���´� "+ i);
		}
	}
}