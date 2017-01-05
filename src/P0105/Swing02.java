package P0105;

import GUI.MyJFrame;

/**
 *	
 */
public class Swing02 extends MyJFrame {
	public Swing02() {
		// 이 클래스는 이미 new된 상태이다.
		// 즉 Frame이 만들어졌다.
		
		// 이것을 이용해서 필요한 조작을 하면 된다.
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Swing02();
	}
}
