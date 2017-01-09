package P0109;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import GUI.MyJFrame;

/*
 * 	라디오 단추 3개를 만들고
 * 	선택한 색상으로 색을 칠하세요.
 */
public class Test06 {
	JRadioButton redB, greenB, blueB;
	MyJFrame f;
	
	public Test06() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		redB = new JRadioButton("빨간색");
		greenB = new JRadioButton("초록색");
		blueB = new JRadioButton("파란색");
		
		ButtonGroup g = new ButtonGroup();
		g.add(redB);
		g.add(greenB);
		g.add(blueB);
		
		f.add(redB);
		f.add(greenB);
		f.add(blueB);
		
		f.setSize(400,400);
		f.setVisible(true);
		
		radioBtn evt = new radioBtn();
		redB.addItemListener(evt);
		greenB.addItemListener(evt);
		blueB.addItemListener(evt);
	}

	public static void main(String[] args) {
		new Test06();
	}
	
	// 주로 많이 사용하는 경청자는 itemListener가 된다.
	// 선택한 상태가 변화되는 순간 이벤트가 발생한다.
	class radioBtn implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// 할일
			// 세개중에 어디에서 이벤트가 발생했는지 알아야 한다.
			// 이벤트 정보 클래스 중에는 이벤트가 발생한 도구의 주소를 알려주는 함수가 있다.
			// getSource()라는 함수이다.
			JRadioButton target = (JRadioButton) e.getSource();
			// 그러면 라디오단추의 특징상
			// 그 라디오 단추가 선택되었음이 확실하다.
			
			Container con = f.getContentPane();
			if(target == redB){
				// 빨간색 라디오 단추가 선택되었다.
				con.setBackground(Color.red);
			}else if(target == greenB){
				con.setBackground(Color.green);
			}else {
				con.setBackground(Color.blue);
			}
			
			
		}

	}
}
