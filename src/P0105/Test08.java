/**
 * 
 */
package P0105;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *		단추를 하나 만들고 그 단추를 클릭하면 5단 구구단을 출력하도록 하자.
 *		가장 먼저 사용자 화면을 일단 만들어야 한다.
 *		화면이 완성되면 그 다음에 이벤트 기능을 처리한다.
 */
public class Test08 {

	public Test08() {
		MyJFrame f = new MyJFrame("구구단");
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		f.setLayout(layout);
		
		JButton b = new JButton();
		f.add(b);
		f.setSize(400,400);
		f.setVisible(true);
		//나는 이 단추에 이벤트를 감시해 달라고 등록하고 싶다.
		// 1. 이벤트 클래스를 만든다.
		ButtonEvent08 evt = new ButtonEvent08();
		b.addActionListener(evt);
		
		//b.addActionListener(new ButtonEvent08());
		
		
	}

	public static void main(String[] args) {
		new Test08();
	}
}

class ButtonEvent08 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int dan = 5;
		for(int i = 1; i <10; i++){
			int temp = dan * i;
			System.out.println(dan + " * " + i + " = " + temp);
		}
	}
	// 참고 만약 선택한 경청자 안에 함수가 여러개 있으면
	// 모든 함수를 오버라이드 해놓아야 한다.
}