package P1219;

/**
 *	문제 
 * 짝수이면 son1을 홀수이면 son2
 * 를 만들어주는 함수를 만드세요.
 */
public class Test04 {
	static  Father04 makeSon(){
		int num = (int)(Math.random() * 101);
		
		Father04 f = null;
		
		if(num % 2 == 0){
			f  = new Son041();
		}else{
			f  = new Son042();			
		}
		return f;
	}
	
	public static void main(String[] args) {
		Father04 f = makeSon();
		if(f instanceof Son041){
			Son041 s = (Son041) f;
			s.abc();
		}else{
			Son042 s = (Son042) f;
			s.xyz();
		}
	}
}

class Father04{
}

class Son041 extends Father04{
	void abc(){
		System.out.println("나는 son1이다");
	}
}

class Son042 extends Father04{
	void xyz(){
		System.out.println("나는 son2이다");
	}
}