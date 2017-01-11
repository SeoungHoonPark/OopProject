package P0111;
/*
 * 	문제
 * 		3장의 카드를 준비하고 각각의 카드에 적당한 도구를 준비한다.
 * 
 * 		단추를 누르면 원하는 카드로 화면 교체가 되도록 하자.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
public class Test05 {
	MyJFrame	f;
	JPanel		mainPanel;	//	JFrame전체를 덮은 Panel이다.
	CardLayout	card;
	public Test05() {
		f = new MyJFrame();
		mainPanel = new JPanel();
		//	화면 전체를 패널로 도배를 한다.
		f.add(mainPanel);
		//	이제부터는 Panel에 모든것을 작업한다.
		
		OneCard	one = new OneCard(this);
		TwoCard	two = new TwoCard(this);
		ThreeCard	three = new ThreeCard(this);
		//	이제 이 부분 화면을 컨테이너에 조립을 한다.
		
		card = new CardLayout();
		mainPanel.setLayout(card);
		
		//	이 안에 한장씩 카드를 넣는다.
		//	넣는 방법
		//		add(도구, "카드이름");
		mainPanel.add(one, "원카드");
		mainPanel.add(two, "투카드");
		mainPanel.add(three, "쓰리카드");
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}
}
//	부분 화면(각각의 카드에 들어갈 화면)을 따로 만들어서 처리한다.
class OneCard extends JPanel {
	//	이 클래스는 앞에 클래스와 상호 참조를 하기를 원한다.
	Test05	main;
	public OneCard() {}
	public OneCard(Test05 m) {
		main = m;
		setBackground(Color.pink);
		JButton btn = new JButton("1번 카드 단추");
		JComboBox	box = new JComboBox();
		box.addItem("김태연");
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(box);
	}
	//	이처럼 각각의 부분 화면을 따로 만들면 좋은점이
	//	그 화면에서 필요한 이벤트 역시 따로 만들 수 있다...
	//	라는 장점이 있다.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	현재 1번 화면인데 2번 화면으로 교체를 하자
			//	1.	2번 화면은 1번 화면 다음 화면이므로....
			//		next();
			//	2.	순서를 잘 모르면....
			//		show();
			main.card.next(main.mainPanel);
		}
	}
}
class TwoCard extends JPanel {
	Test05	main;
	public TwoCard() {}
	public TwoCard(Test05 m) {
		main = m;
		setBackground(Color.cyan);
		JButton btn = new JButton("2번 카드 단추");
		JCheckBox	box = new JCheckBox("2번 카드 체크");
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(box);
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	3번
			//		1.	3번 카드는 2번 카드 다음이므로...
			//		next
			//		2.	순서를 모르면 show
			main.card.show(main.mainPanel, "쓰리카드");
		}
	}
}
class ThreeCard extends JPanel {
	Test05	main;
	public ThreeCard() {}
	public ThreeCard(Test05 m) {
		main = m;
		setBackground(Color.gray);
		JButton btn = new JButton("3번 카드 단추");
		JRadioButton	r = new JRadioButton("3번 화면에 라디오");
		
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(r);
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	1번
			//		1	3번에서 1번은 다음카드가 된다.	next
			//			(카드는 로테이션된다)	
			//		2	1번 카드는 첫번째 카드이다		first
			//		3	순서를 모르면					show
			main.card.first(main.mainPanel);
		}
	}
}
