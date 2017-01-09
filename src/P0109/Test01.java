package P0109;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import GUI.MyJFrame;

/**
 * ���ʿ� �޺����ڸ� ����� �Ʒ��ʿ� �ؽ�Ʈ �ʵ带 ���� �� �޺����ڿ��� ������
 * �����ϸ� ������ �׸� �Ʒ��ʿ� ��µǵ��� ���� 
 * 
 */
public class Test01 {
	JComboBox box;
	JTextField field;
	
	public Test01() {
		MyJFrame f = new MyJFrame();
		// ��ġ������ border�� �ϱ�� �ϰ� �����ص� �ȴ�.
		
		String[] items = {"���ϴ�", "�����", "������", "������", "������"};
		box = new JComboBox(items);
		field = new JTextField();
		
		f.add("North", box);
		f.add("South", field);
		
		f.setSize(400,500);
		f.setVisible(true);
		
		box.addItemListener(new ComboEvnet());
				
	}


	public static void main(String[] args) {
		new Test01();
	}
	
	class ComboEvnet  implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			String item = (String) box.getSelectedItem();
			//�� ������ �Ʒ��ʿ� ����Ѵ�.
			
			field.setText(item + "�� ���õǾ����ϴ�.");
			
		}
	}
	
}

