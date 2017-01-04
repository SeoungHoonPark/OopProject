package P0104;

public class Test10 {

	public Test10() {
		Thread101	t = new Thread101();
		Thread102	t2 = new Thread102();
		t.start();
		t2.start();
		//	���� �� ������ t �����尡 ����Ǳ� ������ ��������
		//	���ϵ��� �ϰ��� �Ѵ�.
		//	��ó�� Ư�� �����尡 �ٸ������忡 ������ �ɶ�
		//	�������� ���ϰ� �ϴ� ���	join
		try {
			t.join();
			t2.join();
			//	t �����尡 Block�� �Ǵ°��� �ƴϰ�
			//	���� �������� ���α׷�(������ ����) =>	���� ���μ���
			//	�� �ߴܵǴ� ���̴�.
			//	��������	������ ������(t)�� ��ĥ������	
		}
		catch(Exception e){}
		System.out.println("������");
	}

	public static void main(String[] args) {
		System.out.println("�����ؿ�");
		new Test10();
	}
}

class Thread101 extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("���� ���̷μ��̴�" + i);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {}
		}
	}
}

class Thread102 extends Thread {
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("���� ���̷μ��̴�" + i);
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {}
		}
	}
}

