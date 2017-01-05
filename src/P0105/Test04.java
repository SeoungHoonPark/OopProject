package P0105;

import java.awt.Window;
import GUI.MyJFrame;

/**
 *
 */
public class Test04 {
	public Test04() {
		MyJFrame f = new MyJFrame();		
		Window w = new Window(f);
		w.setSize(400,400);
		w.setVisible(true);
	}

	public static void main(String[] args) {
		new Test04();
	}
}
