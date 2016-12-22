/**
 * 
 */
package P1221;

/**
 *
 */
public class Test10 {
	public Test10() {
		String str ="123";
		
		int num = 0;
				try{
				num = 	Integer.parseInt(str);
				}catch(Exception e){
					num = 0;
				}
		System.out.println(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test10();
	}
}
