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
 * ���� ������; udp���
 */
public class JJokJi {
	// �̸��� �˸� �ּҸ� ã�Ƴ��� ���� map
	HashMap nameToIp, ipToName;
	
	// �ּҸ� �˸� �̸��� ã�Ƴ��� ���� map	
	JList list;
	JButton sendB;
	JFrame frame;
	
	DatagramSocket sSocket, rSocket;
	// sSocket�� ������ ������ ���� ����
	// rSocket�� ������ �ޱ� ���� ����
	
	// ����� 
	// �޵�� 2���� ������ �ϴ� ���� �ƴϴ�.
	// ���� �ϳ��� ������ ������� �ޱ⸦ �� �� �ִ�.
	// �ٸ�, �̰�쿡�� ������ ���߿��� ������ ���� �� �ִ�.
	// �׷��� ������ ����� ���ؼ� ������ ���ϰ� �޴� ������ ������ ó���ϴ� ���� ����(�ǰ� ����)
	
	public JJokJi() {
		setMap();
		
		frame = new JFrame("���� ���α׷�");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				close();
			}
		});
		
		// ��� ���ھȿ� ģ�� �̸��� ����ϱ�� �����Ƿ�
		// map���� ģ���̸��� ã�Ƽ� �־����
		Set temp = nameToIp.keySet();
		Vector v = new Vector(temp);
		
		list = new JList(v);
		
		JScrollPane sp = new JScrollPane(list);
		sendB = new JButton("��������");
		sendB.addActionListener(new ButtonEvent());
		frame.add("Center", sp);
		frame.add("South", sendB);
		
		frame.setSize(200, 200);
		frame.setVisible(true);		
		
		// ���� ���α׷��� ���۵Ǿ����Ƿ�, ��Ʈ��ũ ������ �� �����̴�.
		// udp ����� �Ƿ� DatagramSocket�� �̿��ؼ� ��Ʈ�p�� ������ �����̴�.
		
		try{
			sSocket = new DatagramSocket();
			rSocket = new DatagramSocket(9999);
			// �̷��� �ϸ� �������� ������ �ϴ� ���� �ƴϰ� �ٸ� 
			// ��Ʈ�� ȸ������ ������ �� ���°� �ȴ�.
			// ��, ��Ʈ��ũ�� �����ϵ��ϸ� ���ִ� ���̴�.
			
			// ���� ��Ʈ��ũ ������ �Ϸ�Ǿ����Ƿ� 
			// ������ ������ ���� �� �ִ�. ��� �޴� ���α׷��� ��������.
			
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
		nameToIp.put("�Ǽ���", "192.168.35.87");
		nameToIp.put("��ξ�", "192.168.35.77");
		nameToIp.put("����", "192.168.35.81");
		nameToIp.put("������", "192.168.35.79");
		nameToIp.put("�ڽ���", "192.168.35.72");
		nameToIp.put("������", "192.168.35.64");
		nameToIp.put("������", "192.168.35.82");
		nameToIp.put("������", "192.168.35.78");
		nameToIp.put("���±�", "192.168.35.63");
		nameToIp.put("�迹��", "192.168.35.55");
		nameToIp.put("������", "192.168.35.70");
		nameToIp.put("������", "192.168.35.101");
		nameToIp.put("����", "192.168.35.73");
		nameToIp.put("���۷�", "192.168.35.75");
		nameToIp.put("���ȯ", "192.168.35.92");
		
		ipToName = new HashMap();
		
		ipToName.put( "192.168.35.87","�Ǽ���");
		ipToName.put( "192.168.35.77","��ξ�");
		ipToName.put( "192.168.35.81","����");
		ipToName.put( "192.168.35.79","������");
		ipToName.put( "192.168.35.72","�ڽ���");
		ipToName.put( "192.168.35.64","������");
		ipToName.put( "192.168.35.82","������");
		ipToName.put( "192.168.25.78","������");
		ipToName.put( "192.168.35.63","���±�");
		ipToName.put( "192.168.35.55","�迹��");
		ipToName.put( "192.168.35.70","������");
		ipToName.put( "192.168.35.101","������");
		ipToName.put( "192.168.35.73","����");
		ipToName.put( "192.168.35.75","���۷�");
		ipToName.put( "192.168.35.92","���ȯ");
	}
	
	public static void main(String[] args) {
		new JJokJi();
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ��ϻ��ڿ��� ������ �̸��� �˾Ƴ���.
			String name = (String) list.getSelectedValue();
			if(name == null || name.length() == 0){
				return;
			}
			
			//  ������ ���� ��ȭ���ڸ� new��Ų��.
			SendDlg dlg  = new SendDlg(JJokJi.this);
			dlg.field.setText(name);
			dlg.frame.setVisible(true);			
		}
	}
}
