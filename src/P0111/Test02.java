package P0111;
/*
 * 	���߸� ������ ���� ���� ��ȭ���ڸ� �����ְ�
 * 	������ �������� ȭ���� ĥ�ϼ���
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
//	�� Ŭ������ ���߸� �ϳ����� �̺�Ʈ�� ����� �����̴�.
//	�̺�Ʈ Ŭ������ ���� ���� ����ߴµ�......
//	�� Ŭ���� ��ü�� �̺�Ʈ Ŭ������ ���� ����� ���� �ִ�.
public class Test02 extends MyJFrame implements ActionListener {
	public Test02() {
		setLayout(new FlowLayout());
		JButton	btn = new JButton("���� ����");
		btn.addActionListener(this);
		add(btn);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test02();
	}
	
	//	���ڽ��� �̺�Ʈ Ŭ������ �Ǿ����Ƿ� �̰��� actionPerfomed()��
	//	����� �ָ� �ȴ�.
	public void actionPerformed(ActionEvent e) {
		//	����
		//		���� ��ȭ���ڸ� ����Ѵ�.
		Color	color = JColorChooser.showDialog(
				this, "���� ����", Color.WHITE);
		//		������ �������� ȭ���� ĥ�Ѵ�.
		if(color != null) {
			getContentPane().setBackground(color);
		}
	}
}


