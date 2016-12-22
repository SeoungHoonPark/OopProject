package P1213;

/**
 * 
 */
public class This02 {
	public static void main(String[] args) {
		Sam021 s = new Sam021("홍길동", 100);
		System.out.println(s.kor);
	}
}

class Sam021{
	static String name;
	static int kor;
	
	Sam021(String name, int kor){	//생성자 함수
		this.name = name;
		this.kor = kor;	//고로 멤버에는 기억되지 않았다.
	}
	
	void setName(String name){
	}
}
