package P0106;
/*
 * 문제
 * 		목록상자를 만든 후 선택한 항목을 텍스트 필드에 출력하자.
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
		list.add("홍길동");
		list.add("박아지");
		list.add("장독대");
		list.add("이기자");
		list.add("김치국");
		list.select(4);
		
		field = new JTextField();
		//	JFrame에 AWT를 넣었다.
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



