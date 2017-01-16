import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.MyJFrame;

/**
 *	가운데 캔버스를 하나 넣고 아래쪽에 단추 2개를 배치한다.
 *
 * 	1. 하나의 캔버스를 만든다. -->
 * 	2. 단추를 2개 배치한다.
 */
public class CanvasTest extends MyJFrame {
	
	public CanvasTest() {
		
		JButton startB = new JButton("시작");
		JButton stopB = new JButton("멈춤");
		
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