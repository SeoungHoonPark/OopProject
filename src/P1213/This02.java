package P1213;

/**
 * 
 */
public class This02 {
	public static void main(String[] args) {
		Sam021 s = new Sam021("ȫ�浿", 100);
		System.out.println(s.kor);
	}
}

class Sam021{
	static String name;
	static int kor;
	
	Sam021(String name, int kor){	//������ �Լ�
		this.name = name;
		this.kor = kor;	//��� ������� ������ �ʾҴ�.
	}
	
	void setName(String name){
	}
}
