package P0111;
/*
 * 		파일			편집
		새문서			색상	빨강
		저장하기				초록
		불러오기				파랑
		-------			글꼴	크게
		종료하기				작게

 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
public class Test03 {
	public Test03() {
		MyJFrame	f = new MyJFrame();
		//	메뉴는 배치전략과는 관계가 없다.
		JMenuItem newM = new JMenuItem("새문서");
		JMenuItem openM = new JMenuItem("불러오기");
		JMenuItem saveM = new JMenuItem("저장하기");
		JMenuItem exitM = new JMenuItem("종료하기");
		//	나는 종료하기 메뉴에 x 키를 단축키로 등록하고자 한다.
		//	1.	KeyStroke	를 이용해서 사용할 단축키를 만든다.
		//		x 키를 단추키로 등록
//		KeyStroke	stroke = KeyStroke.getKeyStroke('x');
		//		 Ctrl + x 키를 단축키로 등록
//		KeyStroke	stroke = 
//		KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
		//		 Ctrl + Alt + x 키를 단축키로 등록
		KeyStroke	stroke = 
		KeyStroke.getKeyStroke(KeyEvent.VK_X, 
				ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK);
		//	2.	setAccelerator()를 이용해서 단축키를 등록한다.
		exitM.setAccelerator(stroke);
		
		JMenuItem redM = new JMenuItem("빨간색");
		JMenuItem greenM = new JMenuItem("초록색");
		JMenuItem blueM = new JMenuItem("파란색");
		JMenuItem largeM = new JMenuItem("크게");
		JMenuItem smallM = new JMenuItem("작게");
		
		MenuEvent	evt = new MenuEvent();
		exitM.addActionListener(evt);
		
		
		JMenu	fileM = new JMenu("파일");
		JMenu	editM = new JMenu("편집");
		JMenu	colorM = new JMenu("색상");
		JMenu	fontM = new JMenu("글꼴");
		
		fileM.add(newM);
		fileM.add(saveM);
		fileM.add(openM);
		fileM.addSeparator();
		fileM.add(exitM);
		editM.add(colorM);
		editM.add(fontM);
		colorM.add(redM);
		colorM.add(greenM);
		colorM.add(blueM);
		fontM.add(largeM);
		fontM.add(smallM);
		
		JMenuBar	bar = new JMenuBar();
		bar.add(fileM);
		bar.add(editM);
		
		f.setJMenuBar(bar);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test03();
	}
	
	class MenuEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	할일
			//		어느메뉴에서 이벤트가 발생했는지 알아내고
//			JMenuItem	target = (JMenuItem) e.getSource();
			//		구분해서 처리하자.
//			if(target == ????) {
			System.exit(0);
//			}
		}
	}
}





