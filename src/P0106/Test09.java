package P0106;
/*
 * 	목록상자 하나를 만들고 그것을 선택했을때 선택한 내용을
 * 	화면에 출력하도록 하자.
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
		v.add("홍길동");
		v.add("장독대");
		v.add("이기자");
		v.add("김치국");
		v.add("나선돌");
		
		list = new JList(v);
		list.addListSelectionListener(new ListEvent());
		list.setVisibleRowCount(3);
		//	★★★★
		JScrollPane	sp = new JScrollPane(list);
		//	참고
		//		JScrollPane 은 Panel 의 일종으로
		//		일반  Panel 은 투명한 상태이지만
		//		JScrollPane은 스크롤바 모양을 가진 Panel이다.
		f.add(sp);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test09();
	}
	
	class ListEvent implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			//	할일
			//		선택한 항목이 무엇인지 알아낸다.
			String	item = (String) list.getSelectedValue();
			System.out.println("선택한 항목 = " + item);
			
			//	이 함수는 선택전, 선택후 두번 호출된다.
		}
	}
}


