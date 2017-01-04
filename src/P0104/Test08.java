package P0104;


/**
 * @author hong
 *
 */
public class Test08 {

	synchronized void abc(){
		// �� �Լ��� ȣ���� �����带 �˾Ƴ���.
		String name = Thread.currentThread().getName();
		System.out.println(name + "�����尡 abc�Լ��� ����ϱ� �����ߴ�.");
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		System.out.println(name + "�����尡 abc�Լ��� ����ϱ� �����ߴ�.");
	}
	synchronized void xyz(){
		// �� �Լ��� ȣ���� �����带 �˾Ƴ���.
				String name = Thread.currentThread().getName();
				System.out.println(name + "�����尡 xyz�Լ��� ����ϱ� �����ߴ�.");
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
				System.out.println(name + "�����尡 xyz�Լ��� ����ϱ� �����ߴ�.");
	}
	
	public Test08() {
		Test08 main;
		Thread081 t1 = new Thread081(this, "ȫ�浿");
		Thread082 t2 = new Thread082(this, "�ٰ���");
		t1.start();
		t2.start();
	}
	public static void main(String[] args) {
		new Test08();
	}
}

class Thread081 extends Thread{
	Test08 main;
	
	public Thread081() {
	}
	public Thread081(Test08 m, String n) {
		super(n);
	}
	public void run(){
		main.abc();
		main.xyz();
	}
}
class Thread082 extends Thread{
	Test08 main;
	public Thread082() {
	}
	public Thread082(Test08 m, String n) {
		super(n);
	}
	public void run(){
		main.abc();
		main.xyz();
	}
}