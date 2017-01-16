package P0116;
import		java.io.*;
import		java.awt.*;
//	그림판에 그린 정보를 기억할 클래스
public class DrawInfo implements Serializable{
	int		x;
	int		y;
	int		width;
	int		height;
	Color	color;
}
