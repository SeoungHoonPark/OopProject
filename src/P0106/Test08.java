package P0106;
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
public class Test08 {

	public Test08() {
		MyJFrame	f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		JTextField	field = new JTextField(10);
		String	text = 
"<html>시작 칸 번호<font color='red'>(S)</font></html>";
		JLabel	label = new JLabel(text);
		
		f.add(label);
		f.add(field);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test08();
	}
}
