package	NETData;
import		java.io.*;
//	Ŭ���̾�Ʈ�� ���� ���̿��� �� Ŭ������ ������ ����� �����̴�.
//	������ �� Ŭ���� �ȿ� ������ �ΰ����� ����� �����ϴ� Ŭ������
//	����� ������ �����Ƿ�..
//	�� Ŭ������ ����ϸ�
//	������ 3���� Ŭ������ ���� �پ ���Եȴ�.
public class MainData implements Serializable {
	public	int			protocol;	//	����� ��������
	public	boolean		isSuccess;	//	�۾� ���� ���θ� �ľ� ����
	public	ChatData	chatD;
	public	LoginData	loginD;
	public	FileData	fileD;
}
