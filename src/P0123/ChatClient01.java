package P0123;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;

import	java.net.*;
import	java.io.*;
public class ChatClient01 {
	JFrame			frame;
	JPanel			mainP;	//	카드Layout을 설치할 보조 컨테이너
	CardLayout		card;
	RoomPanel		roomP;
	ChatPanel		chatP;
	
	Socket			socket;
	PrintWriter		pw;
	BufferedReader	br;
	
	ReceiveThread	rThread;
	public ChatClient01() {
		frame = new JFrame();
		frame.setTitle("[대기방] 입니다.");
		frame.addWindowListener(new FrameEvent());
//		card = new CardLayout();
		mainP = new JPanel(card = new CardLayout());
		frame.add("Center", mainP);
		
		roomP = new RoomPanel(this);
		chatP = new ChatPanel(this);
		//	카드 레이아웃을 이용할 경우에는 반드시 카드의
		//	이름을 정하면서 넣는다.
		mainP.add("Room", roomP);
		mainP.add("Chat", chatP);
		
		frame.setSize(400, 600);
		frame.setVisible(true);
		
		//	이제 화면이 출력되었으므로.... 
		try {
			//	서버에 접속을 시도하자.
			socket = new Socket("192.168.35.92", 8877);
			//	통신할 준비(스트림 준비)
			InputStream		in = socket.getInputStream();
			OutputStream	out = socket.getOutputStream();
			pw = new PrintWriter(out);
			InputStreamReader temp = new InputStreamReader(in);
			br = new BufferedReader(temp);
			
			rThread = new ReceiveThread(this);
			rThread.start();
		}
		catch(Exception e) {
			//	이 프로그램은 네트워크가 안되는 프로그램이 된다.
			close();
		}
	}
	//	프로그램을 종료하기 위한 함수
	void close() {
		//	사용하던 자원 닫고
		try {
			br.close();
			pw.close();
			socket.close();
		}
		catch(Exception e) {}
		System.exit(0);
	}
	public static void main(String[] args) {
		new ChatClient01();
	}
	//	x 단추 누르면 프로그램을 종료하기 위한 이벤트 설치를 한다.
	class FrameEvent extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			close();
		}
	}
}

/*
 * 	두개의 화면이 필요하므로 각각의 화면을 담당할 클래스를 따로 만들자.
 */
class RoomPanel extends JPanel {
	ChatClient01	main;
	JTextField		nickF;
	//	방은 3개로 정하고 콤보상자로 선택하도록 할 예정이다.
	JComboBox		roomB;
	JButton			nickBtn, roomBtn;
	public RoomPanel(ChatClient01 m) {
		main = m;
		nickF = new JTextField();
		roomB = new JComboBox();
		roomB.setEnabled(false);
		roomB.addItem("자바 방");
		roomB.addItem("JSP 방");
		roomB.addItem("Web 방");
		
		nickBtn = new JButton("닉네임전송");
		roomBtn = new JButton("방 입 장");
		ButtonEvent	evt = new ButtonEvent();
		nickBtn.addActionListener(evt);
		roomBtn.addActionListener(evt);
		
		JLabel	nickL = new JLabel("닉네임");
		JLabel	roomL = new JLabel("방선택");
		
		JPanel	p1 = new JPanel(new GridLayout(2, 1));
		p1.add(nickL);
		p1.add(roomL);
		
		JPanel	p2 = new JPanel(new GridLayout(2, 1));
		p2.add(nickF);
		p2.add(roomB);

		JPanel	p3 = new JPanel(new GridLayout(2, 1));
		p3.add(nickBtn);
		p3.add(roomBtn);
		
		JPanel	p4 = new JPanel(new BorderLayout());
		p4.add("West", p1);
		p4.add("Center", p2);
		p4.add("East", p3);
		
		ImageIcon logoImg = new ImageIcon("src/M01/P0123/tae.jpg");
		JLabel	logoL = new JLabel(logoImg);
		
		this.setLayout(new BorderLayout());
		this.add("Center", logoL);
		this.add("South", p4);
	}
	void nickProc() {
		//	할일
		//	1.	텍스트 필드에 입력된 닉네임을 알아낸다.
		String	nick = nickF.getText();
		//	2.	사용자 정의 프로토콜을 붙인다.
		nick = "1101" + nick;
		//	3.	서버에 보낸다.
		//		스트림을 이용해서 보내야하는데... 스트림은
		//		위쪽 클래스가 가지고있다.
		main.pw.println(nick);
		main.pw.flush();
	}
	void roomProc() {
		//	할일
		//		선택한 방을 알아낸다.
		String	room = (String)roomB.getSelectedItem();
		//		프로토콜을 붙인다.
		room = "1201" + room;
		//		서버에게 보낸다.
		main.pw.println(room);
		main.pw.flush();
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton	target = (JButton) e.getSource();
			if(target == nickBtn) {
				nickProc();
			}
			else {
				roomProc();
			}
		}
	}
}
	
