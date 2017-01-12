package P0112;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.MyJFrame;

/**
 * 	������ + ��ȣ���� + Canvas�� �̿��� Ŭ�������� 
 * 
 *	��� ĵ������ �ϳ� �ְ� �Ʒ��ʿ� ���� 2���� ��ġ�Ѵ�.
 * 
 *	���߸� ������ ĵ������ �׸��� �׸��� �����ϰ� 
 *	�ٽ� ���߸� ������ ĵ������ �׸� �׸��⸦ �����ϵ��� �Ѵ�.
 */
public class Test04 {
	MyJFrame f = new MyJFrame();
	DrawCanvas  can;
	JButton startB, stopB;
	DrawThread th;
	
	public Test04() {
		can = new DrawCanvas();
		startB = new JButton("Start");
		stopB = new JButton("Stop");
		
		startB.addActionListener(new ButtonEvent());
		stopB.addActionListener(new ButtonEvent());

		JPanel p = new JPanel();
		p.add(startB);
		p.add(stopB);
		
		f.add("Center", can);
		f.add("South", p);
		
		f.setSize(700,700);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test04();
	}
	
	class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton t = (JButton) arg0.getSource();
			
			if(t == startB){
				// �� ��
				// �����带 �⵿�ϸ� �ȴ�.
				// 1. newBorn
				th = new DrawThread(Test04.this);
				// 2. Runable���·� �����Ѵ�.
				th.start();
				
				// ��̷� ������ �Ǿ����Ƿ� �ٽô� ���߸� ������ ���ϰ� ����.
				startB.setEnabled(false);
				stopB.setEnabled(true);
			}else{
				// �� ��
				// �ڿ������� �����尡 ����ǵ��� ����.
				th.isStart = false;
				startB.setEnabled(true);
				stopB.setEnabled(false);
			}
		}
	}
}

class DrawCanvas extends Canvas{
	int startX, startY;
	int width, height;
	
	Color color;
	
	public DrawCanvas() {
		startX = startY = -1000;
	}
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(startX, startY, width, height);
	}
}

class DrawThread extends Thread{
	boolean isStart = true;	// �����尡 �������� �ݺ��ؾ� ���� �𸣹Ƿ� �����带 �����ϱ� ���� ����� ������ �Ѵ�.
	
	//�� ������� ���� Ŭ������ �����ؾ� �Ѵ�.
	// �׷��Ƿ� �� Ŭ������ ���� Ŭ������ ��ȣ������ �� �� �־�� �Ѵ�.
	Test04 main;
	public DrawThread(Test04 m) {
		main = m;
	}
	@Override
	public void run(){
		while (isStart == true) {
			// �� ��
			// 		�׸��� �׸� ��ǥ���� �����ϰ� �����ϰ� 
			int	x = (int)(Math.random() * (600 - 0 + 1) + 0);
			int	y = (int)(Math.random() * (600 - 0 + 1) + 0);
						
			// ���� ũ�⵵ �����ϰ� ��������.
			int	w = (int)(Math.random() * (200 - 50 + 1) + 50);
			int	h = (int)(Math.random() * (200 - 50 + 1) + 50);
			
			//		�׸��� ������ �����ϰ� ������ ��
			//		ĵ�������� �׸��� �׸����� �Ѵ�.
			int	red = (int)(Math.random() * 256);
			int	green = (int)(Math.random() * 256);
			int	blue = (int)(Math.random() * 256);
			
			Color	c = new Color(red, green, blue);
			//	ĵ�������� �׸��� �׸����� �Ѵ�.
			// �׸��� �׸����� ĵ���� 
			main.can.startX  = x;
			main.can.startY = y;
			main.can.width = w;
			main.can.height = h;
			main.can.color = c;
			main.can.repaint();
			// 
			try{
				Thread.sleep(500);
			}catch(Exception e){
				
			}
		}
	}
}