package	NETData;
import		java.io.*;
import		java.util.*;
public class FileData implements Serializable {
	public	String	fileName;	//	파일 이름을 기억할 변수
	public	byte[] buff;		//	파일 내용을 기억할 변수
	public	Vector	list;		//	파일 목록을 기억할 변수
	//	서버는 자신이 가지고 있는 목록을 이 변수에 채워서
	//	클라이언트에게 응답할 예정이다.
}
