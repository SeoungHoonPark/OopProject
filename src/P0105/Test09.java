/**
 * 
 */
package P0105;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *	단추를 클릭하면 화면의 색상을 랜덤하게 변화시키는 프로그램을 만들어보자
 */
public class Test09 {
	MyJFrame f;	// 이 변수를 생성자 함수가 아닌 다른 곳에서 
						//	사용할 필요가 있으면 전역변수로 선언한다.
	public Test09() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//언제는 new만 시키면 되고, 언제는 변수에 기억해야 하나요?
		// 재 사용하려면 변수에 기억하고, 한번만 사용하면 new 시킨다.
		
		JButton btn = new JButton("눌러요");
		f.add(btn);
		f.setSize(400,400);
		f.setVisible(true);
		btn.addActionListener(new ButtonEvent09());		
	}

	public static void main(String[] args) {
		new Test09();
	}
	// 단추를 눌렀을때 필요한 클래스를 만든다.
	class ButtonEvent09 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// 이제 이 안에서 단추가 눌려졌을때 해야할 행동을 만든다.
			// 할일은 frame의 색상을 변경하는 일인데, 
			// 이 클래스와 앞에 클래스느 다른 파일에 만드는 것이 원칙이므로
			// 독립적인 클래스이므로 이 함수 안에서는 frame을 알 수 없다.
			// 방법
			// 1. 어제 배운 상호 참조 기술을 사용한다.
			// 2. inner클래스를 통해서 사용한다.
			
			// 이제 이 클래스는 바깥 클래스의 frame을 사용할 수 있다
			
			// 팁
			// 색상 정하는 방법
			// 1. color클래스가 가진 16가지 색상을 그대로 사용한다.
			// 		예) Color.red;
			// 2. 개발자가 만들어서 사용할 수도 있다.
			// 		 new Color(red, green, blue);
			// 		예) new Color(255,0,0); ->	빨간색
			
			int red = (int)(Math.random() * (255 - 0 +1) + 0);
			int green = (int)(Math.random() * (255 - 0 +1) + 0);
			int blue = (int)(Math.random() * (255 - 0 +1) + 0);
			
			Color color = new Color(red,green, blue);
			// AWT와 스윙의 차이
			// AWT는 직접 색상을 바꾸면 된다.
			//		Frame f = new Frame();
			// 		f.setBackground(color);
			// 스윙은 직접 색상을 바꾸지 못한다.
			// 왜냐하면 스윙은 두겹으로 만들어져 있고, 앞으로는 투명한 보호막이 있기 때문이다.
			// 결론적으로 뒤에 것에 색상을 칠해줘어야 한다.
			
			Container temp = f.getContentPane();
			// 먼저 뒤쪽의 숨겨진 frame을 꺼낸 후
			temp.setBackground(color);
			//f.setBackground(color);
		}
	}
}

