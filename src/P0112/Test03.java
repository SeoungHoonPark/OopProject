package P0112;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.MyJFrame;

/**
 *		Apdater Ŭ����
 *	
 *		���콺�� ������ �� ��ġ�� �簢���� �׷������� �غ���.
 */
public class Test03 {
	public Test03() {
		MyJFrame	f = new MyJFrame();
		DrawCanvas03	can = new DrawCanvas03();
		f.add(can);
		
		f.setSize(600, 600);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test03();
	}
}

class DrawCanvas03 extends Canvas {
	int		startX, startY;
	int		width, height;
	public DrawCanvas03() {
		startX = startY = -1000;
		width = 50;
		height = 50;
		//	��� Adapter�� ��������� �̺�Ʈ �����
		//	��û�� �������̽��̸����� �ؾ� �Ѵ�.
		this.addMouseListener(new CanvasEvent());
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		int	red = (int)(Math.random() * 256);
		int	green = (int)(Math.random() * 256);
		int	blue = (int)(Math.random() * 256);
		Color	c = new Color(red, green, blue);
		g.setColor(c);
		width = (int)(Math.random() * (200 - 50 + 1) + 50);
		height = (int)(Math.random() * (200 - 50 + 1) + 50);
		
		g.fillRect(startX, startY, width, height);
	}
	
	class CanvasEvent extends MouseAdapter {
		//	�׷��� MouseListener ���� ��� �Լ��� �������̵��� �ʿ����
		//	���� �ʿ��� �Լ� �ϳ��� �������̵� �ϸ�ȴ�.
		public void mousePressed(MouseEvent e) {
			//	����
			//	���콺�� ���� ��ǥ�� �˾Ƴ���
			startX = e.getX();
			startY = e.getY();
			//	�ٽ� �׷��޶�� ��Ź�ؿ�.
			repaint();
		}
	}
}