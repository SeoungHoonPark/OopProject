package P0112;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import GUI.MyJFrame;

/**
 *		마치 그림판의 연필기능처럼 그림을 그릴 수 있는 프로그램을 만들어보자
 */
public class Test02 {
	MyJFrame f = new MyJFrame();
	public Test02() {
		DrawCanvas02 dc = new DrawCanvas02();
		f.add(dc);
		
		f.setSize(600,600);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test02();
	}
}

// 그림을 그릴 수 있는 도구가 필요하다.
// 이것을 Canvas를 이용해서 이 도구를 준비해 놓자.
class DrawCanvas02 extends Canvas {
	int startX, startY, endX, endY;
	// 순간마다 선을 그릴 좌표를 기억할 변수
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	public DrawCanvas02() {
		startX= startY= endX = endY = -100;
		// 위치를 캔버스바깥으로 조절해서 안보이도록 한다.
		
		// 나 자신 canvas에 이벤트를 등록한다.
		// 만약 하나의 이벤트 클래스가 두개 이상의 경청자를 사용했으면...
		// 이벤트 등록도 2번 해야 한다.
		MouseEvent evt = new MouseEvent();
		
		this.addMouseListener(evt);
		this.addMouseMotionListener(evt);
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawLine(startX, startY, endX, endY);
	}
	// 이제 마우스를 움직이면 좌표값을 바꾸어서 그림이 그려지도록 하자.
	
	 class MouseEvent implements MouseListener, MouseMotionListener {
		 
		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			//할일
			// 		실제로 그림을 그려야 한다.
			// 		현재 시작위치는 먼저 그림의 마지막 위치가 되어야 한다.
			
			startX = endX;
			startY = endY;
			// 움직인 좌표가 마지막 좌표가 되어야 한다.
			endX = e.getX();
			endY = e.getY();
			// 이제 좌표를 수정했으므로 다시 그림을 그려야 한다.
			// 그림은 paint()가 그려야 한다.
			
			// jvm에게 paint()를 호출해 달라고 부택해야 한다. 절대로 사용자가 직접 호출 할 수 없다.
			repaint();
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent arg0) {
			
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// 어떤 이벤트가 발생하면 이벤트에 대한 정보를 jvm이 주면서 해당 함수를 실행한다.
			// 할일 
			// 		그 위치를 그림을 그릴 시작 좌표로 잡아주어야 한다.
			
			startX = endX = e.getX(); 
			startY = endY = e.getY();
		}
		
		//
		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {
			// 할일
			// 그림을 그리지 못하도록 좌표값을 canvas밖으로 이동시킨다.
			startX= startY= endX = endY = -100;
		}
		 
	 }
}

