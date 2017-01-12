package P0112;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import GUI.MyJFrame;

/**
 *		��ġ �׸����� ���ʱ��ó�� �׸��� �׸� �� �ִ� ���α׷��� ������
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

// �׸��� �׸� �� �ִ� ������ �ʿ��ϴ�.
// �̰��� Canvas�� �̿��ؼ� �� ������ �غ��� ����.
class DrawCanvas02 extends Canvas {
	int startX, startY, endX, endY;
	// �������� ���� �׸� ��ǥ�� ����� ����
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	public DrawCanvas02() {
		startX= startY= endX = endY = -100;
		// ��ġ�� ĵ�����ٱ����� �����ؼ� �Ⱥ��̵��� �Ѵ�.
		
		// �� �ڽ� canvas�� �̺�Ʈ�� ����Ѵ�.
		// ���� �ϳ��� �̺�Ʈ Ŭ������ �ΰ� �̻��� ��û�ڸ� ���������...
		// �̺�Ʈ ��ϵ� 2�� �ؾ� �Ѵ�.
		MouseEvent evt = new MouseEvent();
		
		this.addMouseListener(evt);
		this.addMouseMotionListener(evt);
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawLine(startX, startY, endX, endY);
	}
	// ���� ���콺�� �����̸� ��ǥ���� �ٲپ �׸��� �׷������� ����.
	
	 class MouseEvent implements MouseListener, MouseMotionListener {
		 
		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			//����
			// 		������ �׸��� �׷��� �Ѵ�.
			// 		���� ������ġ�� ���� �׸��� ������ ��ġ�� �Ǿ�� �Ѵ�.
			
			startX = endX;
			startY = endY;
			// ������ ��ǥ�� ������ ��ǥ�� �Ǿ�� �Ѵ�.
			endX = e.getX();
			endY = e.getY();
			// ���� ��ǥ�� ���������Ƿ� �ٽ� �׸��� �׷��� �Ѵ�.
			// �׸��� paint()�� �׷��� �Ѵ�.
			
			// jvm���� paint()�� ȣ���� �޶�� �����ؾ� �Ѵ�. ����� ����ڰ� ���� ȣ�� �� �� ����.
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
			// � �̺�Ʈ�� �߻��ϸ� �̺�Ʈ�� ���� ������ jvm�� �ָ鼭 �ش� �Լ��� �����Ѵ�.
			// ���� 
			// 		�� ��ġ�� �׸��� �׸� ���� ��ǥ�� ����־�� �Ѵ�.
			
			startX = endX = e.getX(); 
			startY = endY = e.getY();
		}
		
		//
		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {
			// ����
			// �׸��� �׸��� ���ϵ��� ��ǥ���� canvas������ �̵���Ų��.
			startX= startY= endX = endY = -100;
		}
		 
	 }
}

