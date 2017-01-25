package P0125;

import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
public class ReceiveDlg {
	JJokJi		main;
	JTextField	field;
	JTextArea	area;
	JButton		reB, closeB;
	JFrame		frame;

	public ReceiveDlg(JJokJi m) {
		main = m;
		frame = new JFrame("쪽지 쓰기");
		field = new JTextField();
		area = new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		reB 	= new JButton("답장하기");
		closeB 	= new JButton("닫    기");
		
		reB.addActionListener(new ButtonEvent());
		closeB.addActionListener(new ButtonEvent());
		
		JLabel	label = new JLabel("보낸 사람");
		JPanel	p1 = new JPanel(new BorderLayout());
		p1.add("West", label);
		p1.add("Center", field);
		
		JPanel	p2 = new JPanel();
		p2.add(reB);
		p2.add(closeB);
		
		frame.add("North", p1);
		frame.add("Center", sp);
		frame.add("South", p2);

		frame.setSize(400, 300);
//		frame.setVisible(true);
	}
	
	class ButtonEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton target = (JButton) e.getSource();
			if(target == reB){
				// 보내기 대화상자를 만들어주고
				// 자신을 닫아준다.
				
				String name= field.getText();
				SendDlg dlg = new SendDlg(main);
				dlg.field.setText(name);
				dlg.frame.setVisible(true);
				
				frame.setVisible(false);
				frame.dispose();				
			}else{
				frame.setVisible(false);
				frame.dispose();
			}
		}
		
	}
}
