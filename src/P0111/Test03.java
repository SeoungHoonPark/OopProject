package P0111;
/*
 * 		����			����
		������			����	����
		�����ϱ�				�ʷ�
		�ҷ�����				�Ķ�
		-------			�۲�	ũ��
		�����ϱ�				�۰�

 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
public class Test03 {
	public Test03() {
		MyJFrame	f = new MyJFrame();
		//	�޴��� ��ġ�������� ���谡 ����.
		JMenuItem newM = new JMenuItem("������");
		JMenuItem openM = new JMenuItem("�ҷ�����");
		JMenuItem saveM = new JMenuItem("�����ϱ�");
		JMenuItem exitM = new JMenuItem("�����ϱ�");
		//	���� �����ϱ� �޴��� x Ű�� ����Ű�� ����ϰ��� �Ѵ�.
		//	1.	KeyStroke	�� �̿��ؼ� ����� ����Ű�� �����.
		//		x Ű�� ����Ű�� ���
//		KeyStroke	stroke = KeyStroke.getKeyStroke('x');
		//		 Ctrl + x Ű�� ����Ű�� ���
//		KeyStroke	stroke = 
//		KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
		//		 Ctrl + Alt + x Ű�� ����Ű�� ���
		KeyStroke	stroke = 
		KeyStroke.getKeyStroke(KeyEvent.VK_X, 
				ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK);
		//	2.	setAccelerator()�� �̿��ؼ� ����Ű�� ����Ѵ�.
		exitM.setAccelerator(stroke);
		
		JMenuItem redM = new JMenuItem("������");
		JMenuItem greenM = new JMenuItem("�ʷϻ�");
		JMenuItem blueM = new JMenuItem("�Ķ���");
		JMenuItem largeM = new JMenuItem("ũ��");
		JMenuItem smallM = new JMenuItem("�۰�");
		
		MenuEvent	evt = new MenuEvent();
		exitM.addActionListener(evt);
		
		
		JMenu	fileM = new JMenu("����");
		JMenu	editM = new JMenu("����");
		JMenu	colorM = new JMenu("����");
		JMenu	fontM = new JMenu("�۲�");
		
		fileM.add(newM);
		fileM.add(saveM);
		fileM.add(openM);
		fileM.addSeparator();
		fileM.add(exitM);
		editM.add(colorM);
		editM.add(fontM);
		colorM.add(redM);
		colorM.add(greenM);
		colorM.add(blueM);
		fontM.add(largeM);
		fontM.add(smallM);
		
		JMenuBar	bar = new JMenuBar();
		bar.add(fileM);
		bar.add(editM);
		
		f.setJMenuBar(bar);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Test03();
	}
	
	class MenuEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//		����޴����� �̺�Ʈ�� �߻��ߴ��� �˾Ƴ���
//			JMenuItem	target = (JMenuItem) e.getSource();
			//		�����ؼ� ó������.
//			if(target == ????) {
			System.exit(0);
//			}
		}
	}
}





