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
		frame = new JFrame("쪽지 쓰기");
		field = new JTextField();
		area = new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		sendB 	= new JButton("쪽지보내기");
		resetB 	= new JButton("다시  쓰기");
		closeB 	= new JButton("닫      기");
		
		sendB.addActionListener(new ButtonEvent());
		resetB.addActionListener(new ButtonEvent());
		closeB.addActionListener(new ButtonEvent());
		
		JLabel	label = new JLabel("받는 사람");
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
		//	이 화면은 필요한 순간 보여야함으로
		//	나중에 필요할때 보이도록 할 예정이다.
//		frame.setVisible(true);
	}
	void sendProc(){
		//할일
		// 보낼 내용을 알아내고
		String msg = area.getText();
		byte[] buff = msg.getBytes();
		// 상대방 주소를 알아내고	--> 우리는 이것을 위해서 이름을 알면 주소를 얻을 수 있도록 맵을 준비했다
		String name = field.getText();
		String ip = (String) main.nameToIp.get(name);		
		InetAddress inet = null;
		try{
			inet = InetAddress.getByName(ip);
		}catch(Exception e){
		}
		// 이것을 패킷으로 포장한 후
		DatagramPacket pack = new DatagramPacket(buff, buff.length, inet, 9999);
		// 네트워크상에 흘려보내면 된다.
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
				frame.dispose();// 이함수는 메모리에서도 지워달라는 명령이다.
				
			}
		}
		
	}
}


