package P0106;
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
public class Test05 {
	public Test05() {
		MyJFrame	f = new MyJFrame();
		
		JButton	b1 = new JButton("1번 단추");
		JButton	b2 = new JButton("2번 단추");
		JButton	b3 = new JButton("3번 단추");
		JButton	b4 = new JButton("4번 단추");
		
		JPanel	p1 = new JPanel(new GridLayout(4, 1));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		
		JPanel	p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add("North", p1);
		
		f.add("East", p2);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}
}
