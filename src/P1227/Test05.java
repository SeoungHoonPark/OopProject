/**
 * 
 */
package P1227;

import java.text.ChoiceFormat;

/**
 *		�л��� ������ �Է¹޾Ƽ� ������ ����ϴ� ���α׷��� �ۼ��ϼ���
 */
public class Test05 {

	public Test05() {
		double[] limits = {0, 60,70,80,90};
		// limits�� ���鶧 ���ǻ���
		// �ݵ�� �������� ���ĵǾ�� �Ѵ�.
		// �̰��� �ǹ̴� 60~69���̴� �ϳ��� ���ڷ� �ٲٰ�
		// 70~79���̴� �ϳ��� ���ڷ� �ٲٰ� ...
		//	90~ 	���̴� �ϳ��� ���ڷ� �ٲ��	
		
		String forma[] = {"F", "D","C","B","A"};
		// format�� ���鶧 ���ǻ���
		// limit�� ������ �ݵ�� ��ġ�ؾ� �Ѵ�.
		
		ChoiceFormat f = new ChoiceFormat(limits, forma);
		// Ư�� ������ ���� �л��� ������ ���غ���
		
		int score = 69;
		String grade = f.format(score);
		
		System.out.println(score + " : " + grade);
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
