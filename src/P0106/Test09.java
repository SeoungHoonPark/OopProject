package P0106;
/*
 * 	��ϻ��� �ϳ��� ����� �װ��� ���������� ������ ������
 * 	ȭ�鿡 ����ϵ��� ����.
 */
import		GUI.*;
import		java.awt.*;
import		javax.swing.*;
import		java.util.*;
import		javax.swing.event.*;
public class Test09 {
	JList	list;
	public Test09() {
		MyJFrame	f = new MyJFrame();
		f.setLayout(new FlowLayout());
		Vector	v = new Vector();
		v.add("ȫ�浿");
		v.add("�嵶��");
		v.add("�̱���");
		v.add("��ġ��");
		v.add("������");
		
		list = new JList(v);
		list.addListSelectionListener(new ListEvent());
		list.setVisibleRowCount(3);
		//	�ڡڡڡ�
		JScrollPane	sp = new JScrollPane(list);
		//	����
		//		JScrollPane �� Panel �� ��������
		//		�Ϲ�  Panel �� ������ ����������
		//		JScrollPane�� ��ũ�ѹ� ����� ���� Panel�̴�.
		f.add(sp);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test09();
	}
	
	class ListEvent implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			//	����
			//		������ �׸��� �������� �˾Ƴ���.
			String	item = (String) list.getSelectedValue();
			System.out.println("������ �׸� = " + item);
			
			//	�� �Լ��� ������, ������ �ι� ȣ��ȴ�.
		}
	}
}


