package P1222;

public class Test01 {
	
	public Test01() {
		Sagak01 s1 = new Sagak01(5,3);
		Sagak01 s2 = new Sagak01(5,3);
		
		if(s1.equals(s2)){
			System.out.println("����");
		}else{
			System.out.println("�ٸ���");			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01();
	}
}

class Sagak01{
	int garo;
	int sero;
	int area;
	
	public Sagak01(int g, int s){
		this.garo = g;
		this.sero = s;
		
		this.area = garo * sero;
	}
	
	// ���� �� Ŭ������ equls�� ����� ������ ������ ���� Ŭ������ �����ϵ��� �ϰ��� �ϸ�
	// �������̵� �ϸ� �ȴ�.
	
	//1. ���� Ŭ������ �Լ��� ������ �����ϰ� �����.
	
	//2. �� �ȿ� �ʿ��� ����� ������ �����ν� ����� �ٲ� �� �ִ�.
	// �� �Լ��� �׽�Ʈ �������� s1.equals(s2)�� �׽�Ʈ �� �����̴�.
	public boolean equals(/*Sagak01 this*/ Object obj){
	// �׷��Ƿ� this => s1�� ���ǰ� 
	//			    obj => s2�� ���ȴ�.	
	// s2�� Sagak01�� �ƴϸ� ���� �� ����.
		
		if(!(obj instanceof Sagak01)){
			return false;
		}
		// �簢���̸� object�� �״�� ����ϴ� ���� �ƴϰ� ����ȯ�ؼ� �������
			
			// ����Ŭ����(Object)�� ���� Ŭ������ �ڵ� ��ȯ�� �ȵȴ�.
			// �׷��Ƿ� �ݵ�� ���� ����ȯ ���Ѿ� �Ѵ�.
		
			Sagak01 temp = (Sagak01) obj;
			
			if(this.area == temp.area){
				return true;
			}else{
				return false;
			}
	}
}
