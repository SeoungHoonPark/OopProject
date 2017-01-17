package P0117;
/*
 * 	�ؽ�Ʈ ����� ���� ����� �Է��� ��
 * 	���߸� ������ ���� ����� ����Ǵ� ���α׷��� �ۼ��ϼ���.
 * 
 * 	��,	SELECT ���ǰ� �ƴ� �ٸ� ���Ǹ� �����ϴ� ���α׷�
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
		execB = new JButton(" ���� ");
		exitB = new JButton(" ���� ");
		
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
		//	����
		//		�ؽ�Ʈ ����� �ִ� ���� ����� �˾Ƴ���.
		String	sql = area.getText();
		//		JDBC �� ;���� �����ϸ� �ȵǹǷ� �Ǽ� ;�� �־�����
		//		�������ش�.
		while(sql.endsWith(";")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		//		�����Ѵ�.
		MyJDBC	db = null;
		Statement	stmt = null;
		try {
			db = new MyJDBC();
			stmt = db.getSTMT();
			stmt.execute(sql);
			resultL.setText("������ �����߽��ϴ�.");
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


