package P0106;

import	java.awt.event.*;
import 	java.awt.*;
import 	javax.swing.*;
import 	GUI.*;

public class Test07 {
	MyJFrame	f;
	JButton		b1, b2;
	public Test07() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		b1 = new JButton("핑크색 단추");
		b2 = new JButton("하늘색 단추");
		
		ButtonEvent	evt = new ButtonEvent();
		b1.addActionListener(evt);
		b2.addActionListener(evt);
		
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test07();
	}
	//	이벤트 클래스는 하나만 만든다.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	이벤트가 발생하면 운영체제가 인식을 한 후
			//	그것을 JVM에게 알려준다.
			//	JVM은 이벤트의 종류를 분석한 후 해당 함수를 
			//	실행시킨다.
			//	이때 이 함수에 JVM은 발생한 이벤트 정보를 알려주게 된다.
			//	물론	클래스로 만들어서...
			//		ActionEvent e	이 JVM 이 알려주는
			//		이벤트 정보를 받을 매개변수이다.
			//	우리는 이 정보 클래스를 이용해서 필요한 정보를
			//	얻어서 필요한 조치를 하면 된다.
			//	할일
			//		어느 단추에서 이벤트가 발생했는지 알아야 한다.
			//	이때 사용하는 함수		getSource()
			//	이 함수는 이벤트가 발생한 객체(단추)의 주소를
			//	알아내는 함수
			JButton	target = (JButton) e.getSource();
			if(target == b1) {
				f.getContentPane().setBackground(Color.pink);
			}
			else if(target == b2) {
				f.getContentPane().setBackground(Color.cyan);
			}
		}
	}
}


