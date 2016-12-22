package P1209;
public class Test03 {
	public static void main(String[] args) {
		
		Sam031  s1= new Sam031();
		Sam031  s2= new Sam031();
		
		s1.a = 10;
		s2.a = 100;
						
		s1.Display(); // 10
		s2.Display();	// 100
		
	}
}

class Sam031{
	int a;
	float b;
	void setA(int x){
		a = x;
	}
	void Display(){
		System.out.println("A = " + a);
	}
}