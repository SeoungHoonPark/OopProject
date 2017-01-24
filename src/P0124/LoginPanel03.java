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
			//	할일
			//	1	id와 비밀번호를 알아낸다.
			String	id = idF.getText();
			char[]	tempPW = pwF.getPassword();
			String	pw = new String(tempPW, 0, tempPW.length);
			//	2	이것을 서버에 보낸다.
			//		데이터 클래스로 묶는다.
			//		1)	MainData를 생성하고(필수)
			MainData	mainD = new MainData();
			//		2)	작업 Data를 생성한다.(선택)
			LoginData	loginD = new LoginData();
			//		3)	필요한 데이터를 넣고
			mainD.protocol = 1101;
			loginD.id = id;
			loginD.pw = pw;
			//		4)	MainData에 묶어준다.
			mainD.loginD = loginD;
			
			//	서버에 보낸다.	서버에 보낼때는 스트림이 필요한ㄴ데
			//	스트림은 메인 클래스가 가지고있다.
			try {
				main.oout.writeObject(mainD);
			}
			catch(Exception e1) {}
		}
	}
}

