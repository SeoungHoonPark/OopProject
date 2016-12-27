package P1227;

import java.text.DecimalFormat;

/**
 *
 */
public class Test03 {
	public Test03() {
		float a = 34256.3546f;
		// 이 숫자가 최종 결과라고 가정하자.
		// 나는 이 숫자를 3자리마다 .를 붙이고 소수 이하는 3자리만 출력하도록 하고자 하자.
		
		DecimalFormat f = new DecimalFormat("#,###,###.000");
		
		String str = f.format(a);
		
		System.out.println(str);
		
		
	}
	public static void main(String[] args) {
		new Test03();
	}
}
