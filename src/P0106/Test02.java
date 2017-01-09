package P0106;
import		GUI.*;
import		java.awt.*;
import		javax.swing.*;
public class Test02 extends MyJFrame {

	public Test02() {
		//	이미 이 클래스는 컨테이너의 역활을 한다.
		BorderLayout	lay = new BorderLayout();
		this.setLayout(lay);
		
		JButton	b1 = new JButton("하늘을 우러러");
		JButton	b2 = new JButton("한점 부끄럼이 없기를");
		JButton	b3 = new JButton("입새에 이는 바람에도");
		JButton	b4 = new JButton("나는 괴로워했다.");
		JButton	b5 = new JButton("죽어가는 모든것을 사랑해야지");
	
		this.add("West", b1);
		this.add(BorderLayout.EAST, b2);
		this.add(b3, "North");
		this.add(b4, BorderLayout.SOUTH);
		this.add(b5);	//	이러면 Center에 들어간다.
		
		setSize(600, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test02();
	}
}

