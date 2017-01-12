package P0112;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import GUI.MyJFrame;

/**
 * ȭ�鿡 ȸ�� �ΰ��� �����ϴ� �̹����� ����� ����.
 */
public class Test01 {
	Canvas c = new Canvas();
	MyJFrame f = new MyJFrame();
	
	public Test01() {
		logoImage logo = new logoImage();
		f.add(logo);
		
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test01();
	}
}

// ������ ������ ����� ���ؼ� Canvas�� �̿��� ������ �غ��Ѵ�.
class logoImage extends Canvas {
	
	Image img;
	
	public logoImage() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		img = kit.getImage("src/P0112/img.jpg");
	}
	
	@Override
	public void paint(Graphics g) {
		// ����
		// Graphics Ŭ������ �׸��� �׸��� ���� ������ �����ϴ� ����� ���� Ŭ�����̴�.
		// ���� �� �Լ��� jvm�� ȣ���� �� �ڵ����� ������ �׳� ����ϸ� �ȴ�.
		g.drawImage(img, 10, 10, this);
	}
}
