package P1220;

/**
 *
 */
public class Test06 {
	public static void main(String[] args) {
		// ���� ���� Ŭ������ �ٱ� Ŭ������ ������ ���谡 �ִ�.
		//Outer06.Inner06 in = new Outer06.Inner06();
		// �ݵ�� ���� ���� Ŭ������ �ٱ� Ŭ������ ������ �� ����� �ִ�.
		
		Outer06 out = new Outer06();
		Outer06.Inner06 in = out.new Inner06();
		// �� ������ �ݵ�� �ܿ켼��.
		// �ٱ� Ŭ������ �ּҸ� �̿��ؼ� ���� Ŭ������ �����ؾ� �Ѵ�.
		
		in.xyz();
		
	}
}

class Outer06{
	int a = 10;
	void abc(){
		System.out.println("A = " + a);
		//xyz(); ����	�ٱ� Ŭ������ ���� Ŭ������ ��� �� �� ����.
		//���� ����ϱ⸦ ���ϸ� new ���Ѽ� ����ض�
		Inner06 in = new Inner06();
		in.lmn();
		
	}
	// �̷� ������ ���� Ŭ������ ���� ���� Ŭ������� �θ���.
	public class Inner06{
		int b = 100;
		int a = 500;
		void lmn(){
			System.out.println("lmn���� ��� B = " + b);
		}
		void xyz(){
			System.out.println("B = " + b);
			// �ٱ� Ŭ������ ����� ��ġ �ڱ��ó�� �ƹ� ���Ǿ��� ����� �� �ִ�.
			abc();
			System.out.println("A = " + a);
			// �ڹٴ� �ڱ�� ���� ����� ������ ���� ����Ѵٰ� Ã�⿡ �ڽ��� a ������ ����Ѵ�.
			
			// ���� �� ��� �ٱ� a�� ����ϰ��� �ϸ�
			//Ŭ�����̸�.this.���(�ܿ��)
			System.out.println("A = " + Outer06.this.a);
			
		}
	}
}
