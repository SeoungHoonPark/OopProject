package P0109;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import GUI.MyJFrame;

public class Test02 extends MyJFrame{
	JScrollBar redB, greenB, blueB;
	JTextField redF, greenF, blueF;
	
	public Test02() {
		JLabel redL = new JLabel("RED", JLabel.RIGHT);
		JLabel greenL = new JLabel("GREEN", JLabel.RIGHT);
		JLabel blueL = new JLabel("BLUE", JLabel.RIGHT);
		
		redB = new JScrollBar(JScrollBar.HORIZONTAL, 255, 10, 0, 265);
		greenB = new JScrollBar(JScrollBar.HORIZONTAL, 255, 10, 0, 265);
		blueB = new JScrollBar(JScrollBar.HORIZONTAL, 255, 10, 0, 265);
		ScrollEvent evt = new ScrollEvent();
		redB.addAdjustmentListener(evt);
		greenB.addAdjustmentListener(evt);
		blueB.addAdjustmentListener(evt);
		
		redF = new JTextField(5);
		greenF = new JTextField(5);
		blueF = new JTextField(5);
		
		JPanel  p1 = new JPanel (new GridLayout(3, 1));
		p1.add(redL);
		p1.add(greenL);
		p1.add(blueL);
		
		JPanel  p2 = new JPanel (new GridLayout(3,1));
		p2.add(redB);
		p2.add(greenB);
		p2.add(blueB);
		JPanel  p3 = new JPanel (new GridLayout(3,1));
		p3.add(redF);
		p3.add(greenF);
		p3.add(blueF);
		
		JPanel p4 = new JPanel (new BorderLayout());
		p4.add("West", p1);
		p4.add("Center", p2);
		p4.add("East", p3);
		
		this.add("South", p4);
		this.setSize(400,500);
		this.setVisible(true);
	}

	
	public static void main(String[] args) {
		new Test02();
	}
	
	class ScrollEvent implements AdjustmentListener{
		// �� �Լ��� ��ũ�� ���� ƼĿ�� �����϶����� ����Ǵ� �̺�Ʈ �Լ��̴�.
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// ���� 
			//	3���� ��ũ�ѹ��� ���� ��ġ�� �˾Ƴ���.
			// ��ġ�� �̿��ؼ� ������ �����Ѵ�.			
			// �� ������ ĥ�Ѵ�.
			// �ؽ�Ʈ�ʵ忡 ���簪�� ����Ѵ�.
			int red = redB.getValue();
			int green = greenB.getValue();
			int blue = blueB.getValue();
			
			Color color = new Color(red, green, blue);
			
			Container temp = Test02.this.getContentPane();
			temp.setBackground(color);
			// �ؽ�Ʈ �ʵ忡 ���簪�� ����Ѵ�.
			// �ؽ�Ʈ �ʵ忡�� �׻� String���θ� ����ؾ� �Ѵ�.
			String redS = Integer.toHexString(red);
			// String redS = "" + red; ��ü����
			String greenS = Integer.toHexString(green);
			String blueS = Integer.toHexString(blue);
			
			redF.setText(redS);
			greenF.setText(greenS);
			blueF.setText(blueS);
			
			
			
		}
	}
}
