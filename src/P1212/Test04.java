/**
 * 
 */
package P1212;

/**
 * @author hong
 *
 */
public class Test04 {
	public static void main(String[] args) {
		Sam041 s= new Sam041();
	}
}

class Sam041{
	Sam041(){
//		int a = 5; ���ʿ� �ٸ� ������ ������ ������ �߻�
		this(5);
		System.out.println("����Ʈ");
	}
	
	Sam041(int a){
		System.out.println("�Ѱ�");
	}
	
	void abc(){
		//�Ϲ� �Լ������� ��� �� �� ����
		// this(5);			����
	}
}