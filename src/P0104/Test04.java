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
			System.out.println("���� ȫ�浿�̴�.");
			try{
				Thread.sleep(200);
			}catch(Exception e){
			}
		}
		// ���Τ��� �������Ƿ� ���α׷��� ����Ƿ��� �����嵵 ����Ǿ�� �Ѵ�.
		t.stop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test04();
		System.out.println("�� ������");
	}

}

class MyThread041 extends Thread{
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println("���� ȫ�浿�̴�.");
			try{
				Thread.sleep(200);
			}catch(Exception e){
				
			}
		}
	}
}