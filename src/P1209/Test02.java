package P1209;

// ��Ģ�� Ŭ������ �ϳ��� ���Ͽ� �ϳ��� ����� ���� ��Ģ�̴�.
// ������ ������ �׽�Ʈ �̹Ƿ� ...
public class Test02 {
	public static void main(String[] args) {
		
	//	sam021�̶�� Ŭ������ ����ϰ����ϸ�
	//	�ݵ�� ������Ʈ�� ������ �Ѵ�.
		
		Sam021 s1 = new Sam021();
		// �� ��ǰ�� �̿��ؼ� ���ϴ� �۾��� �����ϸ� �ȴ�.
		// a ������ �����͸� �ְ� �ʹ�.
		s1.a = 10;
		// b ������ �����͸� �ְ� �ʹ�.
		s1.b = 3.14f;
		
		// a�� ������ �ִ��� �������=> abc()�Լ��� �����ϸ� �ȴ�
		s1.abc();
		// b�� ������ �ִ��� �������=> abc()�Լ��� �����ϸ� �ȴ�
		s1.xyz();
	}
}

class Sam021{
	int a;
	float b;
	char c;
	
	void abc(){
		System.out.println("A = " + a);
	}
	void xyz(){
		System.out.println("B = " + b);		
	}
}
