package P0106;
/*
 * ����
 * 		��ϻ��ڸ� ���� �� ������ �׸��� �ؽ�Ʈ �ʵ忡 �������.
 */
import	GUI.*;
import	java.awt.*;
import	java.awt.event.*;
import	javax.swing.*;
public class Test10 {
	List		list;
	JTextField	field;
	public Test10() {
		MyJFrame	f = new MyJFrame();
		
		list = new List(3);
		list.addItemListener(new ListEvent());
		list.add("ȫ�浿");
		list.add("�ھ���");
		list.add("�嵶��");
		list.add("�̱���");
		list.add("��ġ��");
		list.select(4);
		
		field = new JTextField();
		//	JFrame�� AWT�� �־���.
		f.add("North", list);
		f.add("South", field);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test10();
	}
	
	class ListEvent implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			String	item = list.getSelectedItem();
			field.setText(item);
			field.setText("");
		}
	}
}



