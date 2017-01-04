package P0104;

public class Test07 {
	int[]	num = new int[5];
	public Test07() {
		Thread071	t1 = new Thread071(this);
		Thread072	t2 = new Thread072(this);
		t1.start();
		t2.start();
	}
	public static void main(String[] args) {
		new Test07();
	}

}

class Thread071 extends Thread {
	Test07	main;
	public Thread071() {}
	public Thread071(Test07 m) {
		main = m;
	}
	public void run() {
		//	�� �����忡���� �迭������ �����͸� ����ϴ� ��Ȱ�� �� �����̴�.
		//	�� �����尡 5���� �����͸� �ϼ��Ҷ�������
		//	�ٸ� ������� �迭�� ������� ���ϰ� �ϰ�ʹ�.
		System.out.println("���� ������ �����̴�.");
		synchronized(main.num) {
			for(int i = 0; i < 5; i++) {
				int temp = (int)(Math.random() * 101);
				main.num[i] = temp;
				System.out.println(temp + "�� ����߾��");
				//	���½ð��� 0.5~2�� ���̷� �����ϰ� ���� �����̴�. 
				int	sleep = (int)(Math.random() * (2000 - 500) + 500);
				try {
					Thread.sleep(sleep);
				}
				catch(Exception e) {}
			}
			System.out.println("���� ������ ������.");
		}
	}
}

class Thread072 extends Thread {
	Test07	main;
	public Thread072() {}
	public Thread072(Test07 m) {
		main = m;
	}
	public void run() {
		//	�� �����忡���� �迭������ �����͸� ������ ����ϴ� ��Ȱ�� �� �����̴�.
		System.out.println("���� ����� �����̴�.");
		synchronized(main.num) {
			for(int i = 0; i < 5; i++) {
				int temp = main.num[i];
				System.out.println(temp + "�� ����߾��");
				//	���½ð��� 0.5~2�� ���̷� �����ϰ� ���� �����̴�. 
				int	sleep = (int)(Math.random() * (2000 - 500) + 500);
				try {
					Thread.sleep(sleep);
				}
				catch(Exception e) {}
			}
			System.out.println("���� ����� ������.");
		}
	}
}
