package P0110;

import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import GUI.MyJFrame;

/**
 *	라디오 단추 3개에 테두리를 처리해보자
 */
public class Test04 {
	MyJFrame f = new MyJFrame();
	public Test04() {
		f.setLayout(new FlowLayout());
		JRadioButton r1 = new JRadioButton("1번 라디오");
		JRadioButton r2 = new JRadioButton("2번 라디오");
		JRadioButton r3 = new JRadioButton("3번 라디오");
		
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		g.add(r3);
		
		JPanel p = new JPanel();
		p.add(r1);
		p.add(r2);
		p.add(r3);
		
		// 테두리를 두르자
//		BevelBorder bd = new BevelBorder(BevelBorder.RAISED);
//		EtchedBorder bd = new EtchedBorder(EtchedBorder.LOWERED);
//		LineBorder bd = new LineBorder(Color.black,1 , true);
		
		ImageIcon img = new ImageIcon("src/P0110/wavy.gif");
		Insets insets = new Insets(20,20,20,20);
//		MatteBorder bd = new MatteBorder(insets, img);
//		SoftBevelBorder bd = new SoftBevelBorder(SoftBevelBorder.LOWERED);
//		EtchedBorder temp = new EtchedBorder(EtchedBorder.LOWERED);
//		TitledBorder bd = new TitledBorder(temp, "테두리 두르기", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM);
		
		// 1. BevelBorder으로 만드는데 안쪽에 여백을 충분히 주고싶다.
//		BevelBorder bd1 = new BevelBorder(BevelBorder.RAISED);
//		EmptyBorder bd2 = new EmptyBorder(30, 30, 30, 30);
		
		//	2. 안쪽은 그림으로 칠하고 바깥쪽은 골랑처럼 들어간 모습으로 테두리를 만들고 싶다면
		MatteBorder bd1 = new MatteBorder(insets, img);
		EtchedBorder bd2 = new EtchedBorder(EtchedBorder.LOWERED);
			
		CompoundBorder bd = new CompoundBorder(bd2, bd1);		
		p.setBorder(bd);	
		
		f.add(p);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test04();
	}
}
