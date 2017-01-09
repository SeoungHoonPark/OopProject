package P0106;
/*
 * 	문제
 * 		단추 두개를 만들고 	첫번째 단추를 클릭하면 빨간색으로 칠하고
 * 							첫번째 단추를 클릭하면 파란색으로 칠하세요
 */
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
public class Test06 {
	MyJFrame	f;
	public Test06() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		JButton	b1 = new JButton("빨간색 단추");
		JButton	b2 = new JButton("파란색 단추");
		b1.addActionListener(new RedButtonEvent());
		b2.addActionListener(new BlueButtonEvent());
		
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test06();
	}
	//	단추를 클릭하는 이벤트를 감시하는 경청자
	//	ActionListener 이다.
	//	실행함수
	//	actionPerformed()
	class RedButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			f.getContentPane().setBackground(Color.red);
		}
	}
	class BlueButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			f.getContentPane().setBackground(Color.blue);
		}
	}
}




