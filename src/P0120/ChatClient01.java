package P0120;
/*
 * 	채팅을 할 수 있는 폼을 제공하고
 * 	채팅 프로그램을 만들어보자.
 * 
 * 	1.	폼 만든다.
 * 	2.	서버에 접속을 한다.(통신준비)
 * 	3.	통신을 해보자.
 * 		1)	서버에 데이터를 보내보자.
 * 		2)	서버에서준 데이터를 받아보자.
 */
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import		java.net.*;
import		java.io.*;
public class ChatClient01 {
	JTextArea	area;
	JTextField	field;
	JScrollPane	sp;
	//	통신을 위한 변수(접속, 스트림)
	Socket			socket;
	PrintWriter		pw;
	BufferedReader	br;
	//	채팅은 단순히 문자만 주고 받는 기능으로 만들 예정이다.
	//	그러므로 한줄의 문자를 손쉽게 주고 받기 위해서는....
	//		println()
	//		readLine()
	public ChatClient01() {
		JFrame	f = new JFrame("채팅 클라이언트");
		f.addWindowListener(new FrameEvent());
		
		area = new JTextArea();
		area.setBackground(Color.orange);
		area.setEditable(false);
		sp = new JScrollPane(area);
		
		field = new JTextField();
		JButton btn = new JButton("SEND");
		
		ButtonEvent	evt = new ButtonEvent();
		field.addActionListener(evt);
		btn.addActionListener(evt);
		
		JPanel	p1 = new JPanel(new BorderLayout());
		p1.add("Center", field);
		p1.add("East", btn);
		
		f.add("Center", sp);
		f.add("South", p1);
		
		f.setSize(400, 600);
		f.setVisible(true);

		//	이제 화면이 준비되었으므로....통신 준비를 하자
		try {
			//	서버에 연결을 시도하자.
			socket = new Socket("192.168.35.92", 7788);
			//	통신할 스트림을 준비한다.
			InputStream		in = socket.getInputStream();
			OutputStream	out = socket.getOutputStream();
			pw = new PrintWriter(out);
			
			InputStreamReader	temp = new InputStreamReader(in);
			br = new BufferedReader(temp);
		}
		catch(Exception e) {
			//	문제 발생
			//	이 프로그램의 특징상 실행하면 안되는 프로그램
			close();
		}
		//	모든 준비가 끝났으므로... 데이터를 받을 준비를 하자.
		ReceiveThread	t = new ReceiveThread(this);
		t.start();
	}
	void close() {
		try {
			pw.close();
			br.close();
			socket.close();
		}
		catch(Exception e1) {}
		System.exit(0);
	}
	public static void main(String[] args) {
		new ChatClient01();
	}
	//	프로그램을 종료시키기 위해서 x 단추를 누르는 이벤트는
	//	WindowListener가 담당하고
	//	이 안에 있는 windowClosing() 이라는 함수가 처리를 한다.
	class FrameEvent extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			//	할일은 많지만 나중에 하고
			close();
		}
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	이 함수는
			//		단추누른 경우
			//		텍스트 필드에서 엔터키 친 경우
			//		리스트에서 더블 클릭한 경우
			//		메뉴를 선택한 경우

			//	할일
			//		텍스트 필드의 내용 알아내고
			String	msg = field.getText();
			if(msg == null || msg.length() == 0) {
				return;
			}
			//		이 내용을 서버에 보내면 된다.
			pw.println(msg);
			pw.flush();
			
			field.setText("");
		}
	}
}
/*
 * 	서버가 준 데이터를 받을 프로그램을 따로 만든다.
 * 	이 프로그램은 스레드로 만들어서 독립적으로 실행되도록
 * 	해주어야 한다.
 */
class ReceiveThread extends Thread {
	ChatClient01	main;
	public ReceiveThread(ChatClient01 m) {
		main = m;
	}
	public void run() {
		//	할일
		//	데이터를 계속해서 받자
		try {
			//	서버가 몇번 데이터를 줄지 모르므로....
			while(true) {
				//	데이터 받자
				//	스트림을 이용해서 받아야 한다.
				String	msg = main.br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
				//	받은 데이터 출력하자.
				main.area.append(msg + "\r\n");
				//	받은 데이터를 출력할 위치는 폼의
				//	텍스트 에리어이다.
				main.sp.getVerticalScrollBar().setValue(main.sp.getVerticalScrollBar().getMaximum());
			}
		}
		catch(Exception e) {
			//	받는쪽에서 문제가 생기면 이 프로그램도
			//	몬쓰는 프로그램이다.
			main.close();
		}
	}
}
