package P0116;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *	�տ��� ������ Ŭ������ �о ������ ���� ����� ����
 */
public class ObjectTest02 {
	
	FileInputStream fin = null;
	ObjectInputStream oin = null;
	
	public ObjectTest02() {
		
			try{
				fin = new FileInputStream("D:\\������Ʈ.txt");
				oin = new ObjectInputStream(fin);
				
				// Ŭ������ ��ä�� �д´�.
				
				MyData temp = (MyData) oin.readObject();
				
				System.out.println("�̸��� " + temp.name);
				System.out.println("���̴� " + temp.age);
				System.out.println("������ " + temp.height);
				System.out.println("������ " + temp.gender);
				System.out.println("������ " + temp.tel);
				System.out.println("�ּҴ� " + temp.addr);
				
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
