/**
 * 
 */
package P1216;

/**
 *
 */
public class Test04 {
	public static void main(String[] args) {
	
	}
}

class Father04{
	protected void abc(){
		System.out.println("���� �ƹ���");
	}
}
class Son04 extends Father04{
	//�����ϴ� ���
	//	protected void abc(){
	//		System.out.println("���� �Ƶ�");
	//	}
	//	public void abc(){	
	//	}
	
	// �����ϴ� ���
	// ���������ڰ� ���� �������� �Ǿ��� ������ �����Ѵ�.
	//	void abc(){
	//		System.out.println("���� �Ƶ�");
	//}
}
