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
public class DrawLoadTest01 {
	ArrayList	list = new ArrayList();
	DrawCanvas02	can = null;
	public DrawLoadTest01() {
		MyJFrame	f = new MyJFrame();
		can = new DrawCanvas02(this);
		JButton		btn = new JButton("�ҷ�����");
		btn.addActionListener(new ButtonEvent());
		f.add("Center", can);
		f.add("South", btn);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new DrawLoadTest01();
	}
	//	���߸� ������ �׸� ������ ��ä�� ��������.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//		�����Ѵ�.
			FileInputStream	fout = null;
			ObjectInputStream	oout = null;
			try {
				fout = new FileInputStream("D:\\�׸�.txt");
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



