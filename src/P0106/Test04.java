package P0106;

import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
public class Test04 {
	public Test04() {
		MyJFrame	f = new MyJFrame();
		f.setLayout(new BorderLayout());	//	생략 가능
		
		JButton	b1 = new JButton(" 확인 ");
		JButton	b2 = new JButton(" 취소 ");
		//	나는 단추 2개를 포장해야겠다.
		//	이처럼 컴포넌트를 포장하는 기능을 가진 컨테이너가
		//	바로 Panel 이다.
		JPanel	p = new JPanel();
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());		//	생략 가능
		p.add(b1);
		p.add(b2);
		
		f.add(p, "South");
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test04();
	}
}




