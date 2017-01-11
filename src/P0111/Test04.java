package P0111;
/*
 * 	탭을 3개가진 화면을 만들고 그 안에 뭔가를 만들어보자.
 */
import		GUI.*;
import		javax.swing.*;
import		javax.swing.event.*;
import		java.awt.*;
public class Test04 {
	public Test04() {
		MyJFrame	f = new MyJFrame();
		
		FirstPanel	p1 = new FirstPanel();
		SecondPanel	p2 = new SecondPanel();
		ThirdPanel	p3 = new ThirdPanel();
		FirstPanel	p4 = new FirstPanel();
		SecondPanel	p5 = new SecondPanel();
		ThirdPanel	p6 = new ThirdPanel();
		FirstPanel	p7 = new FirstPanel();
		SecondPanel	p8 = new SecondPanel();
		ThirdPanel	p9 = new ThirdPanel();
		
//		f.add("North", p1);
//		f.add("South", p2);
//		f.add("Center", p3);
		
		JTabbedPane	tab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.add(p1, "1번탭");
		tab.add(p2, "2번탭");
		tab.add(p3, "3번탭");
		tab.add(p4, "4번탭");
		tab.add(p5, "5번탭");
		tab.add(p6, "6번탭");
		tab.add(p7, "7번탭");
		tab.add(p8, "8번탭");
		tab.add(p9, "9번탭");
		tab.addChangeListener(new TabEvent());
		f.add(tab);
		
		f.setSize(400, 400);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Test04();
	}
	class TabEvent implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			System.out.println("탭이 바꿨어요");
		}
	}
}

//	우리가 복잡한 화면을 만들다보면.....
//	많은 수의 도구를 만들 필요가 있고....
//	패널을 이용해서 포장한 후 사용해야 하는 경우가 많이 존재한다.
//	실무에서는 주로
//		각각의 부분적인 폼을 따로 클래스를 만든 후
//		이것을 사용해서 처리하는 방법을 사용한다.
//	장점
//		각각의 화면이 다른 클래스로 만들어져 있으므로....
//		수정이 필요하면 해당 화면을 담당하는 클래스만 수정하면 될것이다.
//	우리는 3개의 탭에 들어갈 화면을 따로 만든 후
//	이것을 합치는 방법으로 해결할 예정이다.
class FirstPanel extends JPanel {
	//	이 클래스는 다른 곳에 도구를 포장해서 들어갈 화면이므로...
	//	JPanel을 상속받으면 이 클래스 자체가 패널이 될 것이므로
	//	얼마든지 다른 컨테이너에 들어갈 수있을 것이다.
	public FirstPanel() {
		//	이 안에서 하나의 부분적인 폼만 만들면
		//	될것이다.
		//	나는 이곳에 단추 두개를 가진 폼을 만들예정이다.
		JButton	b1 = new JButton("단추1");
		JButton	b2 = new JButton("단추2");
		
		this.add(b1);
		this.add(b2);
	}
}

class SecondPanel extends JPanel {
	public SecondPanel() {
		//	나는 이곳에 라디오 단추 2개를 만들어 놓자
		JRadioButton	b1 = new JRadioButton("라디오1");
		JRadioButton	b2 = new JRadioButton("라디오2");
		ButtonGroup g = new ButtonGroup();
		g.add(b1);
		g.add(b2);
		
		this.add(b1);
		this.add(b2);
	}
}

class ThirdPanel extends JPanel {
	public ThirdPanel() {
		//	나는 이곳에 텍스트 필드를 2개 만들어 놓자
		this.setLayout(new BorderLayout());
		JTextField	f1 = new JTextField();
		JTextField	f2 = new JTextField();
		
		this.add("North", f1);
		this.add("South", f2);
	}
}









