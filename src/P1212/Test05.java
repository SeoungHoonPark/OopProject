package P1212;

public class Test05 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Score051 s1 = new Score051("ȫ�浿");
			s1.Display();
			Score051 s2 = new Score051("�嵶��", 50,  60, 70);
			s2.Display();
			int[] s = {70,50,30};
			Score051 s3 = new Score051("�Ӳ���", s);
			s3.Display();	
	}
}

// ���� ���л��� ������ �Է¹޾Ƽ� ������ ����� ����ϴ� ������ ���� Ŭ������ ����� �ʹ�.
class Score051{	
	//�⺻ ������ ����� ����
	String name;
	int kor;
	int eng;
	int mat;
	int total;
	float avg;
	
	//�� Ŭ������ ����ϴ� �ٸ� ����ڸ� ���ؼ� new��Ű�� ����� �����ϰ� �ʹ�.
	/*	==> ������ �Լ��� ���� �����ϸ� �ȴ�.
	 * 1. �̸��� �˰� �ִ� ��� 
	 */
	Score051(String n){
		name = n;
	}
	// 2. �̸��� ������ �˰� �ִ� ���	
	Score051(String n, int k, int e, int m) {
		name= n;
		kor = k;
		mat = m;
		total = kor + eng + mat;
		avg = total / 3.0f;
	}
	
	//	3. �̸��� ������ �˰� �ִ� ���(������ �迭�� �˰��ִ� ���)	 
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
	
//	��
//	���ο� ������ �Է�
}
