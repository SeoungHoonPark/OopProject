package P0104;


/**
 * @author hong
 *
 */
public class Test08 {

	synchronized void abc(){
		// 이 함수를 호출한 스레드를 알아내자.
		String name = Thread.currentThread().getName();
		System.out.println(name + "스레드가 abc함수를 사용하기 시작했다.");
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		System.out.println(name + "스레드가 abc함수를 사용하기 종료했다.");
	}
	synchronized void xyz(){
		// 이 함수를 호출한 스레드를 알아내자.
				String name = Thread.currentThread().getName();
				System.out.println(name + "스레드가 xyz함수를 사용하기 시작했다.");
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
				System.out.println(name + "스레드가 xyz함수를 사용하기 종료했다.");
	}
	
	public Test08() {
		Test08 main;
		Thread081 t1 = new Thread081(this, "홍길동");
		Thread082 t2 = new Thread082(this, "바가지");
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