package P0106;

import		GUI.*;
import		java.awt.*;
import		javax.swing.*;
public class Test01 {
	public Test01() {
		MyJFrame	f = new MyJFrame();
		//	�����̳ʿ� ��ġ������ Grid ������� �ϰ��� �Ѵ�.
		GridLayout	lay = new GridLayout(2, 3, 10, 10);
		//	2��, 3ĭ¥�� ���ڸ� ������
		//	(��� �� �����̳ʾȿ��� ��� 6������ �� �� �ִ�.)
		f.setLayout(lay);
		
		JButton	b1 = new JButton("1�� ����");
		JButton	b2 = new JButton("2�� ����");
		JButton	b3 = new JButton("3�� ����");
		JButton	b4 = new JButton("4�� ����");
		JButton	b5 = new JButton("5�� ����");
		JButton	b6 = new JButton("6�� ����");
		JButton	b7 = new JButton("7�� ����");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test01();
	}
}
