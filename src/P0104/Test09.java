package P0104;

/*
 * 	 ����
 * 		ArrayList�� �ϳ� �غ��ؼ�
 * 		�̰��� �����͸� �ְ� ���� �� �����̴�.
 * 		��,		1�� ������� �̰��� �����͸� �Է��� �����̰�
 * 				2�� ������� �̰��� ���̷��� ������ �� �����̴�.
 * 
 * 		��Ģ	5���� �����Ͱ� �ԷµǸ� ���̻� �Է��ϸ� �ȵȴ�.
 */
import		java.util.*;
public class Test09 {
	ArrayList	list = new ArrayList();
	
	//	�� �Լ��� �Ʊ� ������ â�� ������ �״� �Լ��̴�.
	synchronized void makeData(int num) {
		if(list.size() == 5) {
			//	������ ����� ���� �ؼ��� �ȵȴ�.
			try {
				System.out.println("ä��� ����� ���� ���ϴ�.");
				wait();
				//	�̼����� �� �Լ��� ����ϴ� �������
				//	�����ΰ� Block���·� �����ȴ�.
			}
			catch(Exception e) {}
		}
		//	â�� ���� �ϳ��� �־���.
		list.add(num);
		System.out.println(num + "�� ä�����ϴ�.");
		System.out.println("ä�� �� ���� â��� " + list.size() + " �� �ֽ��ϴ�.");
		//	�׷��� ���� ������ ������ ���� ����� �����ص� �Ǵ� ������
		//	�Ǿ���.
		notify();
		//	�̷��� �ϸ� � ������ �������°�?
		//	���� ���� Block ���·� �� �����尡 �Ͼ�� 
		//	���� �ϰ� �ȴ�.
		
	}
	//	�� �Լ��� �Ʊ� ������ â���� ������ ������ ���� �Լ��̴�.
	synchronized void	useData() {
		if(list.size() == 0) {
			//	�� ������� ������ ������ �� �� �����Ƿ�
			//	�����ΰ� Block ���·� �����Ǿ�� �Ѵ�.
			try {
				System.out.println("������ ���� ����� ���� ���ϴ�.");
				wait();
			}
			catch(Exception e) {}
		}
		int	num = (int) list.get(0);
		//	����� �� �����͸� List���� �����Ѵ�.
		list.remove(0);
		System.out.println(num + "�� ������ �����ϴ�.");
		System.out.println("������ �� �� ���� â��� " + list.size() + " �� �ֽ��ϴ�.");
		//	�׷��� list���� �ּ��� ���� �ϳ��� �����.
		//	���� ������ ä���� �ǹǷ� ������ ä��� ����� �����.
		notify();
	}
	
	public Test09() {
		Thread091	t1 = new Thread091(this);
		Thread092	t2 = new Thread092(this);
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new Test09();
	}

}

class Thread091 extends Thread {
	Test09	main;
	public Thread091(Test09 m) {
		main = m;
	}
	public void run() {
		for(int i = 0; i < 50; i++) {
			int	num = (int) (Math.random() * 101);
			main.makeData(num);
			int	sleep = (int)(Math.random() * (2000 - 500) + 500);
			try {
				Thread.sleep(sleep);
			}
			catch(Exception e) {}
		}
	}
}

class Thread092 extends Thread {
	Test09	main;
	public Thread092(Test09 m) {
		main = m;
	}

	public void run() {
		for(int i = 0; i < 50; i++) {
			main.useData();
			int	sleep = (int)(Math.random() * (2000 - 500) + 500);
			try {
				Thread.sleep(sleep);
			}
			catch(Exception e) {}
		}
	}
}