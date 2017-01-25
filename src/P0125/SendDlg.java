package P0125;

import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
public class SendDlg {
	JJokJi		main;
	JTextField	field;
	JTextArea	area;
	JButton		sendB, resetB, closeB;
	JFrame		frame;
	public SendDlg(JJokJi m) {
		main = m;
		frame = new JFrame("���� ����");
		field = new JTextField();
		area = new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		sendB 	= new JButton("����������");
		resetB 	= new JButton("�ٽ�  ����");
		closeB 	= new JButton("��      ��");
		
		sendB.addActionListener(new ButtonEvent());
		resetB.addActionListener(new ButtonEvent());
		closeB.addActionListener(new ButtonEvent());
		
		JLabel	label = new JLabel("�޴� ���");
		JPanel	p1 = new JPanel(new BorderLayout());
		p1.add("West", label);
		p1.add("Center", field);
		
		JPanel	p2 = new JPanel();
		p2.add(sendB);
		p2.add(resetB);
		p2.add(closeB);
		
		frame.add("North", p1);
		frame.add("Center", sp);
		frame.add("South", p2);
		
		frame.setSize(400, 300);
		//	�� ȭ���� �ʿ��� ���� ������������
		//	���߿� �ʿ��Ҷ� ���̵��� �� �����̴�.
//		frame.setVisible(true);
	}
	void sendProc(){
		//����
		// ���� ������ �˾Ƴ���
		String msg = area.getText();
		byte[] buff = msg.getBytes();
		// ���� �ּҸ� �˾Ƴ���	--> �츮�� �̰��� ���ؼ� �̸��� �˸� �ּҸ� ���� �� �ֵ��� ���� �غ��ߴ�
		String name = field.getText();
		String ip = (String) main.nameToIp.get(name);		
		InetAddress inet = null;
		try{
			inet = InetAddress.getByName(ip);
		}catch(Exception e){
		}
		// �̰��� ��Ŷ���� ������ ��
		DatagramPacket pack = new DatagramPacket(buff, buff.length, inet, 9999);
		// ��Ʈ��ũ�� ��������� �ȴ�.
		try {
			main.sSocket.send(pack);
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setVisible(false);
		frame.dispose();
	}
	class ButtonEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton target = (JButton) e.getSource();
			
			if(target == sendB){
				sendProc();
			}else if(target == resetB){
				area.setText("");
			}else{
				frame.setVisible(false);
				frame.dispose();// ���Լ��� �޸𸮿����� �����޶�� ����̴�.
				
			}
		}
		
	}
}


