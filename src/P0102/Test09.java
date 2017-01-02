/**
 * 
 */
package P0102;

/**
 *	어노테이션
 */
public class Test09 {
	public Test09() {
			Sagak s = new Sagak(5,10);
			System.out.println(s);
	}

	public static void main(String[] args) {
		new Test09();
	}
}
class Sagak{
	int width;
	int height;
	int area;
	
	public Sagak() {
		
	}
	public Sagak(int w, int h) {
		width = w;
		height = h;
		area = width * height;
	}
	
	//나는 이 클래스를 누군가가 출력할 경우를 대비해서 정보를 알려주고 싶다.
	// 정보를 알려주고 싶다.
	// 그러면 toString()를 오버라이딩하여 기능을 수정하면 된다.
	
	//하지만 오타가 나서
	// 이것은 어버라이딩으로 인정하고 않고
	// 새로운 함수를 더 만든것으로 인정한다.
	@Override
	public String toString(){
		return "이 클래스는 면적인 " + area + "인 사각형이다.";
	}
	
	
	
	
}
