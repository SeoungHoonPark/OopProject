package P0111;
/*
 * 	����
 * 		3���� ī�带 �غ��ϰ� ������ ī�忡 ������ ������ �غ��Ѵ�.
 * 
 * 		���߸� ������ ���ϴ� ī��� ȭ�� ��ü�� �ǵ��� ����.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
public class Test05 {
	MyJFrame	f;
	JPanel		mainPanel;	//	JFrame��ü�� ���� Panel�̴�.
	CardLayout	card;
	public Test05() {
		f = new MyJFrame();
		mainPanel = new JPanel();
		//	ȭ�� ��ü�� �гη� ���踦 �Ѵ�.
		f.add(mainPanel);
		//	�������ʹ� Panel�� ������ �۾��Ѵ�.
		
		OneCard	one = new OneCard(this);
		TwoCard	two = new TwoCard(this);
		ThreeCard	three = new ThreeCard(this);
		//	���� �� �κ� ȭ���� �����̳ʿ� ������ �Ѵ�.
		
		card = new CardLayout();
		mainPanel.setLayout(card);
		
		//	�� �ȿ� ���徿 ī�带 �ִ´�.
		//	�ִ� ���
		//		add(����, "ī���̸�");
		mainPanel.add(one, "��ī��");
		mainPanel.add(two, "��ī��");
		mainPanel.add(three, "����ī��");
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}
}
//	�κ� ȭ��(������ ī�忡 �� ȭ��)�� ���� ���� ó���Ѵ�.
class OneCard extends JPanel {
	//	�� Ŭ������ �տ� Ŭ������ ��ȣ ������ �ϱ⸦ ���Ѵ�.
	Test05	main;
	public OneCard() {}
	public OneCard(Test05 m) {
		main = m;
		setBackground(Color.pink);
		JButton btn = new JButton("1�� ī�� ����");
		JComboBox	box = new JComboBox();
		box.addItem("���¿�");
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(box);
	}
	//	��ó�� ������ �κ� ȭ���� ���� ����� ��������
	//	�� ȭ�鿡�� �ʿ��� �̺�Ʈ ���� ���� ���� �� �ִ�...
	//	��� ������ �ִ�.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	���� 1�� ȭ���ε� 2�� ȭ������ ��ü�� ����
			//	1.	2�� ȭ���� 1�� ȭ�� ���� ȭ���̹Ƿ�....
			//		next();
			//	2.	������ �� �𸣸�....
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
		JButton btn = new JButton("2�� ī�� ����");
		JCheckBox	box = new JCheckBox("2�� ī�� üũ");
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(box);
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	3��
			//		1.	3�� ī��� 2�� ī�� �����̹Ƿ�...
			//		next
			//		2.	������ �𸣸� show
			main.card.show(main.mainPanel, "����ī��");
		}
	}
}
class ThreeCard extends JPanel {
	Test05	main;
	public ThreeCard() {}
	public ThreeCard(Test05 m) {
		main = m;
		setBackground(Color.gray);
		JButton btn = new JButton("3�� ī�� ����");
		JRadioButton	r = new JRadioButton("3�� ȭ�鿡 ����");
		
		btn.addActionListener(new ButtonEvent());
		add(btn);
		add(r);
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	1��
			//		1	3������ 1���� ����ī�尡 �ȴ�.	next
			//			(ī��� �����̼ǵȴ�)	
			//		2	1�� ī��� ù��° ī���̴�		first
			//		3	������ �𸣸�					show
			main.card.first(main.mainPanel);
		}
	}
}
