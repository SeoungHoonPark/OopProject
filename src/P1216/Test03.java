package P1216;

import P1214.MyFrame;

/**
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Sam031 s = new Sam031();
		//s.age = -100;
		
		s.setAge(-100);
		
		System.out.println(s.getAge());
	}
}

class Sam031{
	static private  int age;
	
	public void setAge(int age){
		if(age < 0){
			this.age = -age;
		}else{
			this.age = age;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	
}