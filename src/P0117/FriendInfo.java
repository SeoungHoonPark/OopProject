package P0117;
/*
 * 	ģ�� ��ȭ��ȣ ���� ���α׷��� ������.
 */
import		javax.swing.*;
import		javax.swing.table.*;
import		java.awt.*;
import		java.awt.event.*;

import		SQL.*;
import		java.sql.*;
public class FriendInfo {
	JTextField	noF, nameF, telF, addrF, birthF, genderF;
	JButton		allB, nameB, telB, addB, modifyB, deleteB, exitB;
	JTable				table;
	DefaultTableModel	model;

	//	�� ���α׷��� �����ͺ��̽��� ó���ؾ� �Ѵ�.
	//	�⺻ ������ �غ��Ѵ�.
	MyJDBC		db;
	//	���� ���� ���� ������Ʈ��Ʈ�� �غ��Ѵ�.
	//	1.	INSERT ����(��ģ�� ���)
	//	2.	UPDATE ����(���� ����)
	//	3.	DELETE ����(���� ����)
	//	4.	��ü �˻�
	//	5.	�̸��� �̿��ؼ� �˻�
	//	6.	��ȭ��ȣ�� �̿��ؼ� �˻�
	PreparedStatement	addS, modifyS, deleteS, allS, nameS, telS;

	public FriendInfo() {
		JFrame	frame = new JFrame("ģ�� ��ȭ��ȣ ���� ���α׷�");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//	x ���� ������ �������� ���ϰ� ������ ���´�.
		//	��� ���� ���߸� ������ ���α׷��� �������� �� ����
		
		noF = new JTextField(10);
		noF.setEditable(false);//	��ȣ�� �ڵ��Է��̹Ƿ� ������ ����
		nameF = new JTextField(10);
		telF = new JTextField(10);
		addrF = new JTextField(10);
		birthF = new JTextField(10);
		genderF = new JTextField(10);
		
		allB = new JButton("��ü �˻�");
		nameB = new JButton("�̸� �˻�");
		telB = new JButton("��ȭ��ȣ�˻�");
		addB = new JButton("�߰��ϱ�");
		modifyB = new JButton("�����ϱ�");
		deleteB = new JButton("�����ϱ�");
		exitB = new JButton("�����ϱ�");
		
		ButtonEvent	evt = new ButtonEvent();
		allB.addActionListener(evt);
		nameB.addActionListener(evt);
		telB.addActionListener(evt);
		addB.addActionListener(evt);
		modifyB.addActionListener(evt);
		deleteB.addActionListener(evt);
		exitB.addActionListener(evt);
		
		String[]	title = {"��ȣ", "�̸�", "��ȭ��ȣ", "�ּ�", "�������", "����"};
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		table.addMouseListener(new TableEvent());
		JScrollPane	sp = new JScrollPane(table);
		
		JLabel	noL = new JLabel("��ȣ");
		JLabel	nameL = new JLabel("�̸�");
		JLabel	telL = new JLabel("��ȭ��ȣ");
		JLabel	addrL = new JLabel("�ּ�");
		JLabel	birthL = new JLabel("�������");
		JLabel	genderL = new JLabel("����");
		
		JPanel	p1 = new JPanel(new GridLayout(6, 1));
		p1.add(noL);
		p1.add(nameL);
		p1.add(telL);
		p1.add(addrL);
		p1.add(birthL);
		p1.add(genderL);
		
		JPanel	p2 = new JPanel(new GridLayout(6, 1));
		p2.add(noF);
		p2.add(nameF);
		p2.add(telF);
		p2.add(addrF);
		p2.add(birthF);
		p2.add(genderF);
	
		JPanel	p3 = new JPanel(new BorderLayout());
		p3.add("West", p1);
		p3.add("Center", p2);
		
		JPanel	p4 = new JPanel(new BorderLayout());
		p4.add("North", p3);
		
		JPanel	p5 = new JPanel();
		p5.add(allB);
		p5.add(nameB);
		p5.add(telB);
		p5.add(addB);
		p5.add(modifyB);
		p5.add(deleteB);
		p5.add(exitB);
		
		frame.add("West", p4);
		frame.add("South", p5);
		frame.add("Center", sp);
		
		frame.setSize(800, 500);
		frame.setVisible(true);
		//	ȭ���� �������Ƿ� �� ���α׷��� ���۵� ���̰�
		//	�׷��� �����ͺ��̽� �غ� ����.
		db = new MyJDBC();
		//	���� Statement�� ����� ����.
		String	insert = "INSERT INTO Friend VALUES((SELECT NVL(MAX(f_no), 0) + 1 FROM Friend), ?, ?, ?, ?, ?)";
		String	update = "UPDATE Friend SET 	f_name = ?, f_tel = ?, f_addr = ?, f_birth = ?, f_gender = ? WHERE f_no = ?";
		String	delete = "DELETE FROM Friend WHERE f_no = ?";
		String 	all = "SELECT * FROM Friend ORDER BY f_no";
		String	name = "SELECT * FROM Friend WHERE f_name LIKE ? ";
		String	tel = "SELECT * FROM Friend WHERE f_tel LIKE ?";
		
		addS = db.getPSTMT(insert);
		modifyS = db.getPSTMT(update);
		deleteS = db.getPSTMT(delete);
		allS = db.getPSTMT(all);
		nameS = db.getPSTMT(name);
		telS = db.getPSTMT(tel);
		//	�����ͺ��̽� ó�� =========================
		allProc();
	}
	public static void main(String[] args) {
		new FriendInfo();
	}
	//	�������� �ϱ����� �Լ�
	//	������ �߰��ϱ� ���� ���� ���̺� �ִ� ������ ������
	void removeTable() {
		//	����
		//		������ ������ �ϴ��� �˾Ƴ���.
		//		(���� ȭ�� ���̺� ������ �ִ��� �˾Ƴ���)
		int	rows = table.getRowCount();
		//		���پ� �����.
		//		(��ü�� �ѹ��� ����� �Լ��� ����.)
		for(int i = 0; i < rows; i++) {
			model.removeRow(0);
		}
	}
	//	����� ���� �ؽ�Ʈ �ʵ�� �ڵ����� ���������� ���ڴ�.
	void removeField() {
		noF.setText("");
		nameF.setText("");
		telF.setText("");
		addrF.setText("");
		birthF.setText("");
		genderF.setText("");
	}
	
