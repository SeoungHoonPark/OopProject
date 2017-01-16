package P0116;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *	앞에서 만든 MyData에 정보를 채워서 파일에 그대로 저장해 보자
 */
public class ObjectTest01 {
	FileOutputStream fout = null;
	ObjectOutputStream oout = null;
	
	public ObjectTest01() {
	
			try{
				
			}
			catch(Exception e){
				try{
					fout = new FileOutputStream("D:\\오브젝트.txt");
					oout = new ObjectOutputStream(fout);
					MyData data = new MyData();
					data.name = "홍길동";
					data.age = 24;
					data.height = 176.3f;
					data.gender = true;
					data.tel = "010-222-4444";
					data.addr = "서울시 구로구";
					
					oout.writeObject(data);
					// 이처럼 클래스 전체를 입출력하는 행위를 직렬화라고 표현하나다.
					
					System.out.println("저장끝");
					
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
