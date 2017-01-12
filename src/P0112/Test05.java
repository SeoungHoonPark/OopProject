package P0112;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI.MyJFrame;

/**
 *			JTable
 *
 *		기본적인 테이블 모습
 */
public class Test05 {
	MyJFrame f = new MyJFrame();
	
	public Test05() {
		
		String[][] data = {{"홍길동", "010-111-1111","hong@daum.net"},
									{"박아지", "010-222-2222","park@daum.net"},
									{"홍길동", "010-333-3333","jang@daum.net"}};
		
		String[] title = {"성명","전화번호","이메일주소"};
		
		JTable  t = new JTable(data, title);
		
		// 스윙의 모든 것은 스크롤바가 없으므로...
		
		JScrollPane sp = new JScrollPane(t);
		f.add(sp);
		f.setSize(500,500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test05();
	}
}
