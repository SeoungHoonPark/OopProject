package P0111;
/*
 *		단추 2개를 만들고 각각의 단추를 누르면
 *		저장용, 오픈용으로 파일 대화상자를 출력하도록 하자.
 *
 * 		선택한 파일의 이름을 알아내자.
 */
import		GUI.*;
import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import		java.io.*;
public class Test01 {
	MyJFrame	frame;
	JButton		openB, saveB;
	public Test01() {
		frame = new MyJFrame("파일 대화상자");
		frame.setLayout(new FlowLayout());
		
		openB = new JButton("불러오기");
		saveB = new JButton("저장하기");
		ButtonEvent	evt = new ButtonEvent();
		openB.addActionListener(evt);
		saveB.addActionListener(evt);
		
		frame.add(openB);
		frame.add(saveB);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Test01();
	}
	//	많은 기능을 해야 하므로 이벤트 함수 안에서 처리하면 복잡해진다.
	//	그래서 그 기능만 처리하는 함수를 따로 만들어서 사용할 예정이다.
	void saveProc() {
		//	이 부분은 여러분이 처리해 보세요
	}
	void openProc() {
		//	할일
		//		파일 대화상자 만들고
		JFileChooser	c = new JFileChooser();
		//		대화상자를 화면에 출력하자.
		int kind = c.showOpenDialog(frame);
		//	이 대화상자의 반환값의 의미는
		//	이 대화상자를 닫았을때 어떤 단추를 이용해서 닫았는지
		//	단추의 종류를 알려주는 반환값이다.
		//		종류
		//		JFileChooser.CANCEL_OPTION		취소 
		//		JFileChooser.APPROVE_OPTION 	확인
		//		JFileChooser.ERROR_OPTION 		x단추

		//		선택한 파일의 정보를 알아내자.
		if(kind == JFileChooser.APPROVE_OPTION) {
			//	묻지마 코딩
			//	선택한 파일은 파일의 이름을 알려주는 것이 아니고
			//	파일의 정보를 클래스로 묶어서 알려주게 된다.
			//		File
			File	file = c.getSelectedFile();
			String	fileName = file.getName();
			System.out.println("당신이 선택한 파일은 = " + fileName);
		}
		else {
			//	원래는 아무일도 하지 말아야 한다.
			System.out.println("선택이 취소 되었습니다.");
		}
	}
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	할일
			//	1.	어느 단추에서 이벤트가 발생했는지를 알아내고
			JButton	target = (JButton) e.getSource();
			//	2.	이 단추를 구분해서 저장과 불러오기 대화상자를
			//		출력한다.
			if(target == openB) {
				openProc();
			}
			//	실무에서는 마지막 질문은 될 수 있으면 하는것이
			//	아니다.
			else if(target == saveB) {
				saveProc();
			}
		}
	}
}












