package P0112;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI.MyJFrame;

/**
 *			JTable
 *
 *		�⺻���� ���̺� ���
 */
public class Test05 {
	MyJFrame f = new MyJFrame();
	
	public Test05() {
		
		String[][] data = {{"ȫ�浿", "010-111-1111","hong@daum.net"},
									{"�ھ���", "010-222-2222","park@daum.net"},
									{"ȫ�浿", "010-333-3333","jang@daum.net"}};
		
		String[] title = {"����","��ȭ��ȣ","�̸����ּ�"};
		
		JTable  t = new JTable(data, title);
		
		// ������ ��� ���� ��ũ�ѹٰ� �����Ƿ�...
		
		JScrollPane sp = new JScrollPane(t);
		f.add(sp);
		f.setSize(500,500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}
}
