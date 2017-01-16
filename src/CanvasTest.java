import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.MyJFrame;

/**
 *	��� ĵ������ �ϳ� �ְ� �Ʒ��ʿ� ���� 2���� ��ġ�Ѵ�.
 *
 * 	1. �ϳ��� ĵ������ �����. -->
 * 	2. ���߸� 2�� ��ġ�Ѵ�.
 */
public class CanvasTest extends MyJFrame {
	
	public CanvasTest() {
		
		JButton startB = new JButton("����");
		JButton stopB = new JButton("����");
		
		JPanel p = new JPanel();
		
		p.add(startB);
		p.add(stopB);
		
		add("South",p);
		
		setSize(400, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CanvasTest();
	}
}

class Canvas01 extends Canvas{
	
	@Override
	public void paint(Graphics g) {
	}
}