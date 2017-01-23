package P0123;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;

import	java.net.*;
import	java.io.*;
public class ChatClient01 {
	JFrame			frame;
	JPanel			mainP;	//	ī��Layout�� ��ġ�� ���� �����̳�
	CardLayout		card;
	RoomPanel		roomP;
	ChatPanel		chatP;
	
	Socket			socket;
	PrintWriter		pw;
	BufferedReader	br;
	
	ReceiveThread	rThread;
	public ChatClient01() {
		frame = new JFrame();
		frame.setTitle("[����] �Դϴ�.");
		frame.addWindowListener(new FrameEvent());
//		card = new CardLayout();
		mainP = new JPanel(card = new CardLayout());
		frame.add("Center", mainP);
		
		roomP = new RoomPanel(this);
		chatP = new ChatPanel(this);
		//	ī�� ���̾ƿ��� �̿��� ��쿡�� �ݵ�� ī����
		//	�̸��� ���ϸ鼭 �ִ´�.
		mainP.add("Room", roomP);
		mainP.add("Chat", chatP);
		
		frame.setSize(400, 600);
		frame.setVisible(true);
		
		//	���� ȭ���� ��µǾ����Ƿ�.... 
		try {
			//	������ ������ �õ�����.
			socket = new Socket("192.168.35.92", 8877);
			//	����� �غ�(��Ʈ�� �غ�)
			InputStream		in = socket.getInputStream();
			OutputStream	out = socket.getOutputStream();
			pw = new PrintWriter(out);
			InputStreamReader temp = new InputStreamReader(in);
			br = new BufferedReader(temp);
			
			rThread = new ReceiveThread(this);
			rThread.start();
		}
		catch(Exception e) {
			//	�� ���α׷��� ��Ʈ��ũ�� �ȵǴ� ���α׷��� �ȴ�.
			close();
		}
	}
	//	���α׷��� �����ϱ� ���� �Լ�
	void close() {
		//	����ϴ� �ڿ� �ݰ�
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
	//	x ���� ������ ���α׷��� �����ϱ� ���� �̺�Ʈ ��ġ�� �Ѵ�.
	class FrameEvent extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			close();
		}
	}
}

/*
 * 	�ΰ��� ȭ���� �ʿ��ϹǷ� ������ ȭ���� ����� Ŭ������ ���� ������.
 */
class RoomPanel extends JPanel {
	ChatClient01	main;
	JTextField		nickF;
	//	���� 3���� ���ϰ� �޺����ڷ� �����ϵ��� �� �����̴�.
	JComboBox		roomB;
	JButton			nickBtn, roomBtn;
	public RoomPanel(ChatClient01 m) {
		main = m;
		nickF = new JTextField();
		roomB = new JComboBox();
		roomB.setEnabled(false);
		roomB.addItem("�ڹ� ��");
		roomB.addItem("JSP ��");
		roomB.addItem("Web ��");
		
		nickBtn = new JButton("�г�������");
		roomBtn = new JButton("�� �� ��");
		ButtonEvent	evt = new ButtonEvent();
		nickBtn.addActionListener(evt);
		roomBtn.addActionListener(evt);
		
		JLabel	nickL = new JLabel("�г���");
		JLabel	roomL = new JLabel("�漱��");
		
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
		//	����
		//	1.	�ؽ�Ʈ �ʵ忡 �Էµ� �г����� �˾Ƴ���.
		String	nick = nickF.getText();
		//	2.	����� ���� ���������� ���δ�.
		nick = "1101" + nick;
		//	3.	������ ������.
		//		��Ʈ���� �̿��ؼ� �������ϴµ�... ��Ʈ����
		//		���� Ŭ������ �������ִ�.
		main.pw.println(nick);
		main.pw.flush();
	}
	void roomProc() {
		//	����
		//		������ ���� �˾Ƴ���.
		String	room = (String)roomB.getSelectedItem();
		//		���������� ���δ�.
		room = "1201" + room;
		//		�������� ������.
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
		exitB = new JButton("�� �� ��");
		sendB = new JButton("��ȭ�ϱ�");
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
		//	����
		//		�ؽ�Ʈ �ʵ忡 �Է��� ��ȭ ���� �˾Ƴ���
		String	text = field.getText();
		if(text == null || text.length() == 0) {
			return;
		}
		//		�������� �ٿ���
		text = "1301" + text;
		//		������ ������.
		main.pw.println(text);
		main.pw.flush();
	}
	
	void exitProc() {
		//	����
		//		���̸��� �˾Ƴ���
		String	room = (String) main.roomP.roomB.getSelectedItem();
		//		�������� �ٿ���
		room = "1202" + room;
		//		������ ������.
		main.pw.println(room);
		main.pw.flush();
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	�� �Լ��� ����Ǵ� ���
			//		�ؽ�Ʈ�ʵ忡�� ����Ű, ������ ���� Ŭ��,
			//		������ ���� ���� ���
			//	��ó�� �� �Լ��� �������� Ŭ������ ����ϴ� ���
			//	1.	Object �� �޾ƶ�
			Object	target = e.getSource();
			//	2.	instanceof �� �̿��ؼ� ���� ó���ϼ���
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
 * 	�ޱ⸸ ���ִ� ���� ���α׷��� ���� ������
 */
class ReceiveThread extends Thread {
	ChatClient01	main;
	public ReceiveThread(ChatClient01 m) {
		main = m;
	}
	public void run() {
		try {
			//	��� �ݺ��ؼ� �޾ƾ� ���� �𸣹Ƿ�....
			while(true) {
				String	msg = main.br.readLine();
				//	�޾Ҵµ� ������ ������... ������ �߸��Ǿ
				//	�߸� �������̴�.
				if(msg == null || msg.length() == 0) {
					//	�� ���α׷� �󾲴� ���α׷��̴�.
					break;
				}
				//	�޾�����....
				//	����
				//		1.	���������� �м��Ѵ�.
				//			�츮�� ó�� 4���ڰ� ���������̴�.
				String	protocol = msg.substring(0, 4);
				int		intP = Integer.parseInt(protocol);
				msg = msg.substring(4);
				//		2.	������ �������ݿ� �´� �۾��� �����Ѵ�.
				switch(intP) {
				case	2101:	//	�г��� ����
					//	����
					//		1.	���� ������ �� �ֵ��� ������.
					main.roomP.roomB.setEnabled(true);
					break;
				case	2201:	//	������ ����
					//	����
					//		1.	ȭ���� ä�ù����� �ٲ��ش�.
					String	room = (String) main.roomP.roomB.getSelectedItem();
					main.frame.setTitle("[" + room + "] ���Դϴ�.");
					main.card.show(main.mainP, "Chat");
					break;
				case	2202:	//	������ ����
					//	����
					//		1.	���ݱ��� ä���� ������ �����
					main.chatP.area.setText("");
					//		2.	ȭ���� �漱�� ȭ������ �ٲ۴�.
					main.frame.setTitle("[����]�Դϴ�.");
					main.card.show(main.mainP, "Room");
					break;
				case	2301:	//	ä�� ����
					//	����
					//		ȭ�鿡 ������ ����Ѵ�
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