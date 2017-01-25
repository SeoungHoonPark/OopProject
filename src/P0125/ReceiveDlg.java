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
		frame = new JFrame("���� ����");
		field = new JTextField();
		area = new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		reB 	= new JButton("�����ϱ�");
		closeB 	= new JButton("��    ��");
		
		reB.addActionListener(new ButtonEvent());
		closeB.addActionListener(new ButtonEvent());
		
		JLabel	label = new JLabel("���� ���");
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
				// ������ ��ȭ���ڸ� ������ְ�
				// �ڽ��� �ݾ��ش�.
				
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