	//	���� �����Լ�
	void modifyProc() {
		//	����
		//		������ ����(�ؽ�Ʈ �ʵ��� ����)�� �˾Ƴ���.
		String	strNo = noF.getText();
		int		no = Integer.parseInt(strNo);
		String	name = nameF.getText();
		String	tel = telF.getText();
		String	addr = addrF.getText();
		String	birth = birthF.getText();
		String	gender = genderF.getText();
		//		���� Statement���� �Ͻ�Ų��.
		try {
			modifyS.setString(1, name);
			modifyS.setString(2, tel);
			modifyS.setString(3, addr);
			modifyS.setString(4, birth);
			modifyS.setString(5, gender);
			modifyS.setInt(6, no);
			modifyS.execute();
		}
		catch(Exception e) {}
		removeField();
	}
	//	ģ�� �߰� ���� �Լ�
	void addProc() {
		//	����
		//		�Է��� ���� �˾Ƴ���
		String	name = nameF.getText();
		String	tel = telF.getText();
		String	addr = addrF.getText();
		String	birth = birthF.getText();
		String	gender = genderF.getText();
		//		�����ͺ��̽��� �Է��Ѵ�.
		//		���� ������Ʈ��Ʈ���� ? �κ��� ä��� �����϶���Ѵ�.
		try {
			addS.setString(1,name);
			addS.setString(2,tel);
			addS.setString(3,addr);
			addS.setString(4,birth);
			addS.setString(5,gender);
			
			addS.execute();
		}
		catch(Exception e) {
		}
		removeField();
		allProc();
	}
	//	��ü �˻�
	void allProc() {
		//	����
		//		���Ǹ� �����ؼ� resultset�� ���ϰ�
		//		����� ���̺� �������.
		ResultSet	rs = null;
		removeTable();
		try {
			rs = allS.executeQuery();
			while(rs.next()) {
				//	���� ��� ������ �����͸� ����� �غ�
				Object[]	o = new Object[6];
				o[0] = rs.getInt("f_no");
				o[1] = rs.getString("f_name");
				o[2] = rs.getString("f_tel");
				o[3] = rs.getString("f_addr");
				o[4] = rs.getString("f_birth");
				o[5] = rs.getString("f_gender");
				
				model.addRow(o);
			}
		}
		catch(Exception e) {
			
		}
	}
	//	���� ���� �Լ�
	void deleteProc() {
			//		����
			//		������ ģ���� ��ȣ�� �˾Ƴ���.
			int no = Integer.parseInt(noF.getText());
			//		���� ���� Statement���� �Ͻ�Ų��.
			try{
				deleteS.setInt(1, no);
				deleteS.execute();
					
			}catch(Exception e){
			}
			removeField();
			removeTable();
	}
	//	�̸� �˻� ���� �Լ�
	void nameProc() {
		//	���� 
		//		1.	�˻��� �̸��� �˾Ƴ���.
		String	name = nameF.getText();
		//		2.	�̰Ϳ� ������ %�� ���δ�.
		String	temp = "%" + name + "%";
		//		3.	�̰��� ���� ������Ʈ��Ʈ���� �˷��ش�.
		ResultSet	rs = null;
		removeTable();
		try {
			nameS.setString(1, temp);
			rs = nameS.executeQuery();
			//	���� ����� ���̺� ����Ѵ�.
			while(rs.next()) {
				//	���� ��� ������ �����͸� ����� �غ�
				Object[]	o = new Object[6];
				o[0] = rs.getInt("f_no");
				o[1] = rs.getString("f_name");
				o[2] = rs.getString("f_tel");
				o[3] = rs.getString("f_addr");
				o[4] = rs.getString("f_birth");
				o[5] = rs.getString("f_gender");
				
				model.addRow(o);
			}
		}
		catch(Exception e) {
			
		}
		removeField();
	}
	
