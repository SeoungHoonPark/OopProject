package P0110;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.MyJFrame;

/**
 * 	상단에 슬라이드 하나를 만들고, 이 슬라이드를 이동하면
 * 	빨간색의 농도를 조절하여 화면을 칠하는 프로그램을 작성하세요.
 */
public class Test01 {
	JSlider slider;
	MyJFrame f;
	
	public Test01() {
		f = new MyJFrame();
		slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		//	보조함수
		// 1. 눈금그리기
		//slider.setPaintTicks(boolean b);
		slider.setPaintTicks(true);
		// 		1) 눈금을 그리기를 허락하고, 2) 눈금을 간격을 설정한다.
		//setMajorTickSpacing(n); // 반드시 지정
		//setMinorTickSpacing(n); // 필요시 지정 
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		// 2. 눈금에 숫자 붙이기
		//	slider.setPaintLabels(boolean b);
		slider.setPaintLabels(true);
		
		// 3. 티커를 눈금에 고정시키기
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
			// 할일
			// 현재 슬라이더의 티커가 가리키는 곳의 값을 알아내고
			int value = slider.getValue();
			
			//  이값을 이용해서 빨간색 농도를 조절한 색상을 얻고 칠한다.
			Color color = new Color(value, 0,0);
			Container con = f.getContentPane();
			con.setBackground(color);			
		}
	}
}