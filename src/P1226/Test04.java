/**
 * 
 */
package P1226;

import java.util.StringTokenizer;

/**
 *		�ø� �ϳ� �ۼ��� �� ������ �߽����� �ܾ ���� ����ϼ���.
 */
public class Test04 {
	public Test04() {
		String str = "�״� ������ �ϴ��� �췯�� ���� �β��� ���⸦";
		// �� ������ ������ �߽����� �и��ϱ� ���ؼ�
		// StringTokenizer�� �̿��� ����� �Ѵ�.
		
		StringTokenizer token = new StringTokenizer(str);
		// �̹� �и��� �Ǿ� �ִ�.
		
		int count  = token.countTokens();
		System.out.println(count);
		
		// �̰��� ��������.
//		for(int i = 0; i < count; i++){
//			String temp = token.nextToken();
//			System.out.println(temp);
			
			// ������ �ϳ��� ������ ���� ������ �ӽ� �޸𸮿��� �����ȴ�.
			// �׷��Ƿ� �ʿ��ϸ� �迭 ���� �̿��ؼ� �ٽ� ������ �� ����ؾ� �Ѵ�.
//		}
		System.out.println("�ٽ� ������");
//		for(int i = 0; i < count; i++){
//			String temp = token.nextToken();
//			System.out.println(temp);
//		}
		
		//���� ������ ������ �𸣸�?
		
		while(token.hasMoreTokens()){
			//���� �����Ͱ� �����ִ�?
			// ���� �����Ͱ� ������ �ݺ��ϰ�
			String temp = token.nextToken();
			System.out.println(temp);
		}
			// ���� �����Ͱ� ������ �ݺ��� �����϶�.
	}

	public static void main(String[] args) {
		new Test04();
	}
}
