/**
 * 
 */
package GUI;

import javax.swing.JFrame;

/**
 * 이 클래스는 JFrame을 상속 받은 후
 * x 단추를 누르면 프로그램이 종료되는 기능을 추가한 클래스로 만들예정이다. *
 */
public class MyJFrame extends JFrame{
	
	public  MyJFrame(){
		this("");
	}

	public MyJFrame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
