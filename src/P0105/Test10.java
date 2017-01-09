/**
 * 
 */
package P0105;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import GUI.MyJFrame;

/**
 *		체크상자 3개를 만들고(빨,초,파)
 *		선택된 체크상자를 이용해서 색상을 만들어서 칠하자.
 */
public class Test10 extends MyJFrame{
	JCheckBox redB, greenB, blueB;
	public Test10() {
		setLayout(new FlowLayout());
		redB = new JCheckBox("빨간");
		greenB = new JCheckBox("초록");
		blueB = new JCheckBox("파란");
		add(redB);
		add(greenB);
		add(blueB);
		
		setSize(500,500);
		setVisible(true);
		CheckBoxEvent10 evt = new CheckBoxEvent10();
		
		redB.addItemListener(evt);
		greenB.addItemListener(evt);
		blueB.addItemListener(evt);
	}

	public static void main(String[] args) {
		new Test10();
	}
	
	class CheckBoxEvent10 implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			//각각의 체크상자가 선택된 상태인지 아닌지를 알아낸다.
			int red = 0;		// 처음에는 선택 안된 상태로
			int green = 0;	// 가정해서 0으로 넣고
			int blue = 0;		// 
			
			if(redB.isSelected()){
				red=255;
			}
			if(greenB.isSelected()){
				green=255;
			}
			if(blueB.isSelected()){
				blue=255;
			}
			Color color = new Color(red, green, blue);
			// 컨테이너 안에 숨겨진 frame을 찾아라
			// 컨테이너는 바깥 클래스의 자신이다.
			// this 는 안쪽 클래스를 의미한다.
			// 바깥클래스의 this를 명시하는 방법?
		Container con = Test10.this.getContentPane();
		con.setBackground(color);
		
		}		
	}
}
