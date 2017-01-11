package P0111;
/*
 *		���� 2���� ����� ������ ���߸� ������
 *		�����, ���¿����� ���� ��ȭ���ڸ� ����ϵ��� ����.
 *
 * 		������ ������ �̸��� �˾Ƴ���.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import		java.io.*;
public class Test01 {
	MyJFrame	frame;
	JButton		openB, saveB;
	public Test01() {
		frame = new MyJFrame("���� ��ȭ����");
		frame.setLayout(new FlowLayout());
		
		openB = new JButton("�ҷ�����");
		saveB = new JButton("�����ϱ�");
		ButtonEvent	evt = new ButtonEvent();
		openB.addActionListener(evt);
		saveB.addActionListener(evt);
		
		frame.add(openB);
		frame.add(saveB);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Test01();
	}
	//	���� ����� �ؾ� �ϹǷ� �̺�Ʈ �Լ� �ȿ��� ó���ϸ� ����������.
	//	�׷��� �� ��ɸ� ó���ϴ� �Լ��� ���� ���� ����� �����̴�.
	void saveProc() {
		//	�� �κ��� �������� ó���� ������
	}
	void openProc() {
		//	����
		//		���� ��ȭ���� �����
		JFileChooser	c = new JFileChooser();
		//		��ȭ���ڸ� ȭ�鿡 �������.
		int kind = c.showOpenDialog(frame);
		//	�� ��ȭ������ ��ȯ���� �ǹ̴�
		//	�� ��ȭ���ڸ� �ݾ����� � ���߸� �̿��ؼ� �ݾҴ���
		//	������ ������ �˷��ִ� ��ȯ���̴�.
		//		����
		//		JFileChooser.CANCEL_OPTION		��� 
		//		JFileChooser.APPROVE_OPTION 	Ȯ��
		//		JFileChooser.ERROR_OPTION 		x����

		//		������ ������ ������ �˾Ƴ���.
		if(kind == JFileChooser.APPROVE_OPTION) {
			//	������ �ڵ�
			//	������ ������ ������ �̸��� �˷��ִ� ���� �ƴϰ�
			//	������ ������ Ŭ������ ��� �˷��ְ� �ȴ�.
			//		File
			File	file = c.getSelectedFile();
			String	fileName = file.getName();
			System.out.println("����� ������ ������ = " + fileName);
		}
		else {
			//	������ �ƹ��ϵ� ���� ���ƾ� �Ѵ�.
			System.out.println("������ ��� �Ǿ����ϴ�.");
		}
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//	1.	��� ���߿��� �̺�Ʈ�� �߻��ߴ����� �˾Ƴ���
			JButton	target = (JButton) e.getSource();
			//	2.	�� ���߸� �����ؼ� ����� �ҷ����� ��ȭ���ڸ�
			//		����Ѵ�.
			if(target == openB) {
				openProc();
			}
			//	�ǹ������� ������ ������ �� �� ������ �ϴ°���
			//	�ƴϴ�.
			else if(target == saveB) {
				saveProc();
			}
		}
	}
}












