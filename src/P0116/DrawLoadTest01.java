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
public class DrawLoadTest01 {
	ArrayList	list = new ArrayList();
	DrawCanvas02	can = null;
	public DrawLoadTest01() {
		MyJFrame	f = new MyJFrame();
		can = new DrawCanvas02(this);
		JButton		btn = new JButton("불러오기");
		btn.addActionListener(new ButtonEvent());
		f.add("Center", can);
		f.add("South", btn);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new DrawLoadTest01();
	}
	//	단추를 누르면 그림 정보를 통채로 저장하자.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	할일
			//		저장한다.
			FileInputStream	fout = null;
			ObjectInputStream	oout = null;
			try {
				fout = new FileInputStream("D:\\그림.txt");
				oout = new ObjectInputStream(fout);
				
				list = (ArrayList) oout.readObject();
				can.repaint();
			}
			catch(Exception e1) {
			}
		}
	}
}

class DrawCanvas02 extends Canvas {
	DrawLoadTest01	main;
	public DrawCanvas02(DrawLoadTest01 m) {
		main = m;
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		int	size = main.list.size();
		for(int i = 0; i < size; i++) {
			DrawInfo	info = (DrawInfo)main.list.get(i);
			g.setColor(info.color);
			g.drawRect(info.x, info.y, info.width, info.height);
		}
	}
}



