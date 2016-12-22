package P1213;

/**
 * this(µð½º)
 */
public class This01 {
	public static void main(String[] args) {
		Sam011 s1 = new Sam011();
		Sam011 s2 = new Sam011();		
		
		s1.setNum(10);
		s2.setNum(50);
		
		s1.display();
		s2.display();
	}
}

class Sam011{
	int num;
	
	void setNum(int n){
		this.num = n;
	}
	
	int getNum(){
		return this.num;
	}
	
	void display(){
		int no = this.getNum();
		System.out.println("num =" + num);
	}
}
