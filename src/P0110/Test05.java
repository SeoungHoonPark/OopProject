package P0110;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.MyJFrame;

/**
 *	단추를 누르면 여러가지 옵션 대화상자를 화면에 출력해 보자
 */
public class Test05 {
	MyJFrame f;

	public Test05() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		JButton btn = new JButton("누르세요");
		btn.addActionListener(new ButtonEvent());
		f.add(btn);
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Test05();
	}
	// ConfirmDialog를 화면에 출력하는 함수
	void displayConfirm(){
		// 1. 기본
		//JOptionPane.showConfirmDialog(f, "저장하겠습니까?");
		// 2.	아이알로그의 형태를 지정한다.
//		JOptionPane.showConfirmDialog(f, "저장하겠습니까?",	"저장확인", JOptionPane.YES_NO_CANCEL_OPTION);
		// 3. 옆에 나오는 아이콘 모양을 지정한다.
//		JOptionPane.showConfirmDialog(f, "저장하겠습니까?",	"저장확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		// 4. 옆에 나오는 아이콘 모양을 사용자가 만들어서 사용한다.
		ImageIcon icon = new ImageIcon("src/P0110/wavy.gif");
		int re = JOptionPane.showConfirmDialog(f, "저장하겠습니까?",	"저장확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
		// 이 대화상자를 보여주는 이유가 사용자가 뭔가를 선택하라는 의미이다.
		// 선택에 따라서 어떤 작업을 진행해야 할 것이다.
		// 이 함수의 반환값이 int인데.. 이것의 의미는 눌러진 단추의 종류를 의미한다.
		
		if(re == JOptionPane.YES_OPTION){
			// 예 단추
			System.out.println("예 단추");
		}else if(re == JOptionPane.NO_OPTION){
			// 확인 단추
			System.out.println("확인 단추");
		}else if(re == JOptionPane.CANCEL_OPTION){
			// 취소 단추
			
		}else if(re == JOptionPane.CLOSED_OPTION){
			// 종료[x] 단추
			System.out.println("그냥 단추");
		}
	}
	// InPutDialog()
	void displayInput(){
		// 1. 기본
//		JOptionPane.showInputDialog(f,	"이름이 뭔가요");
		//	2. 초기입력값
//		JOptionPane.showInputDialog(f,	"이름이 뭔가요", "무명씨");
		// 3. skip
		//	4. 콤보상자를 이용해서 선택하도록 하기 위해서 준비된 항목을 배열로 넣는다.
		String[]  str = {"김하늘","김아중","송혜교","아이유","김유정"};		
		String name = (String) JOptionPane.showInputDialog(f,	"이름이 뭔가요", "이름 확인", JOptionPane.INFORMATION_MESSAGE, null,str, "아이유");
		
		// 이 대화상자를 보여주는 이유가 뭔가를 입력해 달라는 것이고, 그 내용을 프로그램에서 이용하기 위해서 입력 받는 것이다.
		if(name == null || name.length() == 0){	// if(Object.isNull(name))
			// 팁 문자열이 입력되지 않음을 알아보는 방법
			System.out.println("입력되지 않았습니다.");
			// 이 부분은 확인 단추를 누르지 않았을 경우이다.
		}else{
			System.out.println("당신 이름은 = " + name);
		}
	}
	
	// 메세지 다이알로그
	void displayMessage(){
		
	}
	
	void displayOption(){
		String[] title = {"이영애단추","전도현단추","김혜수단추"};
		int re = JOptionPane.showOptionDialog(f, "뭐라고 쓴다", "대화상자제목", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, title, title[0]);
		// 이역시 선택 단추가 중요하다. 문제는 단추의 제목을 바꾸더라도 내용은
		//	ConfirmDialog이므로 선택한 단추를 알압보는 방법도 ConfirmDialog와 동일하다
		if(re == JOptionPane.YES_OPTION){
			// 예 단추
			System.out.println("예 단추");
		}else if(re == JOptionPane.NO_OPTION){
			// 확인 단추
			System.out.println("확인 단추");
		}else if(re == JOptionPane.CANCEL_OPTION){
			// 취소 단추
			
		}else if(re == JOptionPane.CLOSED_OPTION){
			// 종료[x] 단추
			System.out.println("그냥 단추");
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
