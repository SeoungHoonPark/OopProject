package P0112;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.MyJFrame;

/**
 *		Apdater 클래스
 *	
 *		마우스를 누르면 그 위치에 사각형이 그려지도록 해보자.
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
		//	비록 Adapter를 사용하지만 이벤트 등록은
		//	경청자 인터페이스이름으로 해야 한다.
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
		//	그러면 MouseListener 안의 모든 함수를 오버라이드할 필요없이
		//	내가 필요한 함수 하나만 오버라이드 하면된다.
		public void mousePressed(MouseEvent e) {
			//	할일
			//	마우스를 누를 좌표값 알아내고
			startX = e.getX();
			startY = e.getY();
			//	다시 그려달라고 부탁해요.
			repaint();
		}
	}
}