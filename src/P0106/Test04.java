package P0106;

import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
public class Test04 {
	public Test04() {
		MyJFrame	f = new MyJFrame();
		f.setLayout(new BorderLayout());	//	���� ����
		
		JButton	b1 = new JButton(" Ȯ�� ");
		JButton	b2 = new JButton(" ��� ");
		//	���� ���� 2���� �����ؾ߰ڴ�.
		//	��ó�� ������Ʈ�� �����ϴ� ����� ���� �����̳ʰ�
		//	�ٷ� Panel �̴�.
		JPanel	p = new JPanel();
		p.setBackground(Color.red);
		p.setLayout(new FlowLayout());		//	���� ����
		p.add(b1);
		p.add(b2);
		
		f.add(p, "South");
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test04();
	}
}




