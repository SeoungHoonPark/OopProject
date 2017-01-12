package P0112;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import GUI.MyJFrame;

/**
 * 화면에 회사 로고라고 생각하는 이미지를 출력해 보자.
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

// 나만의 도구를 만들기 위해서 Canvas를 이용한 도구를 준비한다.
class logoImage extends Canvas {
	
	Image img;
	
	public logoImage() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		img = kit.getImage("src/P0112/img.jpg");
	}
	
	@Override
	public void paint(Graphics g) {
		// 참고
		// Graphics 클래스는 그림을 그리기 위한 도구를 제공하는 기능을 가진 클래스이다.
		// 물론 이 함수를 jvm이 호출할 때 자동으로 줌으로 그냥 사용하면 된다.
		g.drawImage(img, 10, 10, this);
	}
}
