package P1222;

/**
 *
 */
public class Test05 {
	
	public void setAge(int a ) throws AgeException {
		// ���̰� ������ �ԷµǸ� ���̻� ������ �ʿ䰡 ���ٰ� �����Ѵ�
		System.out.println("�Լ�����");
		if(a < 0){
			throw new AgeException();
		}
		System.out.println();
	}
	public Test05() {
		try {
		setAge(-100);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test05();
	}
}
