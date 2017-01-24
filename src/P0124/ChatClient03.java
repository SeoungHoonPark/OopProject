package P0124;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import	java.io.*;
import	java.net.*;
public class ChatClient03 {
	JFrame				frame;
	JPanel				mainP;
	CardLayout			card;
	LoginPanel03		loginP;
	ChatPanel03			chatP;
	
	Socket				socket;
	ObjectInputStream	oin;
	ObjectOutputStream	oout;
	
	public ChatClient03() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		mainP = new JPanel();
		card = new CardLayout();
		mainP.setLayout(card);
		frame.add("Center", mainP);
		
		loginP 	= new LoginPanel03(this);
		chatP 	= new ChatPanel03(this);
		
		mainP.add("LOGIN", loginP);
		mainP.add("CHAT", chatP);
		
		frame.setSize(400, 600);
		frame.setVisible(true);
		
		//	���� ��Ʈ��ũ�� ��������.
		try {
			//	1.	������ ������ �õ��ϰ�
			socket = new Socket("192.168.35.92", 9988);
			//	2.	��Ʈ���� �����Ѵ�.
			//		1)	Ÿ�� ��Ʈ���� �ʼ�
			InputStream		in = socket.getInputStream();
			OutputStream	out = socket.getOutputStream();
			//		2)	���� ��Ʈ���� ����
			oout 	= new ObjectOutputStream(out);
			oin 	= new ObjectInputStream(in);
			//	3.	������ �ִ� ������ ���� �غ� �Ѵ�.
			ReceiveThread03	t = new ReceiveThread03(this);
			t.start();
		}
		catch(Exception e) {
			close();
		}
	}
	void close() {
		try {
			oin.close();
			oout.close();
			socket.close();
		}
		catch(Exception e) {
		}
		finally {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new ChatClient03();
	}
}

