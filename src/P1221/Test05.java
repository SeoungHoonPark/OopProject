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
			
			// ��ó�� �������� �������� ���ܸ� �����ؼ� ó���ؾ� �Ѵٸ�
			// ���� catch �� ����� �� �ִ�.
		}catch (ArithmeticException e) {
			dap = nums[b];
		}catch (ArrayIndexOutOfBoundsException e) {
			dap = 0;
		}catch(Exception e){
			System.out.println("������ �𸣴� ������ �߻�");
		}
		
		// �� ������ 0���� ������ ��쿡 ���ܰ� �߻��ϰ� 
		// 5�̻��� �迭�� ����ϴ� ��쿡�� ���ܰ� �߻��Ѵ�.
		
		System.out.println("dap = " + dap);
	}
	public static void main(String[] args) {
		new Test05();
	}

}
