package	NETData;
import		java.io.*;
//	클라이언트와 서버 사이에는 이 클래스만 가지고 통신할 예정이다.
//	하지만 이 클래스 안에 나머지 부가적인 기능을 제공하는 클래스를
//	멤버로 가지게 했으므로..
//	이 클래스만 통신하면
//	나머지 3개의 클래스가 같이 붙어서 가게된다.
public class MainData implements Serializable {
	public	int			protocol;	//	사용자 프로토콜
	public	boolean		isSuccess;	//	작업 성공 여부를 파악 변수
	public	ChatData	chatD;
	public	LoginData	loginD;
	public	FileData	fileD;
}
