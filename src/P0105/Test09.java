/**
 * 
 */
package P0105;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyJFrame;

/**
 *	���߸� Ŭ���ϸ� ȭ���� ������ �����ϰ� ��ȭ��Ű�� ���α׷��� ������
 */
public class Test09 {
	MyJFrame f;	// �� ������ ������ �Լ��� �ƴ� �ٸ� ������ 
						//	����� �ʿ䰡 ������ ���������� �����Ѵ�.
	public Test09() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//������ new�� ��Ű�� �ǰ�, ������ ������ ����ؾ� �ϳ���?
		// �� ����Ϸ��� ������ ����ϰ�, �ѹ��� ����ϸ� new ��Ų��.
		
		JButton btn = new JButton("������");
		f.add(btn);
		f.setSize(400,400);
		f.setVisible(true);
		btn.addActionListener(new ButtonEvent09());		
	}

	public static void main(String[] args) {
		new Test09();
	}
	// ���߸� �������� �ʿ��� Ŭ������ �����.
	class ButtonEvent09 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// ���� �� �ȿ��� ���߰� ���������� �ؾ��� �ൿ�� �����.
			// ������ frame�� ������ �����ϴ� ���ε�, 
			// �� Ŭ������ �տ� Ŭ������ �ٸ� ���Ͽ� ����� ���� ��Ģ�̹Ƿ�
			// �������� Ŭ�����̹Ƿ� �� �Լ� �ȿ����� frame�� �� �� ����.
			// ���
			// 1. ���� ��� ��ȣ ���� ����� ����Ѵ�.
			// 2. innerŬ������ ���ؼ� ����Ѵ�.
			
			// ���� �� Ŭ������ �ٱ� Ŭ������ frame�� ����� �� �ִ�
			
			// ��
			// ���� ���ϴ� ���
			// 1. colorŬ������ ���� 16���� ������ �״�� ����Ѵ�.
			// 		��) Color.red;
			// 2. �����ڰ� ���� ����� ���� �ִ�.
			// 		 new Color(red, green, blue);
			// 		��) new Color(255,0,0); ->	������
			
			int red = (int)(Math.random() * (255 - 0 +1) + 0);
			int green = (int)(Math.random() * (255 - 0 +1) + 0);
			int blue = (int)(Math.random() * (255 - 0 +1) + 0);
			
			Color color = new Color(red,green, blue);
			// AWT�� ������ ����
			// AWT�� ���� ������ �ٲٸ� �ȴ�.
			//		Frame f = new Frame();
			// 		f.setBackground(color);
			// ������ ���� ������ �ٲ��� ���Ѵ�.
			// �ֳ��ϸ� ������ �ΰ����� ������� �ְ�, �����δ� ������ ��ȣ���� �ֱ� �����̴�.
			// ��������� �ڿ� �Ϳ� ������ ĥ������ �Ѵ�.
			
			Container temp = f.getContentPane();
			// ���� ������ ������ frame�� ���� ��
			temp.setBackground(color);
			//f.setBackground(color);
		}
	}
}

