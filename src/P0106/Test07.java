package P0106;

import	java.awt.event.*;
import 	java.awt.*;
import 	javax.swing.*;
import 	GUI.*;

public class Test07 {
	MyJFrame	f;
	JButton		b1, b2;
	public Test07() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		b1 = new JButton("��ũ�� ����");
		b2 = new JButton("�ϴû� ����");
		
		ButtonEvent	evt = new ButtonEvent();
		b1.addActionListener(evt);
		b2.addActionListener(evt);
		
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test07();
	}
	//	�̺�Ʈ Ŭ������ �ϳ��� �����.
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	�̺�Ʈ�� �߻��ϸ� �ü���� �ν��� �� ��
			//	�װ��� JVM���� �˷��ش�.
			//	JVM�� �̺�Ʈ�� ������ �м��� �� �ش� �Լ��� 
			//	�����Ų��.
			//	�̶� �� �Լ��� JVM�� �߻��� �̺�Ʈ ������ �˷��ְ� �ȴ�.
			//	����	Ŭ������ ����...
			//		ActionEvent e	�� JVM �� �˷��ִ�
			//		�̺�Ʈ ������ ���� �Ű������̴�.
			//	�츮�� �� ���� Ŭ������ �̿��ؼ� �ʿ��� ������
			//	�� �ʿ��� ��ġ�� �ϸ� �ȴ�.
			//	����
			//		��� ���߿��� �̺�Ʈ�� �߻��ߴ��� �˾ƾ� �Ѵ�.
			//	�̶� ����ϴ� �Լ�		getSource()
			//	�� �Լ��� �̺�Ʈ�� �߻��� ��ü(����)�� �ּҸ�
			//	�˾Ƴ��� �Լ�
			JButton	target = (JButton) e.getSource();
			if(target == b1) {
				f.getContentPane().setBackground(Color.pink);
			}
			else if(target == b2) {
				f.getContentPane().setBackground(Color.cyan);
			}
		}
	}
}


