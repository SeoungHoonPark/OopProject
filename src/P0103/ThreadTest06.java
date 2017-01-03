package P0103;

/**
 *
 */
public class ThreadTest06 {

	public ThreadTest06() {
		MyThread061	temp1 = new MyThread061();
		MyThread062	temp2 = new MyThread062();
		
		Thread t1 = new Thread(temp1);
		Thread t2 = new Thread(temp2);
		
		t1.start();
		t2.start();		
	}

	public static void main(String[] args) {
		new ThreadTest06();
	}
}

class MyThread061 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 200; i++){
			System.out.println( "내가  간다. " + i);
			
			try{
				Thread.sleep(200);
			}catch(Exception e){
				
			}
		}
	}	
}

class MyThread062 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 200; i++){
			System.out.println( "\t\t당신이  간다. " + i);
			
			try{
				Thread.sleep(200);
			}catch(Exception e){
				
			}
		}
	}	
}