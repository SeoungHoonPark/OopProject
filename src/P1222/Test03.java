/**
 * 
 */
package P1222;

/**
 * @author hong
 *
 */
public class Test03 {

	public Test03() {
		Samgak03  s = new Samgak03();
		System.out.println(s);
	}

	public static void main(String[] args) {
		new Test03();
	}

}

class Samgak03{
	int width;
	int height;
	float area;
	
	public Samgak03(){
		
	}
	
	public Samgak03(int w, int h){
		width = w;
		height = h;
		
		area = (width * height) / 2.0f;
		
	}
		// 나는 이 클래스를 출력할때 면접이 ???인 삼각형입니다. 라고 출력하고 싶다. 
		//
public String toString() {
	String msg = "면접이 " +  area + "cm2인 삼각형 클래스입니다.";
	return super.toString();
}
}
