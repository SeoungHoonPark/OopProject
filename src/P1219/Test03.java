package P1219;

/**
 * 
 */
public class Test03 {
	public static void main(String[] args) {
//		 Grand03 g = new Son03();
		 // �ڵ� ����ȯ�� ���ؼ� ����� �����ϴ�.
//		 g.abc();
		 // Grand03 ���� Son03���� ���������� �� 
		 // ���� �������� ������ �Լ��� ȣ���ϰ� �ȴ�.
		
		Object g = new Father03();
		
//		Grand03 g = new Father03();
		((Father03) g).abc();
	}
}

class Grand03 {
	void abc(){
		System.out.println("���� �Ҿƹ���");
	}
}
class Father03 extends Object{
	void abc(){
		System.out.println("");
	}
}

class Son03 extends Father03{
	void abc(){
		System.out.println("���� �Ƶ�");
	}
}

