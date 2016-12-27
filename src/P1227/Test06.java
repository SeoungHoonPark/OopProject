/**
 * 
 */
package P1227;

import java.text.ChoiceFormat;

/**
 *
 */
public class Test06 {

	public Test06() {
		// choiceFormat을 만들때 limit와 format를 하나로 만들 수 있다.
		/* 	만드는 형식은
		 *  	60#D => <=의 의미이고
		 *  	70<C < 의 의미이다
		 *  	
		 *  	이것을 |를 이용해서 연결해서 사용하면 된다.
		*/
		String pattern = "0#F|60#D|70#C|80<B|90#A";
		// 60#D 60 <=이며 다음 숫자보다는 작은경우는 D로 처리한다.
		// 80<B 80 <이며 다음 숫자보다는 작은경우는 B로 처리한다.
		
		ChoiceFormat f = new ChoiceFormat(pattern);
		
		int score = 80;
		String grade = f.format(score);
		
		System.out.println(grade);
		
	}
	
	public static void main(String[] args) {
		new Test06();
	}

}
