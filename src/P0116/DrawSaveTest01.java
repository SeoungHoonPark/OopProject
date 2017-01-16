package P0116;
/*
 * 	�����ϰ� �׸��� �׸��ٰ� �����ϴ� ����� ���� Ŭ������ �����.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import		java.io.*;
//	�׸��� ������ ������ �ʿ��ϴ�.	�簢���� � �׷����� �𸥴�.
//	�� ������ ����ϱ� ���ؼ� �÷����� �غ�����.
import		java.util.*;
public class DrawSaveTest01 {
	ArrayList	list = new ArrayList();
	public DrawSaveTest01() {
		MyJFrame	f = new MyJFrame();
		DrawCanvas01	can = new DrawCanvas01(this);
		JButton		btn = new JButton("�����ϱ�");
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
	//	���߸� ������ �׸� ������ ��ä�� ��������.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//		�����Ѵ�.
			FileOutputStream	fout = null;
			ObjectOutputStream	oout = null;
			try {
				fout = new FileOutputStream("D:\\�׸�.txt");
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
			//	���� �׸��� �ϳ� �׷����Ƿ�...
			//	�� �׸��� �÷��ǿ� �����ؾ� �Ұ��̴�.
			//		������ 5���� �ѹ��� �����ؾ� �ϹǷ�.....
			//		VO Ŭ������ �ʿ��� �� ����...
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



