import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import GUI.MyJFrame;

public class Test extends MyJFrame {
	JCheckBox redB, greenB, blueB;
	
	public Test() {
		setLayout(new FlowLayout());
		redB = new JCheckBox("빨간색");
		greenB = new JCheckBox("초록");
		blueB = new JCheckBox("파란색");
		
		add(redB);
		add(greenB);
		add(blueB);
		
		setSize(400,400);
		setVisible(true);
		
		CheckBoxEvent cbe = new CheckBoxEvent();
		
		redB.addItemListener(cbe);
		greenB.addItemListener(cbe);
		blueB.addItemListener(cbe);	
	}
	
	public static void main(String[] args) {
		new Test();
	}

class CheckBoxEvent implements ItemListener{
	@Override
	public void itemStateChanged(ItemEvent ie) {
		int red  = 0;
		int green = 0;
		int blue = 0;
		
		if(redB.isSelected()){
			red = 255;
		}
		if(greenB.isSelected()){
			green = 255;
		}
		if(blueB.isSelected()){
			blue = 255;
		}
		Color color = new Color(red, green, blue);
		Container con = Test.this.getContentPane();
		con.setBackground(color);	
	}
}
}