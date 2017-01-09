package P0106;
/*
 * 	����
 * 		���� �ΰ��� ����� 	ù��° ���߸� Ŭ���ϸ� ���������� ĥ�ϰ�
 * 							ù��° ���߸� Ŭ���ϸ� �Ķ������� ĥ�ϼ���
 */
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
public class Test06 {
	MyJFrame	f;
	public Test06() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		JButton	b1 = new JButton("������ ����");
		JButton	b2 = new JButton("�Ķ��� ����");
		b1.addActionListener(new RedButtonEvent());
		b2.addActionListener(new BlueButtonEvent());
		
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test06();
	}
	//	���߸� Ŭ���ϴ� �̺�Ʈ�� �����ϴ� ��û��
	//	ActionListener �̴�.
	//	�����Լ�
	//	actionPerformed()
	class RedButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			f.getContentPane().setBackground(Color.red);
		}
	}
	class BlueButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			f.getContentPane().setBackground(Color.blue);
		}
	}
}




