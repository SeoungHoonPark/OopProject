package P0116;
/*
 * 	적당하게 그림을 그리다가 저장하는 기능을 가진 클래스를 만든다.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import		java.io.*;
//	그림의 정보가 여러개 필요하다.	사각형이 몇개 그려질지 모른다.
//	이 정보를 기억하기 위해서 컬렉션을 준비하자.
import		java.util.*;
public class DrawSaveTest01 {
	ArrayList	list = new ArrayList();
	public DrawSaveTest01() {
		MyJFrame	f = new MyJFrame();
		DrawCanvas01	can = new DrawCanvas01(this);
		JButton		btn = new JButton("저장하기");
		btn.addActionListener(new ButtonEvent());
		//	m65-056-371
		f.add("Center", can);
		f.add("South", btn);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new DrawSaveTest01();
	}
	//	단추를 누르면 그림 정보를 통채로 저장하자.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	할일
			//		저장한다.
			FileOutputStream	fout = null;
			ObjectOutputStream	oout = null;
			try {
				fout = new FileOutputStream("D:\\그림.txt");
				oout = new ObjectOutputStream(fout);
				
				oout.writeObject(list);
			}
			catch(Exception e1) {
				
			}
		}
	}
	
	
	
}

class DrawCanvas01 extends Canvas {
	DrawSaveTest01	main;
	int	x, y, w, h;
	Color	c;
	public DrawCanvas01(DrawSaveTest01 m) {
		main = m;
		x = y = w = h = -100;
		this.addMouseListener(new MousePress01());
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		g.setColor(c);
		g.drawRect(x, y, w, h);
	}
	class MousePress01 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			w = (int)(Math.random() * (200 - 50 + 1) + 50);
			h = (int)(Math.random() * (200 - 50 + 1) + 50);
			
			int	red = (int)(Math.random() * 256);
			int	green = (int)(Math.random() * 256);
			int	blue = (int)(Math.random() * 256);
			c = new Color(red, green, blue);
			//	이제 그림이 하나 그려지므로...
			//	이 그림을 컬렉션에 보관해야 할것이다.
			//		정보는 5개를 한번에 저장해야 하므로.....
			//		VO 클래스가 필요할 것 같고...
			DrawInfo	info = new DrawInfo();
			info.x = x;
			info.y = y;
			info.width = w;
			info.height = h;
			info.color = c;
			
			main.list.add(info);
			
			repaint();
		}
	}
}