	void telProc() {
		ResultSet rs = null;
		removeTable();
		//	����
		try{
			//		�˻��� ��ȭ��ȣ�� �˾Ƴ���.
			String tel = telF.getText();
			//		%��ȣ�� ������ ���δ�.
			telS.setString(1, "%" + tel);
			//		�����ϰ� ���̺� ����Ѵ�.
			rs = telS.executeQuery();
			
			// ����Ʈ�¿� ��Ƽ� table�� ����Ѵ�.
			while(rs.next()){
				Object[] o = new Object[6];
				o[0] = rs.getInt("f_no");
				o[1] = rs.getString("f_name");
				o[3] = rs.getString("f_tel");
				o[4] = rs.getString("f_addr");
				o[5] = rs.getString("f_birth");
				o[6] = rs.getString("f_gender");
				
				model.addRow(o);
				
			}
		}catch(Exception e){
		}finally {
			db.close(rs);
		}
		removeField();
		removeTable();
	}
	
	//	���� �̺�Ʈ ó��
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton	target = (JButton) e.getSource();
			if(target == allB) {
				allProc();
			}
			else if(target == nameB) {
				nameProc();
			}
			else if(target == telB) {
				telProc();	//	����
			}
			else if(target == addB) {
				addProc();
			}
			else if(target == modifyB) {
				modifyProc();
			}
			else if(target == deleteB) {
				deleteProc();	//	����
			}
			else {
				//	�����ϱ�
				//	���α׷��� ������ ������ ����ϴ� �����ͺ��̽���
				//	�ݾ��ְ� ���α׷��� ���� �� �ֵ��� �ؾ� �Ѵ�.
				db.close(addS);
				db.close(modifyS);
				db.close(deleteS);
				db.close(allS);
				db.close(nameS);
				db.close(telS);
				db.close(db.con);
				
				System.exit(0);
			}
		}
	}
	
	//	���̺� ���콺�� ������ �� ���� ������ ������ ��������
	//	�̺�Ʈ ó��
	class TableEvent extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			//	����
			//		������ ���� �˾Ƴ���
			int	row = table.getSelectedRow();
			if(row == -1) {
				return;
			}
			//		������ �����͸� �ϳ��� ������
			int	no = (int) table.getValueAt(row, 0);
			String	name = (String) table.getValueAt(row, 1);
			String	tel = (String) table.getValueAt(row, 2);
			String	addr = (String) table.getValueAt(row, 3);
			String	birth = (String) table.getValueAt(row, 4);
			String	gender = (String) table.getValueAt(row, 5);

			//		�ؽ�Ʈ �ʵ忡 ����Ѵ�.
			noF.setText("" + no);
			nameF.setText(name);
			telF.setText(tel);
			addrF.setText(addr);
			birthF.setText(birth);
			genderF.setText(gender);
		}
	}
}
