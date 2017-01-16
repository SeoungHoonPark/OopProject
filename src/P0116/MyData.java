package P0116;

import java.io.Serializable;

/**
 * ★ 직렬화가 되기 위해서는 해당 클래스는 반드시 직력화 가능 클래스가 되어야 하고 그 방법은
 *   implements Serializable 만 해주면 된다.
 *	직렬화 를 위한 데이터 클래스 
 */
public class MyData implements Serializable {
	String name;
	int age;
	float height;
	boolean gender;
	String tel;
	String addr;
	// 이후에 만든 함수는 어짜피 출력되지 못하므로 생략한다
}
