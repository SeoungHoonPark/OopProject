package P0109;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import GUI.MyJFrame;

/*
 * 	���� ���� 3���� �����
 * 	������ �������� ���� ĥ�ϼ���.
 */
public class Test06 {
	JRadioButton redB, greenB, blueB;
	MyJFrame f;
	
	public Test06() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		redB = new JRadioButton("������");
		greenB = new JRadioButton("�ʷϻ�");
		blueB = new JRadioButton("�Ķ���");
		
		ButtonGroup g = new ButtonGroup();
		g.add(redB);
		g.add(greenB);
		g.add(blueB);
		
		f.add(redB);
		f.add(greenB);
		f.add(blueB);
		
		f.setSize(400,400);
		f.setVisible(true);
		
		radioBtn evt = new radioBtn();
		redB.addItemListener(evt);
		greenB.addItemListener(evt);
		blueB.addItemListener(evt);
	}

	public static void main(String[] args) {
		new Test06();
	}
	
	// �ַ� ���� ����ϴ� ��û�ڴ� itemListener�� �ȴ�.
	// ������ ���°� ��ȭ�Ǵ� ���� �̺�Ʈ�� �߻��Ѵ�.
	class radioBtn implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// ����
			// �����߿� ��𿡼� �̺�Ʈ�� �߻��ߴ��� �˾ƾ� �Ѵ�.
			// �̺�Ʈ ���� Ŭ���� �߿��� �̺�Ʈ�� �߻��� ������ �ּҸ� �˷��ִ� �Լ��� �ִ�.
			// getSource()��� �Լ��̴�.
			JRadioButton target = (JRadioButton) e.getSource();
			// �׷��� ���������� Ư¡��
			// �� ���� ���߰� ���õǾ����� Ȯ���ϴ�.
			
			Container con = f.getContentPane();
			if(target == redB){
				// ������ ���� ���߰� ���õǾ���.
				con.setBackground(Color.red);
			}else if(target == greenB){
				con.setBackground(Color.green);
			}else {
				con.setBackground(Color.blue);
			}
			
			
		}

	}
}
