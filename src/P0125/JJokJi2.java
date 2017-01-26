package P0125;

import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import java.io.FileInputStream;
import		java.util.*;

import		java.net.*;
public class JJokJi2 {
	//	이름을 알면 주소를 찾아내기 위한 Map
	//	주소를 알면 이름을 찾아내기 위한 Map
	Properties		nameToIp, ipToName;	
	JList	list;
	JButton	sendB;
	JFrame	frame;
	
	DatagramSocket		sSocket, rSocket;
	//	sSocket은 쪽지를 보내기 위한 소켓
	//	rSocket은 쪽지를 받기 위한 소켓
	
	//	참고로
	//		반드시 2개를 만들어야 하는 것은 아니다.
	//		소켓 하나만 가지고도 보내기와 받기를 할 수 있다.
	//		다만....
	//			이 경우에는 보내는 도중에는 받지를 못할 수 있다.
	//		그래서 안전한 통신을 위해서
	//		보내는 소켓과 받는 소켓을 구분해 처리하는 것이 좋다.
	public JJokJi2() {
		setMap();
		frame = new JFrame("쪽지 프로그램");
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		
		//	목록상자안에 친구 이름을 기록하기로 했으므로
		//	Map에서 친구이름만 찾아서 넣어놓자.
		Set			temp = nameToIp.keySet();
		Vector		v = new Vector(temp);
		list = new JList(v);
		JScrollPane sp = new JScrollPane(list);
		sendB = new JButton("쪽지쓰기");
		sendB.addActionListener(new ButtonEvent());
		frame.add("Center", sp);
		frame.add("South", sendB);
		
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		//	이제 프로그램이 시작되었으므로.... 네트워크 구성을
		//	할 차례이다.
		//	오늘은 UDP 통신이므로 DatagramSocket을 이용해서
		//	네트워크 구성을 할 예정이다.
		try {
			sSocket = new DatagramSocket();
			rSocket = new DatagramSocket(9999);
			//	이렇게 하면 누군가에 접속을 하는 것은 아니고
			//	다만 네트워크 회선에만 접속을 한 상태가 된다.
			//	즉, 네트워크가 가능하도록만 해주는 것이다.
			
			//	이제 네트워크 구성이 완료되었으므로
			//	쪽지를 보내고 받을 수 있다.
			//	받는 프로그램을 시작하자.
			ReceiveThread	t = new ReceiveThread(this);
			t.start();
		}
		catch(Exception e) {
			close();
		}
	}
	
	void close() {
		try {
			sSocket.close();
			rSocket.close();
		}
		catch(Exception e) {}
		System.exit(0);
	}
	
	void setMap() {
		nameToIp = new Properties();
		ipToName = new Properties();
		FileInputStream	fin1 = null;
		FileInputStream	fin2 = null;
		try {
			fin1 = new FileInputStream("src/M01/P0125/ip_ko.txt");
			fin2 = new FileInputStream("src/M01/P0125/name_ko.txt");
			nameToIp.load(fin1);
			ipToName.load(fin2);
		}
		catch(Exception e) {}
	}
	public static void main(String[] args) {
		new JJokJi();
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	할일
			//		목록상자에서 선택한 이름을 알아낸다.
			String	name = (String)list.getSelectedValue();
			if(name == null || name.length() == 0) {
				return;
			}
			//		보내기 위한 대화상자를 new 시킨다.
			SendDlg	dlg = new SendDlg(JJokJi2.this);
			//		텍스트 필드에 받는사람 이름 써주고
			dlg.field.setText(name);
			//		화면에 출력한다.
			dlg.frame.setVisible(true);
		}
	}
}
