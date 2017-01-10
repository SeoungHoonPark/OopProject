package P0110;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.MyJFrame;

/**
 * 	��ܿ� �����̵� �ϳ��� �����, �� �����̵带 �̵��ϸ�
 * 	�������� �󵵸� �����Ͽ� ȭ���� ĥ�ϴ� ���α׷��� �ۼ��ϼ���.
 */
public class Test01 {
	JSlider slider;
	MyJFrame f;
	
	public Test01() {
		f = new MyJFrame();
		slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		//	�����Լ�
		// 1. ���ݱ׸���
		//slider.setPaintTicks(boolean b);
		slider.setPaintTicks(true);
		// 		1) ������ �׸��⸦ ����ϰ�, 2) ������ ������ �����Ѵ�.
		//setMajorTickSpacing(n); // �ݵ�� ����
		//setMinorTickSpacing(n); // �ʿ�� ���� 
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		// 2. ���ݿ� ���� ���̱�
		//	slider.setPaintLabels(boolean b);
		slider.setPaintLabels(true);
		
		// 3. ƼĿ�� ���ݿ� ������Ű��
		slider.setSnapToTicks(true);
		
		slider.addChangeListener(new SliderEvent());
		
		f.add("North", slider);
		f.setSize(500,500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test01();
	}
	
	class SliderEvent implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			// ����
			// ���� �����̴��� ƼĿ�� ����Ű�� ���� ���� �˾Ƴ���
			int value = slider.getValue();
			
			//  �̰��� �̿��ؼ� ������ �󵵸� ������ ������ ��� ĥ�Ѵ�.
			Color color = new Color(value, 0,0);
			Container con = f.getContentPane();
			con.setBackground(color);			
		}
	}
}