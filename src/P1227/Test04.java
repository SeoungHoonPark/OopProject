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
		// �̰��� ���������� �����ϰ�
		// �̰��� ???�� ??�� ??�� ?? ���� ??�� ??�� ??�� ���� ����ϰ� �ʹ�.
		
		SimpleDateFormat f =
				new SimpleDateFormat("yyyy�� MM�� dd�� E���� HH�� mm�� ss��");
		
		String str = f.format(car.getTime());
		
		System.out.println(str);
	}
	public static void main(String[] args) {
		new Test04();
	}

}
