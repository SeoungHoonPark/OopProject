package P0106;

import		GUI.*;
import		java.awt.*;
import		javax.swing.*;
public class Test01 {
	public Test01() {
		MyJFrame	f = new MyJFrame();
		//	컨테이너에 배치전략을 Grid 방식으로 하고자 한다.
		GridLayout	lay = new GridLayout(2, 3, 10, 10);
		//	2줄, 3칸짜리 격자를 만들어라
		//	(고로 이 컨테이너안에는 모두 6개까지 들어갈 수 있다.)
		f.setLayout(lay);
		
		JButton	b1 = new JButton("1번 단추");
		JButton	b2 = new JButton("2번 단추");
		JButton	b3 = new JButton("3번 단추");
		JButton	b4 = new JButton("4번 단추");
		JButton	b5 = new JButton("5번 단추");
		JButton	b6 = new JButton("6번 단추");
		JButton	b7 = new JButton("7번 단추");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test01();
	}
}
