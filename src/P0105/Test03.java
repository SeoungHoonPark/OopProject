/**
 * 
 */
package P0105;

import java.awt.Dialog;

import GUI.MyJFrame;

/**
 * @author hong
 *
 */
public class Test03 {

	public Test03() {
		MyJFrame f = new MyJFrame();
		Dialog	d = new Dialog(f);
		d.setSize(400,400);
		d.setVisible(true);
	}

	public static void main(String[] args) {
		new Test03();
	}

}
