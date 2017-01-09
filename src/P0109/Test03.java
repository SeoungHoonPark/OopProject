package P0109;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import GUI.MyJFrame;

/**
 * 	위쪽과 아래쪽에 텍스트필드를 두개 만들고
 * 	위쪽에서 내용을 입력한 후 엔터키를 치면 그 내용이 
 * 	그대로 아래족에 나타나도록 하자.
 */
public class Test03{
	JTextField upF, downF;
	
	public Test03() {
		MyJFrame f = new MyJFrame();
		
		upF = new JTextField();
		downF = new JTextField();
		
		// 팁
		// GUI에서 글꼴 바꾸는 방법
		// 모든 글자를 쓰는 부분(단추, 콤보상자, 목록상자...)
		// 방법
		// font클래스를 new시킨다.
		// setFont()로 등록한다.
		Font font = new Font("휴먼엑스포", Font.PLAIN, 20);
		
		upF.setFont(font);
		
		f.add(upF, BorderLayout.NORTH);
		f.add(downF, BorderLayout.SOUTH);
		
		f.setSize(400,400);
		f.setVisible(true);
		
		upF.addActionListener(new TextEvent());
	}

	public static void main(String[] args) {
		new Test03();
	}

	class TextEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// 할일
			// 위쪽에 내용릉 알아낸다. 
			// 그 내용을 그대로 아래쪽에 입력한다.
			String text = upF.getText();
			downF.setText(text);						
		}		
	}
	
	
}
