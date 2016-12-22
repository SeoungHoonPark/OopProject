package P1222;

public class Test01 {
	
	public Test01() {
		Sagak01 s1 = new Sagak01(5,3);
		Sagak01 s2 = new Sagak01(5,3);
		
		if(s1.equals(s2)){
			System.out.println("같다");
		}else{
			System.out.println("다르다");			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01();
	}
}

class Sagak01{
	int garo;
	int sero;
	int area;
	
	public Sagak01(int g, int s){
		this.garo = g;
		this.sero = s;
		
		this.area = garo * sero;
	}
	
	// 나는 이 클래스에 equls의 기능을 면적이 같으면 같은 클래스로 판정하도록 하고자 하면
	// 오버라이드 하면 된다.
	
	//1. 상위 클래스의 함수의 원형과 동일하게 만든다.
	
	//2. 이 안에 필요한 기능을 구현해 줌으로써 기능을 바꿀 수 있다.
	// 이 함수는 테스트 과정에서 s1.equals(s2)로 테스트 할 예정이다.
	public boolean equals(/*Sagak01 this*/ Object obj){
	// 그러므로 this => s1이 기억되고 
	//			    obj => s2가 기억된다.	
	// s2가 Sagak01이 아니면 비교할 수 없다.
		
		if(!(obj instanceof Sagak01)){
			return false;
		}
		// 사각형이면 object는 그대로 사용하는 것이 아니고 형변환해서 사용하자
			
			// 상위클래스(Object)는 하위 클래스로 자동 변환이 안된다.
			// 그러므로 반드시 강제 형변환 시켜야 한다.
		
			Sagak01 temp = (Sagak01) obj;
			
			if(this.area == temp.area){
				return true;
			}else{
				return false;
			}
	}
}
