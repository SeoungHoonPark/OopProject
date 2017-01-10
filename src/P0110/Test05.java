package P0110;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.MyJFrame;

/**
 *	���߸� ������ �������� �ɼ� ��ȭ���ڸ� ȭ�鿡 ����� ����
 */
public class Test05 {
	MyJFrame f;

	public Test05() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		JButton btn = new JButton("��������");
		btn.addActionListener(new ButtonEvent());
		f.add(btn);
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Test05();
	}
	// ConfirmDialog�� ȭ�鿡 ����ϴ� �Լ�
	void displayConfirm(){
		// 1. �⺻
		//JOptionPane.showConfirmDialog(f, "�����ϰڽ��ϱ�?");
		// 2.	���̾˷α��� ���¸� �����Ѵ�.
//		JOptionPane.showConfirmDialog(f, "�����ϰڽ��ϱ�?",	"����Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION);
		// 3. ���� ������ ������ ����� �����Ѵ�.
//		JOptionPane.showConfirmDialog(f, "�����ϰڽ��ϱ�?",	"����Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		// 4. ���� ������ ������ ����� ����ڰ� ���� ����Ѵ�.
		ImageIcon icon = new ImageIcon("src/P0110/wavy.gif");
		int re = JOptionPane.showConfirmDialog(f, "�����ϰڽ��ϱ�?",	"����Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
		// �� ��ȭ���ڸ� �����ִ� ������ ����ڰ� ������ �����϶�� �ǹ��̴�.
		// ���ÿ� ���� � �۾��� �����ؾ� �� ���̴�.
		// �� �Լ��� ��ȯ���� int�ε�.. �̰��� �ǹ̴� ������ ������ ������ �ǹ��Ѵ�.
		
		if(re == JOptionPane.YES_OPTION){
			// �� ����
			System.out.println("�� ����");
		}else if(re == JOptionPane.NO_OPTION){
			// Ȯ�� ����
			System.out.println("Ȯ�� ����");
		}else if(re == JOptionPane.CANCEL_OPTION){
			// ��� ����
			
		}else if(re == JOptionPane.CLOSED_OPTION){
			// ����[x] ����
			System.out.println("�׳� ����");
		}
	}
	// InPutDialog()
	void displayInput(){
		// 1. �⺻
//		JOptionPane.showInputDialog(f,	"�̸��� ������");
		//	2. �ʱ��Է°�
//		JOptionPane.showInputDialog(f,	"�̸��� ������", "����");
		// 3. skip
		//	4. �޺����ڸ� �̿��ؼ� �����ϵ��� �ϱ� ���ؼ� �غ�� �׸��� �迭�� �ִ´�.
		String[]  str = {"���ϴ�","�����","������","������","������"};		
		String name = (String) JOptionPane.showInputDialog(f,	"�̸��� ������", "�̸� Ȯ��", JOptionPane.INFORMATION_MESSAGE, null,str, "������");
		
		// �� ��ȭ���ڸ� �����ִ� ������ ������ �Է��� �޶�� ���̰�, �� ������ ���α׷����� �̿��ϱ� ���ؼ� �Է� �޴� ���̴�.
		if(name == null || name.length() == 0){	// if(Object.isNull(name))
			// �� ���ڿ��� �Էµ��� ������ �˾ƺ��� ���
			System.out.println("�Էµ��� �ʾҽ��ϴ�.");
			// �� �κ��� Ȯ�� ���߸� ������ �ʾ��� ����̴�.
		}else{
			System.out.println("��� �̸��� = " + name);
		}
	}
	
	// �޼��� ���̾˷α�
	void displayMessage(){
		
	}
	
	void displayOption(){
		String[] title = {"�̿��ִ���","����������","����������"};
		int re = JOptionPane.showOptionDialog(f, "����� ����", "��ȭ��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, title, title[0]);
		// �̿��� ���� ���߰� �߿��ϴ�. ������ ������ ������ �ٲٴ��� ������
		//	ConfirmDialog�̹Ƿ� ������ ���߸� �˾к��� ����� ConfirmDialog�� �����ϴ�
		if(re == JOptionPane.YES_OPTION){
			// �� ����
			System.out.println("�� ����");
		}else if(re == JOptionPane.NO_OPTION){
			// Ȯ�� ����
			System.out.println("Ȯ�� ����");
		}else if(re == JOptionPane.CANCEL_OPTION){
			// ��� ����
			
		}else if(re == JOptionPane.CLOSED_OPTION){
			// ����[x] ����
			System.out.println("�׳� ����");
		}
		
	}
	class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//displayConfirm();
			//displayInput();
			//displayMessage();
			displayOption();
		}
	}
}
