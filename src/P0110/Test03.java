package P0110;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import GUI.MyJFrame;

/**
 *	토글 단추를 하나 만들고 한번 누르면 검정색, 다시 누르면 하얀색으로 색깔을 칠하시오.
 */
public class Test03 {
	
	JToggleButton jt;
	MyJFrame f; 
	
	public Test03() {
		f = new MyJFrame();
		f.setLayout(new FlowLayout());
		
		jt = new JToggleButton("눌르세요");
		jt.addItemListener(new MyToggleBtn());
		f.add(jt);
		
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test03();
	}
	
	// 주로 상태가 변화되는 이벤트는 Item이 좋다.(권장)
	class MyToggleBtn implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// 할 일
			// 		현재 단추의 상태를 알아낸다.
			// 		체크상자와 같이 선택되었는지, 취소되었는지로 판단(알아야)한다.
			boolean is = jt.isSelected();
			//		상태에 따라서 색상을 칠한다.
			
			Container con = f.getContentPane();
			
			if(is == true){
				con.setBackground(Color.black);
			}else{
				con.setBackground(Color.cyan);
			}
		}
	}
}
