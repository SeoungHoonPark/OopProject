/**
 * 
 */
package P0102;

/**
 *	������̼�
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
	
	//���� �� Ŭ������ �������� ����� ��츦 ����ؼ� ������ �˷��ְ� �ʹ�.
	// ������ �˷��ְ� �ʹ�.
	// �׷��� toString()�� �������̵��Ͽ� ����� �����ϸ� �ȴ�.
	
	//������ ��Ÿ�� ����
	// �̰��� ������̵����� �����ϰ� �ʰ�
	// ���ο� �Լ��� �� ��������� �����Ѵ�.
	@Override
	public String toString(){
		return "�� Ŭ������ ������ " + area + "�� �簢���̴�.";
	}
	
	
	
	
}
