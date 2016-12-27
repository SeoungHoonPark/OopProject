/**
 * 
 */
package P1227;

import java.text.ChoiceFormat;

/**
 *		학생의 점수를 입력받아서 학점을 출력하는 프로그램을 작성하세요
 */
public class Test05 {

	public Test05() {
		double[] limits = {0, 60,70,80,90};
		// limits를 만들때 주의사항
		// 반드시 오름차순 정렬되어야 한다.
		// 이것의 의미는 60~69사이는 하나의 문자로 바꾸고
		// 70~79사이는 하나의 문자로 바꾸고 ...
		//	90~ 	사이는 하나의 문자로 바꿔라	
		
		String forma[] = {"F", "D","C","B","A"};
		// format를 만들때 주의사항
		// limit의 개수와 반드시 일치해야 한다.
		
		ChoiceFormat f = new ChoiceFormat(limits, forma);
		// 특정 점수를 받은 학생의 학점을 구해보자
		
		int score = 69;
		String grade = f.format(score);
		
		System.out.println(score + " : " + grade);
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
