/**
 * 
 */
package P1214;

/**
 *
 */
public class Test03 {
	public static void main(String[] args) {
			Son03 s = new Son03();
			// ����� �޾����Ƿ� super�� ����� �� ����� �� �ִ�.
			s.abc();
			s.xyz();
			s.lmn();
	}
}

class Father03{
		void abc(){
			System.out.println("abc �Լ�");
		}
		void xyz(){
			System.out.println("abc �Լ�");			
		}
}

class Son03 extends Father03{
	// �� �ȿ��� abc(), xyz�� �����Ѵ�.
	// ����� �޴� ������ ����� ����� ��ǰ�� ����� �̿��ϸ鼭
	// ���� ����� 
	
		void lmn(){
			System.out.println("lmn �Լ�");
		}
}