class ChatPanel extends JPanel {
	ChatClient01	main;
	JTextArea	area;
	JScrollPane	sp;
	JButton		exitB, sendB;
	JTextField	field;
	public ChatPanel(ChatClient01 m) {
		main = m;
		area = new JTextArea();
		area.setEditable(false);
		area.setBackground(Color.PINK);
		sp = new JScrollPane(area);
		exitB = new JButton("방 퇴 장");
		sendB = new JButton("대화하기");
		field = new JTextField();
		
		ButtonEvent	evt = new ButtonEvent();
		exitB.addActionListener(evt);
		sendB.addActionListener(evt);
		field.addActionListener(evt);
		
		field.setBackground(Color.cyan);
		JPanel	p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(exitB);
		
		JPanel	p2 = new JPanel(new BorderLayout());
		p2.add("Center", field);
		p2.add("East", sendB);
		
		this.setLayout(new BorderLayout());
		this.add("North", p1);
		this.add("Center", sp);
		this.add("South", p2);
	}
	void sendProc() {
		//	할일
		//		텍스트 필드에 입력한 대화 내용 알아내서
		String	text = field.getText();
		if(text == null || text.length() == 0) {
			return;
		}
		//		프로토콜 붙여서
		text = "1301" + text;
		//		서버에 보낸다.
		main.pw.println(text);
		main.pw.flush();
	}
	
	void exitProc() {
		//	할일
		//		방이름을 알아내고
		String	room = (String) main.roomP.roomB.getSelectedItem();
		//		프로토콜 붙여서
		room = "1202" + room;
		//		서버에 보낸다.
		main.pw.println(room);
		main.pw.flush();
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	이 함수가 실행되는 경우
			//		텍스트필드에서 엔터키, 방퇴장 단추 클릭,
			//		보내기 단추 누른 경우
			//	이처럼 한 함수가 여러개의 클래스를 사용하는 경우
			//	1.	Object 로 받아라
			Object	target = e.getSource();
			//	2.	instanceof 를 이용해서 구분 처리하세요
			if(target instanceof JTextField) {
				//	JTextField	temp = (JTextField) target;
				//	....
				sendProc();
			}
			else if(target instanceof JButton) {
				JButton	temp = (JButton) target;
				if(temp == exitB) {
					exitProc();
				}
				else if(temp == sendB) {
					sendProc();
				}
			}
		}
	}
}
/*
 * 	받기만 해주는 전담 프로그램을 따로 만들자
 */
class ReceiveThread extends Thread {
	ChatClient01	main;
	public ReceiveThread(ChatClient01 m) {
		main = m;
	}
	public void run() {
		try {
			//	몇번 반복해서 받아야 할지 모르므로....
			while(true) {
				String	msg = main.br.readLine();
				//	받았는데 내용이 없으면... 소켓이 잘못되어서
				//	잘못 받은것이다.
				if(msg == null || msg.length() == 0) {
					//	이 프로그램 몬쓰는 프로그램이다.
					break;
				}
				//	받았으면....
				//	할일
				//		1.	프로토콜을 분석한다.
				//			우리는 처음 4글자가 프로토콜이다.
				String	protocol = msg.substring(0, 4);
				int		intP = Integer.parseInt(protocol);
				msg = msg.substring(4);
				//		2.	각각의 프로토콜에 맞는 작업을 진행한다.
				switch(intP) {
				case	2101:	//	닉네임 응답
					//	할일
					//		1.	방을 선택할 수 있도록 해주자.
					main.roomP.roomB.setEnabled(true);
					break;
				case	2201:	//	방입장 응답
					//	할일
					//		1.	화면을 채팅방으로 바꿔준다.
					String	room = (String) main.roomP.roomB.getSelectedItem();
					main.frame.setTitle("[" + room + "] 방입니다.");
					main.card.show(main.mainP, "Chat");
					break;
				case	2202:	//	방퇴장 응답
					//	할일
					//		1.	지금까지 채팅한 내용은 지우고
					main.chatP.area.setText("");
					//		2.	화면은 방선택 화면으로 바꾼다.
					main.frame.setTitle("[대기방]입니다.");
					main.card.show(main.mainP, "Room");
					break;
				case	2301:	//	채팅 내용
					//	할일
					//		화면에 내용을 출력한다
					main.chatP.area.append(msg + "\r\n");
					main.chatP.sp.getVerticalScrollBar().setValue(main.chatP.sp.getVerticalScrollBar().getMaximum());
					break;
				}
			}
		}
		catch(Exception e) {
			main.close();
		}
	}
}