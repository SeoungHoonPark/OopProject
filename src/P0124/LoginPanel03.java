package P0124;
import	NETData.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
public class LoginPanel03 extends JPanel {
	ChatClient03	main;
	JTextField		idF;
	JPasswordField	pwF;
	JButton			loginB;
	public LoginPanel03(ChatClient03 m) {
		main = m;
		this.setLayout(new BorderLayout());
		
		JLabel	idL = new JLabel("ID");
		JLabel	pwL = new JLabel("Password");
		idF = new JTextField();
		pwF = new JPasswordField();
		loginB = new JButton(" LOGIN ");
		loginB.addActionListener(new ButtonEvent());
		JPanel	p1 = new JPanel(new GridLayout(2, 1));
		p1.add(idL);
		p1.add(pwL);
		JPanel	p2 = new JPanel(new GridLayout(2, 1));
		p2.add(idF);
		p2.add(pwF);
		
		JPanel	p3 = new JPanel(new BorderLayout());
		p3.add("West", p1);
		p3.add("Center", p2);
		p3.add("East", loginB);
		
		this.add("South", p3);
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//	1	id�� ��й�ȣ�� �˾Ƴ���.
			String	id = idF.getText();
			char[]	tempPW = pwF.getPassword();
			String	pw = new String(tempPW, 0, tempPW.length);
			//	2	�̰��� ������ ������.
			//		������ Ŭ������ ���´�.
			//		1)	MainData�� �����ϰ�(�ʼ�)
			MainData	mainD = new MainData();
			//		2)	�۾� Data�� �����Ѵ�.(����)
			LoginData	loginD = new LoginData();
			//		3)	�ʿ��� �����͸� �ְ�
			mainD.protocol = 1101;
			loginD.id = id;
			loginD.pw = pw;
			//		4)	MainData�� �����ش�.
			mainD.loginD = loginD;
			
			//	������ ������.	������ �������� ��Ʈ���� �ʿ��Ѥ���
			//	��Ʈ���� ���� Ŭ������ �������ִ�.
			try {
				main.oout.writeObject(mainD);
			}
			catch(Exception e1) {}
		}
	}
}

