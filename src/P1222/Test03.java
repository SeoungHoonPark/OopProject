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
		// ���� �� Ŭ������ ����Ҷ� ������ ???�� �ﰢ���Դϴ�. ��� ����ϰ� �ʹ�. 
		//
public String toString() {
	String msg = "������ " +  area + "cm2�� �ﰢ�� Ŭ�����Դϴ�.";
	return super.toString();
}
}
