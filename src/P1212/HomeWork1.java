package P1212;

/**
 숙제1.	다음 변수를 가지는 Student?? 클래스를 만드세요

		??는 클래스 이름 중복을 하지 않도록 하기 위해서 적당한
		번호를 붙이세요

		String	name
		int		ban;
		int		no;
		int		kor;
		int		eng;
		int		mat;
 */
public class HomeWork1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student001 s1 = new Student001("홍길동", 5,2 );
		//Student001 s1 = new Student001("홍길동", 5, 2 ,100,75,80);
		int[] score = {70,60,90};
		Student001 ss1 = new Student001("홍길동", 5, 3, score);
		ss1.display();
	}
}

class Student001{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int mat;
	
	public Student001() {	
	}
	
	Student001(String n, int b, int num){
	}
	
	Student001(String n, int b, int num, int[] score ){
	}
	
	Student001(String n, int b, int num, int n2, int n3, int n4){
	}
	int getTotal(){
		int total = kor + eng + mat;
		return total;
	}
	
	float getAverage(){
		float avg = getTotal() / 3.0f;
		avg = avg + 0.005f;
		avg = (int)(avg * 100);
		avg = avg/100f;
		return avg;
	}
	
	void display(){
		System.out.printf("%10s %5d %5d %5d %5d %5d %5d %5d %5d &7.2f\r\n", name, ban, no, kor, eng, mat, getTotal(), getAverage());
	}
}
