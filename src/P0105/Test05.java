package P0105;

import java.awt.Color;

import javax.swing.JPanel;

import GUI.MyJFrame;

/**
 *
 */
public class Test05 {
	public Test05() {
		
		MyJFrame f = new MyJFrame();
		JPanel p = new JPanel();
		p.setBackground(Color.red);
		f.add(p);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}

}
