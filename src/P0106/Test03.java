package P0106;
import	GUI.*;
import	java.awt.*;
import	javax.swing.*;
public class Test03 {
	public Test03() {
		MyJFrame	f = new MyJFrame();
		//	이것은 기본적으로 Border가 배치전략이 된다.
		//	만약 이것을 무시하고자 하면.....
		f.setLayout(null);
		//	이후부터는 모든 컴포넌트의 크기와 위치를 정확하게
		//	지정해서 입력해야 한다.
		//	이때 사용하는 명령어		setBounds
		JButton	b1 = new JButton("1번단추");
		b1.setBounds(10, 10, 100, 100);
		JButton	b2 = new JButton("2번단추");
		b2.setBounds(110, 110, 150, 150);
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Test03();
	}
}
