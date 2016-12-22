/**
 * 
 */
package P1221;

/**
 * @author hong
 *
 */
public class Test05 {
	public Test05() {
		int[] nums = {25,30,38,75,47};
		int a = 5;
		int b = 3;
		int dap = 0;
		try{
			dap = nums[b] / a;
			
			// 이처럼 여러가지 복합적인 예외를 구분해서 처리해야 한다면
			// 다중 catch 를 사용할 수 있다.
		}catch (ArithmeticException e) {
			dap = nums[b];
		}catch (ArrayIndexOutOfBoundsException e) {
			dap = 0;
		}catch(Exception e){
			System.out.println("이유를 모르는 에러가 발생");
		}
		
		// 이 문장은 0으로 나누는 경우에 예외가 발생하고 
		// 5이상의 배열을 사용하는 경우에도 예외가 발생한다.
		
		System.out.println("dap = " + dap);
	}
	public static void main(String[] args) {
		new Test05();
	}

}
