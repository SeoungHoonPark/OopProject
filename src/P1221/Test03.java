/**
 * 
 */
package P1221;

/**
 * @author hong
 *
 */
public class Test03 {
	public Test03() {
		int dap = 0;
		try{
			
			for(int i = -3; i <= 3; i++){
	//			try{
	//				dap = 25 / i;
	//			}catch(Exception e){
	//				dap = 25;
	//			}
				
				System.out.println(" dap = " + dap); //예외발생 요소 i = 0
			}
		}catch (Exception e) {
			dap = 25;
		}
	}
	public static void main(String[] args) {
		new Test03();
	}

}
