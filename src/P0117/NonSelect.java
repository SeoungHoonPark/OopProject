package P0117;
/*
 * 	텍스트 에리어에 질의 명령을 입력한 후
 * 	단추를 누르면 질의 명령이 실행되는 프로그램을 작성하세요.
 * 
 * 	단,	SELECT 질의가 아닌 다른 질의만 실행하는 프로그램
 */
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import	GUI.*;
import	SQL.*;
import	java.sql.*;
public class NonSelect {
	JTextArea		area;
	JLabel			resultL;
	JButton			execB, exitB;
	public NonSelect() {
		MyJFrame	f = new MyJFrame();
		
		area = new JTextArea();
		JScrollPane sp = new JScrollPane(area);
		resultL = new JLabel();
		execB = new JButton(" 실행 ");
		exitB = new JButton(" 종료 ");
		
		ButtonEvent	evt = new ButtonEvent();
		execB.addActionListener(evt);
		exitB.addActionListener(evt);
		
		JPanel	p1 = new JPanel();
		p1.add(execB);
		p1.add(exitB);
		
		JPanel	p2 = new JPanel(new GridLayout(2, 1));
		p2.add(resultL);
		p2.add(p1);
		
		f.add("Center", sp);
		f.add("South", p2);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new NonSelect();
	}
	void execProc() {
		//	할일
		//		텍스트 에리어에 있는 질의 명령을 알아낸다.
		String	sql = area.getText();
		//		JDBC 는 ;으로 종료하면 안되므로 실수 ;을 넣었으면
		//		제거해준다.
		while(sql.endsWith(";")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		//		실행한다.
		MyJDBC	db = null;
		Statement	stmt = null;
		try {
			db = new MyJDBC();
			stmt = db.getSTMT();
			stmt.execute(sql);
			resultL.setText("실행이 성공했습니다.");
		}
		catch(Exception e) {
			resultL.setText(e.toString());
		}
		finally {
			db.close(stmt);
			db.close(db.con);
		}
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton	target = (JButton) e.getSource();
			if(target == execB) {
				execProc();
			}
			else {
				System.exit(0);
			}
		}
	}
}


