package P1214;

/**
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Son05 s = new Son05();
		s.abc();
		s.xyz();
	}
}

class Father05{
	void abc(){
		System.out.println("���� �ƹ��� abc�̴�");
	}
}
class Son05 extends Father05{
	void abc(){
		System.out.println("���� �Ƶ� abc�̴�");
	}
	void xyz(){
		//super.abc(); �θ�Ŭ������ �Լ��� ȣ��
		//abc();	�ڽ�Ŭ������ �Լ��� ȣ��
		
		// �翬������ super�� �ƹ��������� ��� �� �� ����
		// �ݵ�� ���� Ŭ���������� ��� �� �� �ִ�.
	}
}
