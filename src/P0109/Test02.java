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
		// 이 함수는 스크롤 바의 티커가 움직일때마다 실행되는 이벤트 함수이다.
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// 할일 
			//	3가지 스크롤바의 현재 위치를 알아낸다.
			// 위치를 이용해서 색상을 결정한다.			
			// 이 색상을 칠한다.
			// 텍스트필드에 현재값을 기록한다.
			int red = redB.getValue();
			int green = greenB.getValue();
			int blue = blueB.getValue();
			
			Color color = new Color(red, green, blue);
			
			Container temp = Test02.this.getContentPane();
			temp.setBackground(color);
			// 텍스트 필드에 현재값을 기록한다.
			// 텍스트 필드에는 항상 String으로만 기록해야 한다.
			String redS = Integer.toHexString(red);
			// String redS = "" + red; 대체가능
			String greenS = Integer.toHexString(green);
			String blueS = Integer.toHexString(blue);
			
			redF.setText(redS);
			greenF.setText(greenS);
			blueF.setText(blueS);
			
			
			
		}
	}
}
