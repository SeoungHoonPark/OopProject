package P0109;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import GUI.MyJFrame;

/**
 *		ȭ������ ����ٸ� �����, �Ʒ��ʿ� ���߸� �����.
 *		���߸��� ������ ������ �����Ѵٰ� �����ϰ�, 
 *		������ ���� ���� ������ ����ٿ� ǥ���ϵ��� ����.
 */
public class Test04 {
	JProgressBar bar;
	
	public Test04() {
		MyJFrame f = new MyJFrame();
		
		bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		// %������ ����ϰ��� �Ѵ�.
		// bar.setStringPainted(true);
		
		// �ٱ��׵θ��� ���ϰ� ĥ�ϰ� �ʹ�.
		// bar.setBorderPainted(true);
		JButton btn = new JButton("���� ����");
		
		f.add("North", bar);
		f.add("South", btn);
		
		f.setSize(400,400);
		f.setVisible(true);
		
		btn.addActionListener(new ButtonEvent());
	}

	public static void main(String[] args) {
		new Test04();

	}
	
	class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// �Ʒ��ʿ� �ִ� �����带 �⵿���Ѹ� �ָ� �ȴ�.
			
			CopyThread t = new CopyThread(Test04.this);
			t.start();			
		}
	}
}

// ������ �����ϴ� ������ ���� ���� ���������� �����ؾ� �Ѵ�.
// �ֳ��ϸ� ������ �����ϴ� ���� �ٸ� �۾��� �����ؾ� �ϱ� �����̴�.
// ��ó�� �ΰ��� �۾��� ����Ǿ ó���ؾ� �� �ʿ䰡 ������... �̴� ����ϴ� ����� ������ ����̴�.

class CopyThread extends Thread{
	
	Test04 t04;
	
	public CopyThread(Test04 t) {
		t04 = t;
	}
	
	@Override
	public void run() {
		// �� �ȿ��� ������ �����Ѵ�.
			for(int i = 0; i <= 100; i++){
				// 0%���� 100%���� ���縦 �Ѵٰ� ��������
				// ���� ����Ǵ� ���߿� ����� ������ ������ ����ٿ� ǥ���ؾ� �Ѵ�.
				t04.bar.setValue(i);				
				try{
					Thread.sleep(200);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		super.run();
	}
}
// 
