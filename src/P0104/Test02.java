package P0104;

/**
 * ��ȣ������ ���� ��
 */
public class Test02 {
	Test021 downT;
	int num = 20;
	public void display(){
		System.out.println("Ŭ���� �������� " + num);
	}
	public void setNum(){
		num++;
	}
	public Test02() {
		// ��������� �������� ������ ����� ���� new��Ű�� �ȴ�.
		downT = new Test021();
		// ��� ���� ����� Ŭ������ �ڽ��� �ּҸ� �˷��ش�.
		downT.setUp(this);
		downT.setNum();
		downT.display();
	}

	public static void main(String[] args) {
		new Test02();
	}
}

class Test021{
	Test02 upT;
	int num = 20;
	public void display(){
		System.out.println("Ŭ���� �������� " + num);
	}
	public void setNum(){
		num++;
	}
	
	//���� �ּҸ� ���� �Լ��� ������.
	// ���߿� ����� Ŭ������ ���� ����� Ŭ������ �ּҸ� �޾Ƽ� ����ؾ� �Ѵ�.
	public void setUp(Test02 temp){
			this.upT = temp;
			upT.setNum();
			upT.display();
	}
}
