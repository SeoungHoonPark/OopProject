package P0116;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *	�տ��� ���� MyData�� ������ ä���� ���Ͽ� �״�� ������ ����
 */
public class ObjectTest01 {
	FileOutputStream fout = null;
	ObjectOutputStream oout = null;
	
	public ObjectTest01() {
	
			try{
				
			}
			catch(Exception e){
				try{
					fout = new FileOutputStream("D:\\������Ʈ.txt");
					oout = new ObjectOutputStream(fout);
					MyData data = new MyData();
					data.name = "ȫ�浿";
					data.age = 24;
					data.height = 176.3f;
					data.gender = true;
					data.tel = "010-222-4444";
					data.addr = "����� ���α�";
					
					oout.writeObject(data);
					// ��ó�� Ŭ���� ��ü�� ������ϴ� ������ ����ȭ��� ǥ���ϳ���.
					
					System.out.println("���峡");
					
				}catch(Exception ee){
					
				}
			}finally{
				try{
					oout.close();
					fout.close();
				}catch(Exception e){
					
				}
			}
	}

	public static void main(String[] args) {
		new ObjectTest01();
	}
}
