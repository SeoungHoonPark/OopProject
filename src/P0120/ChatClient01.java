package P0120;
/*
 * 	ä���� �� �� �ִ� ���� �����ϰ�
 * 	ä�� ���α׷��� ������.
 * 
 * 	1.	�� �����.
 * 	2.	������ ������ �Ѵ�.(����غ�)
 * 	3.	����� �غ���.
 * 		1)	������ �����͸� ��������.
 * 		2)	���������� �����͸� �޾ƺ���.
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
	//	����� ���� ����(����, ��Ʈ��)
	Socket			socket;
	PrintWriter		pw;
	BufferedReader	br;
	//	ä���� �ܼ��� ���ڸ� �ְ� �޴� ������� ���� �����̴�.
	//	�׷��Ƿ� ������ ���ڸ� �ս��� �ְ� �ޱ� ���ؼ���....
	//		println()
	//		readLine()
	public ChatClient01() {
		JFrame	f = new JFrame("ä�� Ŭ���̾�Ʈ");
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

		//	���� ȭ���� �غ�Ǿ����Ƿ�....��� �غ� ����
		try {
			//	������ ������ �õ�����.
			socket = new Socket("192.168.35.92", 7788);
			//	����� ��Ʈ���� �غ��Ѵ�.
			InputStream		in = socket.getInputStream();
			OutputStream	out = socket.getOutputStream();
			pw = new PrintWriter(out);
			
			InputStreamReader	temp = new InputStreamReader(in);
			br = new BufferedReader(temp);
		}
		catch(Exception e) {
			//	���� �߻�
			//	�� ���α׷��� Ư¡�� �����ϸ� �ȵǴ� ���α׷�
			close();
		}
		//	��� �غ� �������Ƿ�... �����͸� ���� �غ� ����.
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
	//	���α׷��� �����Ű�� ���ؼ� x ���߸� ������ �̺�Ʈ��
	//	WindowListener�� ����ϰ�
	//	�� �ȿ� �ִ� windowClosing() �̶�� �Լ��� ó���� �Ѵ�.
	class FrameEvent extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			//	������ ������ ���߿� �ϰ�
			close();
		}
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	�� �Լ���
			//		���ߴ��� ���
			//		�ؽ�Ʈ �ʵ忡�� ����Ű ģ ���
			//		����Ʈ���� ���� Ŭ���� ���
			//		�޴��� ������ ���

			//	����
			//		�ؽ�Ʈ �ʵ��� ���� �˾Ƴ���
			String	msg = field.getText();
			if(msg == null || msg.length() == 0) {
				return;
			}
			//		�� ������ ������ ������ �ȴ�.
			pw.println(msg);
			pw.flush();
			
			field.setText("");
		}
	}
}
/*
 * 	������ �� �����͸� ���� ���α׷��� ���� �����.
 * 	�� ���α׷��� ������� ���� ���������� ����ǵ���
 * 	���־�� �Ѵ�.
 */
class ReceiveThread extends Thread {
	ChatClient01	main;
	public ReceiveThread(ChatClient01 m) {
		main = m;
	}
	public void run() {
		//	����
		//	�����͸� ����ؼ� ����
		try {
			//	������ ��� �����͸� ���� �𸣹Ƿ�....
			while(true) {
				//	������ ����
				//	��Ʈ���� �̿��ؼ� �޾ƾ� �Ѵ�.
				String	msg = main.br.readLine();
				if(msg == null || msg.length() == 0) {
					break;
				}
				//	���� ������ �������.
				main.area.append(msg + "\r\n");
				//	���� �����͸� ����� ��ġ�� ����
				//	�ؽ�Ʈ �������̴�.
				main.sp.getVerticalScrollBar().setValue(main.sp.getVerticalScrollBar().getMaximum());
			}
		}
		catch(Exception e) {
			//	�޴��ʿ��� ������ ����� �� ���α׷���
			//	�󾲴� ���α׷��̴�.
			main.close();
		}
	}
}
