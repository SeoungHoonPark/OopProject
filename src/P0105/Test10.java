/**
 * 
 */
package P0105;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import GUI.MyJFrame;

/**
 *		üũ���� 3���� �����(��,��,��)
 *		���õ� üũ���ڸ� �̿��ؼ� ������ ���� ĥ����.
 */
public class Test10 extends MyJFrame{
	JCheckBox redB, greenB, blueB;
	public Test10() {
		setLayout(new FlowLayout());
		redB = new JCheckBox("����");
		greenB = new JCheckBox("�ʷ�");
		blueB = new JCheckBox("�Ķ�");
		add(redB);
		add(greenB);
		add(blueB);
		
		setSize(500,500);
		setVisible(true);
		CheckBoxEvent10 evt = new CheckBoxEvent10();
		
		redB.addItemListener(evt);
		greenB.addItemListener(evt);
		blueB.addItemListener(evt);
	}

	public static void main(String[] args) {
		new Test10();
	}
	
	class CheckBoxEvent10 implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			//������ üũ���ڰ� ���õ� �������� �ƴ����� �˾Ƴ���.
			int red = 0;		// ó������ ���� �ȵ� ���·�
			int green = 0;	// �����ؼ� 0���� �ְ�
			int blue = 0;		// 
			
			if(redB.isSelected()){
				red=255;
			}
			if(greenB.isSelected()){
				green=255;
			}
			if(blueB.isSelected()){
				blue=255;
			}
			Color color = new Color(red, green, blue);
			// �����̳� �ȿ� ������ frame�� ã�ƶ�
			// �����̳ʴ� �ٱ� Ŭ������ �ڽ��̴�.
			// this �� ���� Ŭ������ �ǹ��Ѵ�.
			// �ٱ�Ŭ������ this�� ����ϴ� ���?
		Container con = Test10.this.getContentPane();
		con.setBackground(color);
		
		}		
	}
}
