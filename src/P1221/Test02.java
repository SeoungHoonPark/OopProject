/**
 * 
 */
package P1221;

/**
 *
 */
public class Test02 {	
	public Test02() {
	
			int a = 5;
			int b = 25;
			int c = 0;
			
			try{
				c = b / a;
			}catch (Exception e) {
				c = b;
			}
			System.out.println("°á°ú = " + c);
	}
	
	public static void main(String[] args) {
		new Test02();
	}
}
