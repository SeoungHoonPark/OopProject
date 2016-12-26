/**
 * 
 */
package P1226;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 특정 문자열을 입력한 후 그 문자열 중에서 원하는 규칙에 맞는 부분만 골라서 출력하라.
 * 
 */
public class Test02 {

	public Test02() {
		String tel = "[HP] : 010-8755-0895";
		// 이 중에서 전화번호 부분만 꺼내고 싶다.
		/* 방법
		 * 	정규식 검사를 진행한다. 
		*/
		Pattern p = Pattern.compile("0[0-9]{2}-[0-9]{3,4}-[0-9]{4}");
		Matcher m = p.matcher(tel);
		if(m.find()){
			//find 함수를 이용해서 규칙에 맞는 부분이 있는지 확인하고
			String group = m.group(); // 존재하면 맞는 부분만 꺼내면 된다.
			System.out.println("당신의 전화번호는 " + group);
		}
	}
	public static void main(String[] args) {
		new Test02();
	}

}
