package P0110;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import GUI.MyJFrame;

/**
 *	��� ���߸� �ϳ� ����� �ѹ� ������ ������, �ٽ� ������ �Ͼ������ ������ ĥ�Ͻÿ�.
 */
public class Test03 {
	
	JToggleButton jt;
	MyJFrame f; 
	
	public Test03() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		jt = new JToggleButton("��������");
		jt.addItemListener(new MyToggleBtn());
		f.add(jt);
		
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test03();
	}
	
	// �ַ� ���°� ��ȭ�Ǵ� �̺�Ʈ�� Item�� ����.(����)
	class MyToggleBtn implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// �� ��
			// 		���� ������ ���¸� �˾Ƴ���.
			// 		üũ���ڿ� ���� ���õǾ�����, ��ҵǾ������� �Ǵ�(�˾ƾ�)�Ѵ�.
			boolean is = jt.isSelected();
			//		���¿� ���� ������ ĥ�Ѵ�.
			
			Container con = f.getContentPane();
			
			if(is == true){
				con.setBackground(Color.black);
			}else{
				con.setBackground(Color.cyan);
			}
		}
	}
}
