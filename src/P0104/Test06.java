/**
 * 
 */
package P0104;

/**
 * @author hong
 *
 */
public class Test06 {
	int num = 0;
	public Test06() {
		MyThread061 t1 = new MyThread061(this);
		MyThread062 t2 = new MyThread062(this);
		t1.start();
		t2.start();		
	}

	public static void main(String[] args) {
		new Test06();
	}
}

class MyThread061 extends Thread{
	// 이 클래스가 위쪽에 있는 클래스와 상호 참조를 하도록 한다.
	// 왜냐하면 위쪽에 있는 num변수를 사용할 예정이므로
	Test06 main;
	public MyThread061(){
		
	}
	public MyThread061(Test06 m){
		this.main  = m;
	}
	public void run(){
		for(int i = 0; i < 1000; i++){
			int num = (int)(Math.random() *101);
			main.num = num;
			System.out.println("main.num = " + num + "기억했어요");
		}
	}
}
class MyThread062 extends Thread{
	Test06 main;
	public MyThread062(){}
	public MyThread062(Test06 m){
		this.main = m;
	}
	
	public void run(){
		for(int i = 0; i < 1000; i++){
			int num = main.num;
			System.out.println("\t\t main.num = " + num + "가지고 왔어요");
		}
	}	
}