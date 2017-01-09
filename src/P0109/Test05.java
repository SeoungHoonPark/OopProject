package P0109;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import GUI.MyJFrame;

/**
 *		TestArea + Scroll
 */
public class Test05 {
	public Test05() {
		MyJFrame f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		JTextArea area = new JTextArea(5,20);
		JScrollPane sp = new JScrollPane(area);
		f.add(sp);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}

}
