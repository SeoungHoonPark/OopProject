/**
 * 
 */
package P0105;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.MyJFrame;

/**
 * @author hong
 *
 */
public class Test06 extends MyJFrame{

	public Test06() {
		// 이미 이 클래스는 Frame의 기능을 하고 있다.
		ImageIcon icon = new ImageIcon("src/P0105/dog.png");
		JButton btn = new JButton(icon);
		add(btn);
		
		this.setSize(400,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Test06();
	}

}
