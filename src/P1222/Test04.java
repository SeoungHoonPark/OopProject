package P1222;

/**
 *
 */
public class Test04 {
	public Test04() {
		Circle04 c1 = new Circle04(5);
		Circle04 c2 = null;
		try {
			c2 = (Circle04) c1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.area);
		System.out.println(c2.area);
	}
	public static void main(String[] args) {
		new Test04();
	}
}

// 자기 복제가 가능하도록 하기 위해서는
// 자바가 만든 규칙이 하나더 있다.
// 이것은 자바가 만든 규칙이므로 외워야 한다.
// 바로 자기 복제가 가능한 클래스는 반드시 Cloneable 인터페이스 상속받아야 한다.


class Circle04 implements Cloneable {
	int 		radius;
	float 	area;
	float 	around;
	
	public Circle04() {
		
	}
	
	public Circle04(int r){
		radius = r;
		area = (float)(r* r * Math.PI);
		around = (float)(r * 2 *Math.PI);
	}
	
	public Object clone() throws CloneNotSupportedException{
	// 문제는 오버라이드를 하는 순간 아버지의 기능을 없어진다.
	// 자기 복제 프로그램을 만들어야 한다.
	// 상속받은 클래스에서 상위 클래스의 멤버를 강제로 사용하는 방법이 하나 있었다.
		
		Object temp = super.clone();
		return temp;
		
	}
}

