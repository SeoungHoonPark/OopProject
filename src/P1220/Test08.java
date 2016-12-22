/**
 * 
 */
package P1220;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 */
public class Test08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("내가 만든 대화상자");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setSize(400,400);
		f.setVisible(true);
	}
}

//원칙적으로 하면..아래와 같이 작성
//class MyEvent08 extends WindowAdapter {
//	public void windoClosing(WindowEvent e){
//		System.exit(0);
//	}
//}