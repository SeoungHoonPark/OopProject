package P1209;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;

/**
 * @author hong
 *
 */
public class Test01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Frame f = new Frame();
	f.setLayout(new FlowLayout());
	
	JButton b = new JButton();
	b.setText("Å¬¸¯");
	f.add(b);
	f.setSize(400, 400);
	f.setVisible(true);

	}

}
