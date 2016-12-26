/**
 * 
 */
package P1226;

import java.util.StringTokenizer;

/**
 *		시를 하나 작성한 후 공백을 중심으로 단어를 나눠 출력하세요.
 */
public class Test04 {
	public Test04() {
		String str = "죽는 날까지 하늘을 우러러 한점 부끄럼 없기를";
		// 이 내용을 공백을 중심으로 분리하기 위해서
		// StringTokenizer를 이용해 보기로 한다.
		
		StringTokenizer token = new StringTokenizer(str);
		// 이미 분리가 되어 있다.
		
		int count  = token.countTokens();
		System.out.println(count);
		
		// 이것을 꺼내보자.
//		for(int i = 0; i < count; i++){
//			String temp = token.nextToken();
//			System.out.println(temp);
			
			// 문제는 하나씩 꺼내면 꺼낸 내용은 임시 메모리에서 삭제된다.
			// 그러므로 필요하면 배열 등을 이용해서 다시 저장한 후 사용해야 한다.
//		}
		System.out.println("다시 꺼내기");
//		for(int i = 0; i < count; i++){
//			String temp = token.nextToken();
//			System.out.println(temp);
//		}
		
		//만약 나눠진 개수를 모르면?
		
		while(token.hasMoreTokens()){
			//아직 데이터가 남아있니?
			// 꺼낼 데이터가 있으면 반복하고
			String temp = token.nextToken();
			System.out.println(temp);
		}
			// 꺼낼 데이터가 없으면 반복을 종료하라.
	}

	public static void main(String[] args) {
		new Test04();
	}
}
