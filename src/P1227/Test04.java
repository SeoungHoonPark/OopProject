/**
 * 
 */
package P1227;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *		
 */
public class Test04 {
	public Test04() {
		Calendar car = Calendar.getInstance();
		// 이것이 최종결과라고 가정하고
		// 이것을 ???년 ??월 ??일 ?? 요일 ??시 ??분 ??초 으로 출력하고 싶다.
		
		SimpleDateFormat f =
				new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
		
		String str = f.format(car.getTime());
		
		System.out.println(str);
	}
	public static void main(String[] args) {
		new Test04();
	}

}
