package P0103;

/**
 *
 */
public class ThreadTest01{
	public ThreadTest01() {
		// ������ ���α׷��� �ݵ�� new born ���·� ������ �Ѵ�.
		//		new born ���¶�?
		//		���� ������ ���α׷����� ����ٴ� �ǹ��̴�.
		// 	 �̰����� �ڹٿ��� new ��Ų�� �ȴ�.
		MyThread001 my1 = new MyThread001();
		MyThread002 my2 = new MyThread002();
		
		//�̰��� �����ϱ� ���ؼ��� ������ ���α׷��� ���۵Ǿ�����
		// �ϴ� �������� �� ���� runnable ���·� ������ ��Ű�� �ȴ�.
		my1.start();
		my2.start();	
		
//	new MyThread001().start();
//	new MyThread002().start();
		
	}

	public static void main(String[] args) {
		// ������ ���α׷��� �ݵ�� ���μ��� ���α׷��� �����ؾ߸� ���� �� �� �ִ�.
		
		new ThreadTest01();
	}
}

// �ΰ��� ������ ���α׷��� ������.
class MyThread001 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i< 1000; i++){
			System.out.println("�����̰� �尡�� ����"+ i);
		}
	}
}

class MyThread002 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i< 1000; i++){
		System.out.println("\t\t�����̰� ������ ����"+ i);
		}
	}
}