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
 *		���߸� Ŭ���ϸ� ȭ���� ������ �����ϰ� ��ȭ��Ű�� ���α׷��� ������.
 */
public class Test09 extends MyJFrame{	
	public Test09() {
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn = new JButton("��ư");
		this.add(btn);
		this.setSize(400,500);
		this.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = (int)(Math.random() * (255 - 0 + 1) + 1);
				int green = (int)(Math.random() * (255 - 0 + 1) + 1);
				int blue = (int)(Math.random() * (255 - 0 + 1) + 1);			
				
				Color color = new Color (red, green, blue);
				
				System.out.println("Ŭ�� �ϼ̳׿�. red=" + red + " : green = " + green + " : blue= " + blue );
				System.out.println("color : " + color);
				getContentPane().setBackground(color);
			}
		});
	}

	public static void main(String[] args) {
		new Test09();
	}
}