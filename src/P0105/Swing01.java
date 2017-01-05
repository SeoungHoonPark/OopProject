/**
 * 
 */
package P0105;

import GUI.MyJFrame;

/**
 *	Frame 하나를 만들어서 화면에 출력해 보자.
 */
public class Swing01 {

	public Swing01() {
		/* 객체지향에서 클래스를 사용하는 방법
		 1. new 시켜서 사용하는 방법
			has a
			장점 	여러번 사용할 수 있고 다른 클래스도 같이 사용할 수 있다.
			*/
		MyJFrame frame = new MyJFrame("내가 만든 첫번째 프로그램");
		//필요한 기능을 이용해서 처리하면 된다.
		// 나는 대화상자의 크기를 정하고 싶다.
		frame.setSize(400,400);
		// 필요한 시점에서 화면에 나타나게 하고 싶다.
		frame.setVisible(true);
		/*
			2. 상속 받아서 사용하는 방법
			is a
			장점 	이미 new가 된 상태이므로 그대로 사용하면 된다.
		*/
	}
	
	public static void main(String[] args) {
		new Swing01();
		}
}
