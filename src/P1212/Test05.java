package P1212;

public class Test05 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Score051 s1 = new Score051("홍길동");
			s1.Display();
			Score051 s2 = new Score051("장독대", 50,  60, 70);
			s2.Display();
			int[] s = {70,50,30};
			Score051 s3 = new Score051("임꺽정", s);
			s3.Display();	
	}
}

// 나는 한학생의 점수를 입력받아서 총점과 평균을 계산하는 목적을 가진 클래스를 만들고 싶다.
class Score051{	
	//기본 정보를 기억할 변수
	String name;
	int kor;
	int eng;
	int mat;
	int total;
	float avg;
	
	//이 클래스를 사용하는 다른 사용자를 위해서 new시키는 방법을 제공하고 싶다.
	/*	==> 생성자 함수를 만들어서 제공하면 된다.
	 * 1. 이름만 알고 있는 경우 
	 */
	Score051(String n){
		name = n;
	}
	// 2. 이름과 점수를 알고 있는 경우	
	Score051(String n, int k, int e, int m) {
		name= n;
		kor = k;
		mat = m;
		total = kor + eng + mat;
		avg = total / 3.0f;
	}
	
	//	3. 이름과 점수를 알고 있는 경우(점수는 배열로 알고있는 경우)	 
	Score051(String n, int [] s){
		this(n, s[0],s[1],s[2]);		
//		name = n;
//		kor = s[0];
//		eng = s[1];
//		mat = s[2];
//		total = kor + eng + mat;
//		avg = total / 3.0f;
	}
	
	void Display(){
		System.out.printf("%10s %5d %5d %5d %5d %f \r\n", name, kor, eng, mat, total, avg);
	}
	
//	예
//	새로운 점수를 입력
}
