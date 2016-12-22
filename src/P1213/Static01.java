package P1213;

/**
 *
 */
public class Static01 {
	public static void main(String[] args) {
		
//		Sam031 s = null;
		Sam031  s = new Sam031();
		s.kor= 10;
		s.num=10;
		System.out.println(s.kor + " " + Sam031.num);
	}
}

class Sam031{
	static int num;
	int kor;
}
