/**
 * 
 */
package P1213;

/**
 *	문제 
 *	랜덤하게 반지름을 입력한 후 원의 넓이를 구하세요
 */
public class Static02 {
	public static void main(String[] args) {
		
		int r = (int)(Math.random() * 101);
		double area = r * r * Math.PI;
	}

}
