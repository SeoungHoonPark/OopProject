package P0106;
import	GUI.*;
import	java.awt.*;
import	javax.swing.*;
public class Test03 {
	public Test03() {
		MyJFrame	f = new MyJFrame();
		//	�̰��� �⺻������ Border�� ��ġ������ �ȴ�.
		//	���� �̰��� �����ϰ��� �ϸ�.....
		f.setLayout(null);
		//	���ĺ��ʹ� ��� ������Ʈ�� ũ��� ��ġ�� ��Ȯ�ϰ�
		//	�����ؼ� �Է��ؾ� �Ѵ�.
		//	�̶� ����ϴ� ��ɾ�		setBounds
		JButton	b1 = new JButton("1������");
		b1.setBounds(10, 10, 100, 100);
		JButton	b2 = new JButton("2������");
		b2.setBounds(110, 110, 150, 150);
		f.add(b1);
		f.add(b2);
		
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Test03();
	}
}
