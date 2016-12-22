/**
 * 
 */
package P1214;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.TextField;

/**
 * 
 */
public class Test01  {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame my = new MyFrame();
		my.setLayout(new FlowLayout());
		
		TextField text = new TextField();
		my.add(text);
		
		Checkbox box = new Checkbox(null);
		
		my.setSize(400,400);
		my.setVisible(true);
		
	}
}
