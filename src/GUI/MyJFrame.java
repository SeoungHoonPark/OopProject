/**
 * 
 */
package GUI;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * �� Ŭ������ JFrame�� ��� ���� ��
 * x ���߸� ������ ���α׷��� ����Ǵ� ����� �߰��� Ŭ������ ���鿹���̴�. *
 */
public class MyJFrame extends JFrame{
	
	public  MyJFrame(){
		this("");
	}
	
	@Override
	public Container getContentPane() {
		return super.getContentPane();
	}

	public MyJFrame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
