package P0105;

import java.awt.FlowLayout;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *
 */
public class Test07 {
	public Test07() {
		MyJFrame f = new MyJFrame();
		// ��ó�� �������� ������ ��� ��쿡�� ��ġ������ �����ؾ� �Ѵ�.
		// 1. �ʿ��� ��ġ������ �����.
		FlowLayout layout = new FlowLayout();
		
		// 2. �����̳ʿ� setLayout()�� �̿��ؼ� ��ġ������ ����Ѵ�.
		f.setLayout(layout);
		JButton b1 = new JButton("1������");
		JButton b2 = new JButton("2������");
		JButton b3 = new JButton("3������");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
		f.setSize(500,500);
		f.setVisible(true);
	}

	public static void main(String[] args) {	
		new Test07();
	}
}
