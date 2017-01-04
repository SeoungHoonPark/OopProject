/**
 * 
 */
package P0104;

/**
 * @author hong
 *
 */
public class Test04 {

	public Test04() {
		MyThread041 t = new MyThread041();
		t.start();
		for(int i = 0; i < 100; i++){
			System.out.println("나는 홍길동이다.");
			try{
				Thread.sleep(200);
			}catch(Exception e){
			}
		}
		// 메인ㅇ이 끝났으므로 프로그램이 종료되려면 스레드도 종료되어야 한다.
		t.stop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test04();
		System.out.println("난 끝나요");
	}

}

class MyThread041 extends Thread{
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println("나는 홍길동이다.");
			try{
				Thread.sleep(200);
			}catch(Exception e){
				
			}
		}
	}
}