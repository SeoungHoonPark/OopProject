package P1212;

/**
 숙제7
	'A'에서 'Z'사이의 랜덤한 숫자 10개를 배열로 만들어서 저장한 후
	이 배열을 이용해서  String 클래스를 생성해 보세요.

	int[]	nums = new int[10];
 */
public class HomeWork7 {
	public static void main(String[] args) {
		
		int[] num = new int[10];
		for(int i = 0; i < num.length; i++){
			
			//A~Z까지의 랜덤한 숫자
			num[i] = (int)(Math.random() * ('Z' - 'A' + 1) +'A');
		}
		String str = new String(num, 0, 10);
		System.out.println("str" + str);
	}
}
