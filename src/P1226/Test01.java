/**
 * 
 */
package P1226;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 전화번호를 입력한 후 그것이 전화번호 유형에 맞는지 검사하라
 * 
 */
public class Test01 {
	
	public Test01() {
		String tel = "010-8755-0895";
		// ★★★★★★★
		// Pattern 클라스를 이용해서 검사하고 싶은 정규식 문법을 만든다.
		// 참고 이 클래스는 생성자 함수가 없으므로 절대로 new 시켜서 사용할 수 없다.
		
		Pattern ptn = Pattern.compile("0[0-9]{2}-[0-9]{3,4}-[0-9]{4}");
		// 대신 compile함수를 이용해서
		//	정규식을 등록하면서 대신 만들어 달라고 해야한다.
		
		// 이 클래스에게 정규식 문법을 검사해 달라고 요구한다.
		//	문법 검사 함수가 matcher()
		//	이 함수는 검사 결과를 Matcher라는 클래스로 결과에 대한 모든 정보를 묶어서 알려주도록 되어있다.
		
		Matcher m = ptn.matcher(tel);
		// 이제 Matcher 클래스 안에 검사한 정보가 기억되어 있다.
		// 검사 결과 중에서 맞는지 틀린지를 알려주는 함수가 Matcher()함수다
		if(m.matches()){
			System.out.println("올바른 전화번호입니다.");
		}else{
			System.out.println("잘못된 전화번호입니다.");
		}
		
		
	}
		
	public static void main(String[] args) {
		
		new Test01();
		
	}
}
