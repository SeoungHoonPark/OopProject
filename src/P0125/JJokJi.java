package P0125;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * 쪽지 보내기; udp통신
 */
public class JJokJi {
	// 이름을 알면 주소를 찾아내기 위한 map
	HashMap nameToIp, ipToName;
	
	// 주소를 알면 이름을 찾아내기 위한 map	
	JList list;
	JButton sendB;
	JFrame frame;
	
	DatagramSocket sSocket, rSocket;
	// sSocket은 쪽지를 보내기 위한 소켓
	// rSocket은 쪽지를 받기 위한 소켓
	
	// 참고로 
	// 받드시 2개를 만들어야 하는 것은 아니다.
	// 소켓 하나만 가지고도 보내기와 받기를 할 수 있다.
	// 다만, 이경우에는 보내는 도중에는 받지를 못할 수 있다.
	// 그래서 안전한 통신을 위해서 보내는 소켓과 받는 소켓을 구분해 처리하는 것이 좋다(권고 사항)
	
	public JJokJi() {
		setMap();
		
		frame = new JFrame("쪽지 프로그램");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				close();
			}
		});
		
		// 목록 상자안에 친구 이름을 기록하기로 했으므로
		// map에서 친구이름만 찾아서 넣어놓자
		Set temp = nameToIp.keySet();
		Vector v = new Vector(temp);
		
		list = new JList(v);
		
		JScrollPane sp = new JScrollPane(list);
		sendB = new JButton("쪽지쓰기");
		sendB.addActionListener(new ButtonEvent());
		frame.add("Center", sp);
		frame.add("South", sendB);
		
		frame.setSize(200, 200);
		frame.setVisible(true);		
		
		// 이제 프로그램이 시작되었으므로, 네트워크 구성을 할 차례이다.
		// udp 통신이 므로 DatagramSocket을 이용해서 네트웤을 구성할 예정이다.
		
		try{
			sSocket = new DatagramSocket();
			rSocket = new DatagramSocket(9999);
			// 이렇게 하면 누군가에 접속을 하는 것이 아니고 다만 
			// 네트윀 회선에만 접속을 한 상태가 된다.
			// 즉, 네트워크가 가능하도록만 해주는 것이다.
			
			// 이제 네트워크 구성이 완료되었으므로 
			// 쪽지를 보내고 받을 수 있다. 고로 받는 프로그램을 시작하자.
			
			ReceiveThread t = new ReceiveThread(this);
			t.start();
			
		}catch(Exception e){
			close();
		}
	}
	
	void close(){
		try{
			sSocket.close();
			rSocket.close();
		}catch(Exception e){
			System.exit(0);
		}
	}
	
	void setMap(){
		nameToIp = new HashMap();
		nameToIp.put("권수정", "192.168.35.87");
		nameToIp.put("김민아", "192.168.35.77");
		nameToIp.put("김용민", "192.168.35.81");
		nameToIp.put("류수진", "192.168.35.79");
		nameToIp.put("박승훈", "192.168.35.72");
		nameToIp.put("박진관", "192.168.35.64");
		nameToIp.put("윤병진", "192.168.35.82");
		nameToIp.put("윤준하", "192.168.35.78");
		nameToIp.put("이태규", "192.168.35.63");
		nameToIp.put("김예송", "192.168.35.55");
		nameToIp.put("이희훈", "192.168.35.70");
		nameToIp.put("전은석", "192.168.35.101");
		nameToIp.put("정모세", "192.168.35.73");
		nameToIp.put("오송록", "192.168.35.75");
		nameToIp.put("김명환", "192.168.35.92");
		
		ipToName = new HashMap();
		
		ipToName.put( "192.168.35.87","권수정");
		ipToName.put( "192.168.35.77","김민아");
		ipToName.put( "192.168.35.81","김용민");
		ipToName.put( "192.168.35.79","류수진");
		ipToName.put( "192.168.35.72","박승훈");
		ipToName.put( "192.168.35.64","박진관");
		ipToName.put( "192.168.35.82","윤병진");
		ipToName.put( "192.168.25.78","윤준하");
		ipToName.put( "192.168.35.63","이태규");
		ipToName.put( "192.168.35.55","김예송");
		ipToName.put( "192.168.35.70","이희훈");
		ipToName.put( "192.168.35.101","전은석");
		ipToName.put( "192.168.35.73","정모세");
		ipToName.put( "192.168.35.75","오송록");
		ipToName.put( "192.168.35.92","김명환");
	}
	
	public static void main(String[] args) {
		new JJokJi();
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 목록상자에서 선택한 이름을 알아낸다.
			String name = (String) list.getSelectedValue();
			if(name == null || name.length() == 0){
				return;
			}
			
			//  보내기 위한 대화상자를 new시킨다.
			SendDlg dlg  = new SendDlg(JJokJi.this);
			dlg.field.setText(name);
			dlg.frame.setVisible(true);			
		}
	}
}
