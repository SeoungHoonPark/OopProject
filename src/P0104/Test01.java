package P0104;

/**
 *	��ȣ������ �߸��� ��
 */
public class Test01 {
	Test011 downT;
		
	int num = 20;
	public void Display(){
		System.out.println("Test01�� ������ = " + num );
	}
	void setNum(){
		num++;
	}
	public Test01() {
		// �Ʒ��� Ŭ������ �����ϱ� ���ؼ� new��Ų��.
		downT = new Test011();
		downT.setUp();
	}

	public static void main(String[] args) {
		new Test01();
	}
}

class Test011{
	Test01 upT;
	int num = 10;
	public void Display(){
		System.out.println("Test011�� ������ = " + num);
	}
	
	public void setUp(){
		upT = new Test01();
	}
}