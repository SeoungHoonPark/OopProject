package P0109;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import GUI.MyJFrame;

/**
 * 	���ʰ� �Ʒ��ʿ� �ؽ�Ʈ�ʵ带 �ΰ� �����
 * 	���ʿ��� ������ �Է��� �� ����Ű�� ġ�� �� ������ 
 * 	�״�� �Ʒ����� ��Ÿ������ ����.
 */
public class Test03{
	JTextField upF, downF;
	
	public Test03() {
		MyJFrame f = new MyJFrame();
		
		upF = new JTextField();
		downF = new JTextField();
		
		// ��
		// GUI���� �۲� �ٲٴ� ���
		// ��� ���ڸ� ���� �κ�(����, �޺�����, ��ϻ���...)
		// ���
		// fontŬ������ new��Ų��.
		// setFont()�� ����Ѵ�.
		Font font = new Font("�޸տ�����", Font.PLAIN, 20);
		
		upF.setFont(font);
		
		f.add(upF, BorderLayout.NORTH);
		f.add(downF, BorderLayout.SOUTH);
		
		f.setSize(400,400);
		f.setVisible(true);
		
		upF.addActionListener(new TextEvent());
	}

	public static void main(String[] args) {
		new Test03();
	}

	class TextEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// ����
			// ���ʿ� ���븪 �˾Ƴ���. 
			// �� ������ �״�� �Ʒ��ʿ� �Է��Ѵ�.
			String text = upF.getText();
			downF.setText(text);						
		}		
	}
	
	
}
