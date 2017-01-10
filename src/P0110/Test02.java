package P0110;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JSpinner;

import GUI.MyJFrame;

/**
 *	SPinner
 */
public class Test02 {
	JSpinner jp ;
	MyJFrame f = new MyJFrame();
	
	public Test02() {
		f.setLayout(new FlowLayout());
		jp = new JSpinner(){
			@Override
			public Dimension getPreferredSize() {
				//  �� �ȿ��� �ּ� ũ�⸦ �ٽ� �����ؼ� �˷��ش�.
				
				// Dimension Ŭ������?
				// VOŬ����(������ �� Ŭ����)�� ��������
				//	����, ���� ��� ������ ���� Ŭ�����̴�
				
				// �츮�� ���ο� �ּ�ũ�⸦ DimensionŬ������ ��� �˷��ָ� �ȴ�.
				
				// ���� ���� ũ�⸦ �˾Ƴ���.
				Dimension dim = super.getPreferredSize();
				return new Dimension(dim.width+50,dim.height);
			}
		};
		// Ư�� Ŭ������ ��ӹ޾Ƽ� �Լ��� �������̵��ؼ�
		// ����ؾ� �ϴ� ��� ������ ������ ���ؼ�
		// Ŭ������ ������ �ϴ� �������� �ִ�.
		// �̷� ��� ���� Ŭ������ ������ �ʰ� �������̵��� �� �ִ� ����� �ϳ� �����Ѵ�.
		// 		���� Ŭ���� �߿��� ���� Ŭ�����̴�.
		
		//jp = new MySpinner();
		
		// ��
		// 		Ư�� ������ �ּ� ũ�� �����ϱ�
		//	 	���� ��ġ������ ���� �ڵ����� ũ�Ⱑ �����Ǵ� ��쵵 ������...
		
		//	���
		//		1. �ش� ������ ��ӹ��� Ŭ������ �����Ѵ�.
		//			�������� Ŭ������ �� ������ ��Ȱ�� �ϵ��� �Ѵ�.
		//		2. getPreferredSize()�� �������̵��� �� �� �ȿ��� �ּ� ũ�⸦ �����ϸ� �ȴ�.
		
		f.add(jp);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Test02();
	}
}

// Spinner�� �ּ�ũ�⸦ �����ϱ� ���� Ŭ������ ������.
//class MySpinner extends JSpinner {
//	private static final long serialVersionUID = 1L;
//	
//	@Override
//	public Dimension getPreferredSize() {
//		//  �� �ȿ��� �ּ� ũ�⸦ �ٽ� �����ؼ� �˷��ش�.
//		
//		// Dimension Ŭ������?
//		// VOŬ����(������ �� Ŭ����)�� ��������
//		//	����, ���� ��� ������ ���� Ŭ�����̴�
//		
//		// �츮�� ���ο� �ּ�ũ�⸦ DimensionŬ������ ��� �˷��ָ� �ȴ�.
//		
//		// ���� ���� ũ�⸦ �˾Ƴ���.
//		Dimension dim = super.getPreferredSize();
//		return new Dimension(dim.width+100,dim.height);
//	}
//}