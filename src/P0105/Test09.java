/**
 * 
 */
package P0105;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.MyJFrame;

/**
 *		단추를 클릭하면 화면의 색상을 랜덤하게 변화시키는 프로그램을 만들어보자.
 */
public class Test09 extends MyJFrame{	
	public Test09() {
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn = new JButton("버튼");
		this.add(btn);
		this.setSize(400,500);
		this.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = (int)(Math.random() * (255 - 0 + 1) + 1);
				int green = (int)(Math.random() * (255 - 0 + 1) + 1);
				int blue = (int)(Math.random() * (255 - 0 + 1) + 1);			
				
				Color color = new Color (red, green, blue);
				
				System.out.println("클릭 하셨네요. red=" + red + " : green = " + green + " : blue= " + blue );
				System.out.println("color : " + color);
				getContentPane().setBackground(color);
			}
		});
	}

	public static void main(String[] args) {
		new Test09();
	}
}