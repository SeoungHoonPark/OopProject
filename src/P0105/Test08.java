/**
 * 
 */
package P0105;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *		���߸� �ϳ� ����� �� ���߸� Ŭ���ϸ� 5�� �������� ����ϵ��� ����.
 *		���� ���� ����� ȭ���� �ϴ� ������ �Ѵ�.
 *		ȭ���� �ϼ��Ǹ� �� ������ �̺�Ʈ ����� ó���Ѵ�.
 */
public class Test08 {

	public Test08() {
		MyJFrame f = new MyJFrame("������");
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		f.setLayout(layout);
		
		JButton b = new JButton();
		f.add(b);
		f.setSize(400,400);
		f.setVisible(true);
		//���� �� ���߿� �̺�Ʈ�� ������ �޶�� ����ϰ� �ʹ�.
		// 1. �̺�Ʈ Ŭ������ �����.
		ButtonEvent08 evt = new ButtonEvent08();
		b.addActionListener(evt);
		
		//b.addActionListener(new ButtonEvent08());
		
		
	}

	public static void main(String[] args) {
		new Test08();
	}
}

class ButtonEvent08 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int dan = 5;
		for(int i = 1; i <10; i++){
			int temp = dan * i;
			System.out.println(dan + " * " + i + " = " + temp);
		}
	}
	// ���� ���� ������ ��û�� �ȿ� �Լ��� ������ ������
	// ��� �Լ��� �������̵� �س��ƾ� �Ѵ�.
}