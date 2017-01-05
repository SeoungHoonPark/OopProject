package P0105;

import java.awt.FlowLayout;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *
 */
public class Test07 {
	public Test07() {
		MyJFrame f = new MyJFrame();
		// 이처럼 여러개의 도구가 담길 경우에는 배치전략을 지정해야 한다.
		// 1. 필요한 배치전략을 만든다.
		FlowLayout layout = new FlowLayout();
		
		// 2. 컨테이너에 setLayout()을 이용해서 배치전략을 등록한다.
		f.setLayout(layout);
		JButton b1 = new JButton("1번단축");
		JButton b2 = new JButton("2번단축");
		JButton b3 = new JButton("3번단축");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
		f.setSize(500,500);
		f.setVisible(true);
	}

	public static void main(String[] args) {	
		new Test07();
	}
}
