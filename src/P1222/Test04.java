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

// �ڱ� ������ �����ϵ��� �ϱ� ���ؼ���
// �ڹٰ� ���� ��Ģ�� �ϳ��� �ִ�.
// �̰��� �ڹٰ� ���� ��Ģ�̹Ƿ� �ܿ��� �Ѵ�.
// �ٷ� �ڱ� ������ ������ Ŭ������ �ݵ�� Cloneable �������̽� ��ӹ޾ƾ� �Ѵ�.


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
	// ������ �������̵带 �ϴ� ���� �ƹ����� ����� ��������.
	// �ڱ� ���� ���α׷��� ������ �Ѵ�.
	// ��ӹ��� Ŭ�������� ���� Ŭ������ ����� ������ ����ϴ� ����� �ϳ� �־���.
		
		Object temp = super.clone();
		return temp;
		
	}
}

