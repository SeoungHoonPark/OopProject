package P0111;
/*
 * 	단추를 누르면 색상 선택 대화상자를 보여주고
 * 	선택한 색상으로 화면을 칠하세요
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
//	이 클래스는 단추를 하나만들어서 이벤트를 사용할 예정이다.
//	이벤트 클래스를 따로 만들어서 사용했는데......
//	이 클래스 자체를 이벤트 클래스로 직접 사용할 수도 있다.
public class Test02 extends MyJFrame implements ActionListener {
	public Test02() {
		setLayout(new FlowLayout());
		JButton	btn = new JButton("색상 선택");
		btn.addActionListener(this);
		add(btn);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test02();
	}
	
	//	나자신이 이벤트 클래스가 되었으므로 이곳에 actionPerfomed()를
	//	만들어 주면 된다.
	public void actionPerformed(ActionEvent e) {
		//	할일
		//		색상 대화상자를 출력한다.
		Color	color = JColorChooser.showDialog(
				this, "색상 선택", Color.WHITE);
		//		선택한 색상으로 화면을 칠한다.
		if(color != null) {
			getContentPane().setBackground(color);
		}
	}
}


