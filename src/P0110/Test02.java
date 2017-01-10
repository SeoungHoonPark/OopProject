package P0110;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JSpinner;

import GUI.MyJFrame;

/**
 *	SPinner
 */
public class Test02 {
	JSpinner jp ;
	MyJFrame f = new MyJFrame();
	
	public Test02() {
		f.setLayout(new FlowLayout());
		jp = new JSpinner(){
			@Override
			public Dimension getPreferredSize() {
				//  이 안에서 최소 크기를 다시 결정해서 알려준다.
				
				// Dimension 클래스란?
				// VO클래스(데이터 빈 클래스)의 일종으로
				//	가로, 세로 라는 변수를 가진 클래스이다
				
				// 우리는 새로운 최소크기를 Dimension클래스로 묶어서 알려주면 된다.
				
				// 현재 가장 크기를 알아낸다.
				Dimension dim = super.getPreferredSize();
				return new Dimension(dim.width+50,dim.height);
			}
		};
		// 특정 클래스를 상속받아서 함수를 오버라이드해서
		// 사용해야 하는 경우 간단한 조작을 위해서
		// 클래스를 만들어야 하는 불편함이 있다.
		// 이런 경우 굳이 클래스를 만들지 않고도 오버라이드할 수 있는 방법이 하나 존재한다.
		// 		내부 클래스 중에서 무명 클래스이다.
		
		//jp = new MySpinner();
		
		// 팁
		// 		특정 도구의 최소 크기 변경하기
		//	 	물론 배치전략에 따라 자동으로 크기가 조절되는 경우도 있지만...
		
		//	방법
		//		1. 해당 도구를 상속받은 클래스를 제작한다.
		//			여러분의 클래스가 그 도구의 역활을 하도록 한다.
		//		2. getPreferredSize()를 오버라이드한 후 그 안에서 최소 크기를 결정하면 된다.
		
		f.add(jp);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test02();
	}
}

// Spinner의 최소크기를 변경하기 위한 클래스를 만들자.
//class MySpinner extends JSpinner {
//	private static final long serialVersionUID = 1L;
//	
//	@Override
//	public Dimension getPreferredSize() {
//		//  이 안에서 최소 크기를 다시 결정해서 알려준다.
//		
//		// Dimension 클래스란?
//		// VO클래스(데이터 빈 클래스)의 일종으로
//		//	가로, 세로 라는 변수를 가진 클래스이다
//		
//		// 우리는 새로운 최소크기를 Dimension클래스로 묶어서 알려주면 된다.
//		
//		// 현재 가장 크기를 알아낸다.
//		Dimension dim = super.getPreferredSize();
//		return new Dimension(dim.width+100,dim.height);
//	}
//}