/**
 * 
 */
package P1220;

/**
 * @author hong
 *
 */
public class Test04 {	
	public static void main(String[] args) {
		//������ ����� �ͱ����� ����Ѵ�.
		MyInter04 in = null;
		
//		in = new MyInter04();
		in = new MyClass04();
		in.abc();
		in.xyz();
		
		if(in instanceof MyClass04){
			System.out.println("�� ���� MyClass04�̴�");
		}else{
			System.out.println("�ƴϿ� ���� MyClass04�� �ƴϴ�");
		}
		if(in instanceof MyInter04){
			System.out.println("�� ���� MyClass04�̴�");
		}else{
			System.out.println("�ƴϿ� ���� MyClass04�� �ƴϴ�");
		}
		
	}
}

interface MyInter04{
	//�������̽� �ȿ��� �߻����� �Լ��� ���� �� �ִ�.
	void abc();
	void xyz();
	// ��ü(���)�� �����ϴ� �Լ��� ����� �������̽� �ȿ� ������ �� ����
	//void lmn(){}
	
	default void imn(){}	
	// ���� �Ϲ� �Լ��� �ʿ��ϴٸ� default �Ӽ��� �����ؾ� �Ѵ�.
	//�� �Լ��� �߻����� �Լ��� �ƴϹǷ� �������̵� ���� �ʾƵ� ����� ����.
	
}

class MyClass04 implements MyInter04{
	public void abc() {
		System.out.println("���� abc�Լ�");
	}
	public void xyz() {
		System.out.println("���� xyz�Լ�");
	}
}