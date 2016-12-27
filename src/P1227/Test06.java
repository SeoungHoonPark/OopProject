/**
 * 
 */
package P1227;

import java.text.ChoiceFormat;

/**
 *
 */
public class Test06 {

	public Test06() {
		// choiceFormat�� ���鶧 limit�� format�� �ϳ��� ���� �� �ִ�.
		/* 	����� ������
		 *  	60#D => <=�� �ǹ��̰�
		 *  	70<C < �� �ǹ��̴�
		 *  	
		 *  	�̰��� |�� �̿��ؼ� �����ؼ� ����ϸ� �ȴ�.
		*/
		String pattern = "0#F|60#D|70#C|80<B|90#A";
		// 60#D 60 <=�̸� ���� ���ں��ٴ� �������� D�� ó���Ѵ�.
		// 80<B 80 <�̸� ���� ���ں��ٴ� �������� B�� ó���Ѵ�.
		
		ChoiceFormat f = new ChoiceFormat(pattern);
		
		int score = 80;
		String grade = f.format(score);
		
		System.out.println(grade);
		
	}
	
	public static void main(String[] args) {
		new Test06();
	}

}
