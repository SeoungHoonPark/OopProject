package P0104;

public class Test05 {

	public Test05() {
		MyThread051	t = new MyThread051();
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("���� �����Դϴ�.");
			try {
				Thread.sleep(200);
			}
			catch(Exception e) {
			}
		}
		//	���� ������ ����ȴ�.
		//	�׷��� ���α׷��� �����ϰ� �ʹ�.
		//	�׷��� �����嵵 �����ؾ� �Ѵ�.
		t.isStart = false;
//		try {
//			Thread.sleep(500);
//		}
//		catch(Exception e) {}
//		System.out.println("������ �ѹ� ������ �ٽ� �����Ѵ�.");
//		t.isStart = true;
//		t.start();
	}
	public static void main(String[] args) {
		new Test05();
		System.out.println("�� ������");
	}
}

class MyThread051 extends Thread {
	//	�� ������ �ϴ� ��Ȱ�� �������� ���Լ��� ���������
	//	����ϴ� ������ ��Ȱ�� �� �����̴�.
	boolean		isStart = true;
	public void run() {
		//	���� �� ������� ���ѷ����� �ݺ��� �����̴�.
		//	������ ���� isStart = false�� �Ǹ�.....
		//	while�� ����� ���̴�.
		while(isStart) {
			System.out.println("���� ȫ�浿�̴�.");
			try {
				Thread.sleep(200);
			}
			catch(Exception e) {
			}
		}	//while
	}	//	run
}
