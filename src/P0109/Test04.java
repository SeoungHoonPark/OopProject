package P0109;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;

import GUI.MyJFrame;

/**
 *		화면위에 진행바를 만들고, 아래쪽에 단추를 만든다.
 *		단추르르 누르면 파일을 복사한다고 가정하고, 
 *		파일의 복사 진행 정보를 진행바에 표시하도록 하자.
 */
public class Test04 {
	JProgressBar bar;
	
	public Test04() {
		MyJFrame f = new MyJFrame();
		
		bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		// %정도도 출력하고자 한다.
		// bar.setStringPainted(true);
		
		// 바깥테두리를 진하게 칠하고 싶다.
		// bar.setBorderPainted(true);
		JButton btn = new JButton("복사 시작");
		
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
			// 아래쪽에 있는 스레드를 기동시켜만 주면 된다.
			
			CopyThread t = new CopyThread(Test04.this);
			t.start();			
		}
	}
}

// 파일을 복사하는 과정은 메인 폼과 독립적으로 진행해야 한다.
// 왜냐하면 파일을 복사하는 도중 다른 작업도 진행해야 하기 때문이다.
// 이처럼 두가지 작업이 변행되어서 처리해야 할 필요가 있으면... 이대 사용하는 기법이 스레드 기법이다.

class CopyThread extends Thread{
	
	Test04 t04;
	
	public CopyThread(Test04 t) {
		t04 = t;
	}
	
	@Override
	public void run() {
		// 이 안에서 파일을 복사한다.
			for(int i = 0; i <= 100; i++){
				// 0%에서 100%까지 복사를 한다고 가정하자
				// 이제 복사되는 도중에 복사된 비율을 메인의 진행바에 표시해야 한다.
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
