/**
 * 
 */
package P1229;

import java.util.TreeSet;

/**
 *		������ ���� 10���� �߻��ϰ�, �л��� �������� �����Ѵ�.
 *		�� �߿��� 80~100������ ������ ���� �̾Ƽ� �����ϰ��� �Ѵ�.
 */
public class Test10 {

	public Test10() {
		TreeSet set = new TreeSet();
		for(int i = 0; i < 10; i++){
			int temp = (int)(Math.random() * 101);
			set.add(temp);
		}
		// �л��� ������ �Է��� ���Ҵ�...
		
		System.out.println(set);
		
		TreeSet tempSet = (TreeSet) set.subSet(80, 100);
		
		System.out.println(tempSet);
	}

	public static void main(String[] args) {
			new Test10();
	}
}
