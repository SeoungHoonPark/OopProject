/**
 * 
 */
package P1212;

/**
 * ���� for��
 *	10���� �迭�� ������ ���ڸ� �Է��� �� ���� ���ϼ���
 */
public class Array01 {
	public static void main(String[] args) {
		int[] num = new int[10];
		for( int i  = 0; i < num.length;i++){
			num[i] = (int)(Math.random() * 101);
		}
		
		int sum = 0;
		for(int temp: num){
			sum = sum + temp;
			System.out.println(sum);
		}
		System.out.println("����� = " + sum);
	}
}
