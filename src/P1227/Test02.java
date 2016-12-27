package P1227;

import java.util.Calendar;

/**
 *			
 */
public class Test02 {
	
	public Test02() {
		
		Calendar car = Calendar.getInstance();
		
		int year = car.get(Calendar.YEAR);
		int month = car.get((Calendar.MONTH)+1 );
		
		System.out.println(year + "³â " + month + "¿ù ");
		
	}
	public static void main(String[] args) {
		new Test02();	
	}
}
