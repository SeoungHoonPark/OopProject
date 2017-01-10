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
 *	���� ���� 3���� �׵θ��� ó���غ���
 */
public class Test04 {
	MyJFrame f = new MyJFrame();
	public Test04() {
		f.setLayout(new FlowLayout());
		JRadioButton r1 = new JRadioButton("1�� ����");
		JRadioButton r2 = new JRadioButton("2�� ����");
		JRadioButton r3 = new JRadioButton("3�� ����");
		
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		g.add(r3);
		
		JPanel p = new JPanel();
		p.add(r1);
		p.add(r2);
		p.add(r3);
		
		// �׵θ��� �θ���
//		BevelBorder bd = new BevelBorder(BevelBorder.RAISED);
//		EtchedBorder bd = new EtchedBorder(EtchedBorder.LOWERED);
//		LineBorder bd = new LineBorder(Color.black,1 , true);
		
		ImageIcon img = new ImageIcon("src/P0110/wavy.gif");
		Insets insets = new Insets(20,20,20,20);
//		MatteBorder bd = new MatteBorder(insets, img);
//		SoftBevelBorder bd = new SoftBevelBorder(SoftBevelBorder.LOWERED);
//		EtchedBorder temp = new EtchedBorder(EtchedBorder.LOWERED);
//		TitledBorder bd = new TitledBorder(temp, "�׵θ� �θ���", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM);
		
		// 1. BevelBorder���� ����µ� ���ʿ� ������ ����� �ְ�ʹ�.
//		BevelBorder bd1 = new BevelBorder(BevelBorder.RAISED);
//		EmptyBorder bd2 = new EmptyBorder(30, 30, 30, 30);
		
		//	2. ������ �׸����� ĥ�ϰ� �ٱ����� ���ó�� �� ������� �׵θ��� ����� �ʹٸ�
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
