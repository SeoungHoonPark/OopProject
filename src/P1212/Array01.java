/**
 * 
 */
package P1212;

/**
 * 향상된 for문
 *	10개의 배열에 랜덤한 숫자를 입력한 후 합을 구하세요
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
		System.out.println("결과는 = " + sum);
	}
}
