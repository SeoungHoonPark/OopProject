package P0124;
import	NETData.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
public class ChatPanel03 extends JPanel {
	ChatClient03	main;
	JButton		uploadB, listB, downloadB;
	JComboBox	listBox;
	JTextArea	area;
	JScrollPane	sp;
	JTextField	field;
	public ChatPanel03(ChatClient03 m) {
		main = m;
		this.setLayout(new BorderLayout());
		uploadB = new JButton("업로드");
		listB = new JButton("목록요청");
		downloadB = new JButton("다운로드");
		listBox = new JComboBox();
		//	이 안에는 나중에서 서버에게서 목록을 받아서 항목을
		//	만들 예정이므로...
		area = new JTextArea();
		sp = new JScrollPane(area);
		field = new JTextField();
		
		ChatEvent	evt = new ChatEvent();
		uploadB.addActionListener(evt);
		downloadB.addActionListener(evt);
		listB.addActionListener(evt);
		field.addActionListener(evt);
		
		JPanel	p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(uploadB);
		JPanel	p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(listB);
		JPanel	p3 = new JPanel(new GridLayout(1, 2));
		p3.add(p1);
		p3.add(p2);
		
		JPanel	p4 = new JPanel(new BorderLayout());
		p4.add("Center", listBox);
		p4.add("East", downloadB);
		
		JPanel	p5 = new JPanel(new GridLayout(2, 1));
		p5.add(p3);
		p5.add(p4);
		
		this.add("North", p5);
		this.add("Center", sp);
		this.add("South", field);
	}
	//	채팅 전담 함수
	void sendProc() {
		//	할일
		//		보낼 내용을 알아내고
		String	msg = field.getText();
		if(msg == null || msg.length() == 0) {
			return;
		}
		//		서버에 보낸다.
		//		1.	MainData를 생성(필수)
		MainData	mainD = new MainData();
		//		2.	작업 Data를 생성(선택)
		ChatData	chatD = new ChatData();
		//		3.	필요한 데이터를 채운다.
		mainD.protocol = 1201;
		chatD.msg = msg;
		//		4.	작업 데이터를 메인 데이터에 합친다.
		mainD.chatD = chatD;
		//		5.	보낸다.
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	//	업로드 전담 함수
	void uploadProc() {
		//	할일
		//		업로드할 파일을 선택하도록 한다.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showOpenDialog(main.frame);
		String	fileName = null;	//	파일이름을 기억할 변수
		byte[]	buff = null;		//	파일 내용을 기억할 변수
		File	file = null;		//	파일의 정보를 기억할 변수
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			fileName = file.getName(); 
		}
		//		선택한 파일을 스트림으로 읽는다.
		FileInputStream	fin = null;
		try {
			//	파일을 열고
			fin = new FileInputStream(file);
			//	읽은 결과를 기억할 byte[]을 파일의 크기만큼 준비하고
			buff = new byte[(int)file.length()];
			//	이 프로그램의 문제점
			//		파일 업로드는 한번에 읽어서 보내도록 만들었다.
			//		너무 용량이 큰 파일은 안된다.
			//	한번에 읽는다.
			fin.read(buff);
		}
		catch(Exception e) {
		}
		finally {
			try {
				fin.close();
			}
			catch(Exception e) {}
		}
		//		서버에 보낸다.
		//		MainData 생성
		MainData	mainD = new MainData();
		//		작업 데이터 생성
		FileData	fileD = new FileData();
		//		데이터 채우기
		mainD.protocol = 1301;
		fileD.fileName = fileName;
		fileD.buff = buff;
		//		작업 데이터를 MainData에 넣기
		mainD.fileD = fileD;
		//		보내기
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}
	//	파일 목록 요청
	void listProc() {
		//	할일
		//		그냥 파일목록 보내달라고 요청만 하면 된다.
		MainData	mainD = new MainData();
		mainD.protocol = 1302;
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	//	다운로드 요청 전담 함수
	void downloadProc() {
		//	할일
		//		콤보상자에서 선택한 파일을 알아내고
		String	fileName = (String)listBox.getSelectedItem();
		//		서버에 보낸다.
		MainData	mainD = new MainData();
		FileData	fileD = new FileData();
		mainD.protocol = 1303;
		fileD.fileName = fileName;
		mainD.fileD = fileD;
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	class ChatEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	이 함수는 텍스트 필드와 단추에서 모두 발생한다.
			Object	target = e.getSource();
			if(target instanceof JTextField) {
				sendProc();
			}
			else {
				//	단추에서 이벤트가 발생한 것
				JButton	temp = (JButton) target;
				if(temp == uploadB) {
					uploadProc();
				}
				else if(temp == listB){
					listProc();
				}
				else {
					//	다운로드 단추
					downloadProc();
				}
			}
		}
	}
}





