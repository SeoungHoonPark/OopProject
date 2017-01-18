package P0117;
/*
 * 	친구 전화번호 관리 프로그램을 만들어보자.
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

	//	이 프로그램은 데이터베이스를 처리해야 한다.
	//	기본 변수를 준비한다.
	MyJDBC		db;
	//	전담 질의 실행 스테이트먼트를 준비한다.
	//	1.	INSERT 질의(새친구 등록)
	//	2.	UPDATE 질의(정보 수정)
	//	3.	DELETE 질의(웬수 삭제)
	//	4.	전체 검색
	//	5.	이름을 이용해서 검색
	//	6.	전화번호를 이용해서 검색
	PreparedStatement	addS, modifyS, deleteS, allS, nameS, telS;

	public FriendInfo() {
		JFrame	frame = new JFrame("친구 전화번호 관리 프로그램");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//	x 단추 누르면 종료하지 못하게 방지해 놓는다.
		//	대신 종료 단추를 눌러야 프로그램이 끝나도록 해 놓자
		
		noF = new JTextField(10);
		noF.setEditable(false);//	번호는 자동입력이므로 보여만 주자
		nameF = new JTextField(10);
		telF = new JTextField(10);
		addrF = new JTextField(10);
		birthF = new JTextField(10);
		genderF = new JTextField(10);
		
		allB = new JButton("전체 검색");
		nameB = new JButton("이름 검색");
		telB = new JButton("전화번호검색");
		addB = new JButton("추가하기");
		modifyB = new JButton("수정하기");
		deleteB = new JButton("삭제하기");
		exitB = new JButton("종료하기");
		
		ButtonEvent	evt = new ButtonEvent();
		allB.addActionListener(evt);
		nameB.addActionListener(evt);
		telB.addActionListener(evt);
		addB.addActionListener(evt);
		modifyB.addActionListener(evt);
		deleteB.addActionListener(evt);
		exitB.addActionListener(evt);
		
		String[]	title = {"번호", "이름", "전화번호", "주소", "생년월일", "성별"};
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		table.addMouseListener(new TableEvent());
		JScrollPane	sp = new JScrollPane(table);
		
		JLabel	noL = new JLabel("번호");
		JLabel	nameL = new JLabel("이름");
		JLabel	telL = new JLabel("전화번호");
		JLabel	addrL = new JLabel("주소");
		JLabel	birthL = new JLabel("생년월일");
		JLabel	genderL = new JLabel("성별");
		
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
		//	화면이 나왔으므로 이 프로그램은 시작된 것이고
		//	그러면 데이터베이스 준비를 하자.
		db = new MyJDBC();
		//	전담 Statement를 만들어 놓자.
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
		//	데이터베이스 처리 =========================
		allProc();
	}
	public static void main(String[] args) {
		new FriendInfo();
	}
	//	마무리를 하기위한 함수
	//	내용을 추가하기 전에 먼저 테이블에 있는 내용을 지우자
	void removeTable() {
		//	할일
		//		몇줄을 지워야 하는지 알아낸다.
		//		(현재 화면 테이블에 몇줄이 있는지 알아내자)
		int	rows = table.getRowCount();
		//		한줄씩 지운다.
		//		(전체를 한번에 지우는 함수가 없다.)
		for(int i = 0; i < rows; i++) {
			model.removeRow(0);
		}
	}
	//	사용이 끝난 텍스트 필드는 자동으로 지워졌으면 좋겠다.
	void removeField() {
		noF.setText("");
		nameF.setText("");
		telF.setText("");
		addrF.setText("");
		birthF.setText("");
		genderF.setText("");
	}
	
	//	수정 전담함수
	void modifyProc() {
		//	할일
		//		수정할 내용(텍스트 필드의 내용)을 알아낸다.
		String	strNo = noF.getText();
		int		no = Integer.parseInt(strNo);
		String	name = nameF.getText();
		String	tel = telF.getText();
		String	addr = addrF.getText();
		String	birth = birthF.getText();
		String	gender = genderF.getText();
		//		전담 Statement에게 일시킨다.
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
	//	친구 추가 전담 함수
	void addProc() {
		//	할일
		//		입력한 내용 알아내고
		String	name = nameF.getText();
		String	tel = telF.getText();
		String	addr = addrF.getText();
		String	birth = birthF.getText();
		String	gender = genderF.getText();
		//		데이터베이스에 입력한다.
		//		전담 스테이트먼트에게 ? 부분을 채우고 실행하라고한다.
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
	//	전체 검색
	void allProc() {
		//	할일
		//		질의를 실행해서 resultset을 구하고
		//		결과를 테이블에 출력하자.
		ResultSet	rs = null;
		removeTable();
		try {
			rs = allS.executeQuery();
			while(rs.next()) {
				//	나온 결과 한줄의 데이터를 기억할 준비
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
	//	삭제 전담 함수
	void deleteProc() {
			//		할일
			//		삭제할 친구의 번호를 알아낸다.
			int no = Integer.parseInt(noF.getText());
			//		삭제 전담 Statement에게 일시킨다.
			try{
				deleteS.setInt(1, no);
				deleteS.execute();
					
			}catch(Exception e){
			}
			removeField();
			removeTable();
	}
	//	이름 검색 전담 함수
	void nameProc() {
		//	할일 
		//		1.	검색할 이름을 알아낸다.
		String	name = nameF.getText();
		//		2.	이것에 강제로 %를 붙인다.
		String	temp = "%" + name + "%";
		//		3.	이것을 전담 스테이트먼트에게 알려준다.
		ResultSet	rs = null;
		removeTable();
		try {
			nameS.setString(1, temp);
			rs = nameS.executeQuery();
			//	나온 결과를 테이블에 출력한다.
			while(rs.next()) {
				//	나온 결과 한줄의 데이터를 기억할 준비
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
		//	할일
		try{
			//		검색할 전화번호를 알아낸다.
			String tel = telF.getText();
			//		%기호를 강제로 붙인다.
			telS.setString(1, "%" + tel);
			//		실행하고 테이블에 출력한다.
			rs = telS.executeQuery();
			
			// 리젤트셋에 담아서 table에 출력한다.
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
	
	//	단추 이벤트 처리
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
				telProc();	//	숙제
			}
			else if(target == addB) {
				addProc();
			}
			else if(target == modifyB) {
				modifyProc();
			}
			else if(target == deleteB) {
				deleteProc();	//	숙제
			}
			else {
				//	종료하기
				//	프로그램을 끝내기 전에는 사용하던 데이터베이스를
				//	닫아주고 프로그램이 끝날 수 있도록 해야 한다.
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
	
	//	테이블에 마우스를 누르면 그 줄의 내용이 옆으로 가기위한
	//	이벤트 처리
	class TableEvent extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			//	할일
			//		선택한 줄을 알아내고
			int	row = table.getSelectedRow();
			if(row == -1) {
				return;
			}
			//		그줄의 데이터를 하나씩 꺼내서
			int	no = (int) table.getValueAt(row, 0);
			String	name = (String) table.getValueAt(row, 1);
			String	tel = (String) table.getValueAt(row, 2);
			String	addr = (String) table.getValueAt(row, 3);
			String	birth = (String) table.getValueAt(row, 4);
			String	gender = (String) table.getValueAt(row, 5);

			//		텍스트 필드에 출력한다.
			noF.setText("" + no);
			nameF.setText(name);
			telF.setText(tel);
			addrF.setText(addr);
			birthF.setText(birth);
			genderF.setText(gender);
		}
	}
}
