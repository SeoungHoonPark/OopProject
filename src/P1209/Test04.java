package P1209;

public class Test04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sam041 s = new Sam041();
		s.abc((byte) 5);
	}
}

class Sam041{
	void abc(){
		System.out.println("0��");
	}	
	//���� �̸��� �Լ��� ���� Ŭ���� �ȿ� ����� ������ �츮�� "�Լ��� �����ε� �ߴ�."��� ǥ���Ѵ�.
	// �̶� ��Ģ�� �Ű������� ����, ����, ���� �� �Ѱ��̻��� �޶�� �Ѵ�.
	void abc(int a){
		System.out.println("��Ƽ�� 1��");
	}
	void abc(long a){
		System.out.println("��~�� 1��");
	}
	void abc(float a){
		System.out.println("�÷�Ʈ 2��");		
	}
	
	void abc(double a){
		System.out.println("Double 3��");
	}
	
	void abc(int a, int b){
		System.out.println("�μ�2�� 4��");
	}
}

