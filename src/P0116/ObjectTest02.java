package P0116;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *	앞에서 저장한 클래스를 읽어서 변수의 값을 출력해 보자
 */
public class ObjectTest02 {
	
	FileInputStream fin = null;
	ObjectInputStream oin = null;
	
	public ObjectTest02() {
		
			try{
				fin = new FileInputStream("D:\\오브젝트.txt");
				oin = new ObjectInputStream(fin);
				
				// 클래스를 통채로 읽는다.
				
				MyData temp = (MyData) oin.readObject();
				
				System.out.println("이름은 " + temp.name);
				System.out.println("나이는 " + temp.age);
				System.out.println("신장은 " + temp.height);
				System.out.println("성별은 " + temp.gender);
				System.out.println("전번은 " + temp.tel);
				System.out.println("주소는 " + temp.addr);
				
			}catch(Exception e){
				
			}finally {
				try{
					oin.close();
					fin.close();
				}catch(Exception e){}
			}
	}

	public static void main(String[] args) {
		new ObjectTest02();
	}
}
