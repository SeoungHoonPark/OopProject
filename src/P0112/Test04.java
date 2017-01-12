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
 * 	스레드 + 상호참조 + Canvas를 이용한 클래스파일 
 * 
 *	가운데 캔버스를 하나 넣고 아래쪽에 단추 2개를 배치한다.
 * 
 *	단추를 누르면 캔버스에 그림을 그리기 시작하고 
 *	다시 단추를 누르면 캔버스를 그림 그리기를 중지하도록 한다.
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
				// 할 일
				// 스레드를 기동하면 된다.
				// 1. newBorn
				th = new DrawThread(Test04.this);
				// 2. Runable상태로 전위한다.
				th.start();
				
				// 재미로 시작이 되었으므로 다시는 단추를 누르지 못하게 하자.
				startB.setEnabled(false);
				stopB.setEnabled(true);
			}else{
				// 할 일
				// 자연스럽게 스레드가 종료되도록 하자.
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
	boolean isStart = true;	// 스레드가 언제까지 반복해야 할지 모르므로 스레드를 종료하기 위한 제어변수 역할을 한다.
	
	//이 제어변수는 위쪽 클래스가 제어해야 한다.
	// 그러므로 이 클래스는 위쪽 클래스와 상호참조를 할 수 있어야 한다.
	Test04 main;
	public DrawThread(Test04 m) {
		main = m;
	}
	@Override
	public void run(){
		while (isStart == true) {
			// 할 일
			// 		그림을 그릴 좌표값을 랜덤하게 생성하고 
			int	x = (int)(Math.random() * (600 - 0 + 1) + 0);
			int	y = (int)(Math.random() * (600 - 0 + 1) + 0);
						
			// 원의 크기도 랜덤하게 생성하자.
			int	w = (int)(Math.random() * (200 - 50 + 1) + 50);
			int	h = (int)(Math.random() * (200 - 50 + 1) + 50);
			
			//		그림의 색상을 랜덤하게 생성한 후
			//		캔버스에게 그림을 그리도록 한다.
			int	red = (int)(Math.random() * 256);
			int	green = (int)(Math.random() * 256);
			int	blue = (int)(Math.random() * 256);
			
			Color	c = new Color(red, green, blue);
			//	캔버스에게 그림을 그리도록 한다.
			// 그림을 그리려면 캔버스 
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