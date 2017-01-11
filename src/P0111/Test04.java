package P0111;
/*
 * 	���� 3������ ȭ���� ����� �� �ȿ� ������ ������.
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
		tab.add(p1, "1����");
		tab.add(p2, "2����");
		tab.add(p3, "3����");
		tab.add(p4, "4����");
		tab.add(p5, "5����");
		tab.add(p6, "6����");
		tab.add(p7, "7����");
		tab.add(p8, "8����");
		tab.add(p9, "9����");
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
			System.out.println("���� �ٲ���");
		}
	}
}

//	�츮�� ������ ȭ���� ����ٺ���.....
//	���� ���� ������ ���� �ʿ䰡 �ְ�....
//	�г��� �̿��ؼ� ������ �� ����ؾ� �ϴ� ��찡 ���� �����Ѵ�.
//	�ǹ������� �ַ�
//		������ �κ����� ���� ���� Ŭ������ ���� ��
//		�̰��� ����ؼ� ó���ϴ� ����� ����Ѵ�.
//	����
//		������ ȭ���� �ٸ� Ŭ������ ������� �����Ƿ�....
//		������ �ʿ��ϸ� �ش� ȭ���� ����ϴ� Ŭ������ �����ϸ� �ɰ��̴�.
//	�츮�� 3���� �ǿ� �� ȭ���� ���� ���� ��
//	�̰��� ��ġ�� ������� �ذ��� �����̴�.
class FirstPanel extends JPanel {
	//	�� Ŭ������ �ٸ� ���� ������ �����ؼ� �� ȭ���̹Ƿ�...
	//	JPanel�� ��ӹ����� �� Ŭ���� ��ü�� �г��� �� ���̹Ƿ�
	//	�󸶵��� �ٸ� �����̳ʿ� �� ������ ���̴�.
	public FirstPanel() {
		//	�� �ȿ��� �ϳ��� �κ����� ���� �����
		//	�ɰ��̴�.
		//	���� �̰��� ���� �ΰ��� ���� ���� ���鿹���̴�.
		JButton	b1 = new JButton("����1");
		JButton	b2 = new JButton("����2");
		
		this.add(b1);
		this.add(b2);
	}
}

class SecondPanel extends JPanel {
	public SecondPanel() {
		//	���� �̰��� ���� ���� 2���� ����� ����
		JRadioButton	b1 = new JRadioButton("����1");
		JRadioButton	b2 = new JRadioButton("����2");
		ButtonGroup g = new ButtonGroup();
		g.add(b1);
		g.add(b2);
		
		this.add(b1);
		this.add(b2);
	}
}

class ThirdPanel extends JPanel {
	public ThirdPanel() {
		//	���� �̰��� �ؽ�Ʈ �ʵ带 2�� ����� ����
		this.setLayout(new BorderLayout());
		JTextField	f1 = new JTextField();
		JTextField	f2 = new JTextField();
		
		this.add("North", f1);
		this.add("South", f2);
	}
}









