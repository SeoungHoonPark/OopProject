package P1220;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class Test03 {
	Button b;
	Test03(){
		Frame f = new Frame();
		Button b = new Button("´­·¯ºÁ");
		f.add(b);
		f.setSize(400, 400);
		f.setVisible(true);
		b.addActionListener(new MyEvent());
	}
	
	public static void main(String[] args) {
		new Test03();
	}
	class MyEvent implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
					System.out.println("³Ê ´ÜÃß ´­·¶Áö");
		}
	}
}
