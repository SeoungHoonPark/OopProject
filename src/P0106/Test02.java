package P0106;
import		GUI.*;
import		java.awt.*;
import		javax.swing.*;
public class Test02 extends MyJFrame {

	public Test02() {
		//	�̹� �� Ŭ������ �����̳��� ��Ȱ�� �Ѵ�.
		BorderLayout	lay = new BorderLayout();
		this.setLayout(lay);
		
		JButton	b1 = new JButton("�ϴ��� �췯��");
		JButton	b2 = new JButton("���� �β����� ���⸦");
		JButton	b3 = new JButton("�Ի��� �̴� �ٶ�����");
		JButton	b4 = new JButton("���� ���ο��ߴ�.");
		JButton	b5 = new JButton("�׾�� ������ ����ؾ���");
	
		this.add("West", b1);
		this.add(BorderLayout.EAST, b2);
		this.add(b3, "North");
		this.add(b4, BorderLayout.SOUTH);
		this.add(b5);	//	�̷��� Center�� ����.
		
		setSize(600, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test02();
	}
}

