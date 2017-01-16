package P0113;
/*
 * 	불러오기와 저장하기 기능을 가진 간단한 메모장을 만들어보자.
 */
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import	java.io.*;
public class MemoTest01 {
	JTextArea		area;		//	내용을 입력할 도구
	JButton			saveB, loadB;
	MyJFrame		f;
	public MemoTest01() {
		f = new MyJFrame("메모장");
		area	= new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		
		saveB = new JButton("저장하기");
		loadB = new JButton("불러오기");
		
		MemoButtonEvent01	evt = new MemoButtonEvent01(this);
		saveB.addActionListener(evt);
		loadB.addActionListener(evt);
		
		JPanel	p = new JPanel();
		p.add(saveB);
		p.add(loadB);
		
		f.add("Center", sp);
		f.add("South", 	p);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new MemoTest01();
	}
	//	저장을 담당할 함수
	void saveProc() {
		//	할일
		//		저장할 파일의 정보를 알아낸다.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showSaveDialog(f);
		File	file = null;		//	선택한 파일의 정보를 기억할 변수
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		else {
			return;
		}
		//		그 파일에 내용을 저장한다.
		//			1.	스트림을 연결한다.
		FileOutputStream	fout = null;
		try {
			fout = new FileOutputStream(file);
			//	저장할 내용을 알아낸다.
			//	저장할 내용은 당근...	텍스트 에리어에 입력한 내용이다.
			String	str = area.getText();
			//			2.	내용을 기록한다.
			byte[]	buff = str.getBytes();
			fout.write(buff);
		}
		catch(Exception e) {
			System.out.println("에러 = " +  e);
		}
		finally  {
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
		
	}
	//	불러오기를 담당할 함수
	void loadProc() {
		//	할일
		//		불러오기할 파일의 정보를 알아낸다.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showOpenDialog(f);
		File	file = null;
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		else {
			return;
		}
		//		그 파일에서 내용을 읽어서 에리어에 출력한다.
		FileInputStream		fin = null;
		try {
			//		1.	스트림을 연결하고
			fin = new FileInputStream(file);
			//		2.	내용을 읽는다.
			//	내용을 출력하기 전에 먼저 내용을 지우고 시작하자.
			area.setText("");
			while(true) {
				byte[] buff = new byte[1024];
				int	len = fin.read(buff);
				if(len == -1) {
					break;
				}
				//	텍스트 에리어에 출력한다.(반복할때마다 추가해야 한다.)
				String	str = new String(buff, 0, len);
				area.append(str);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				fin.close();
			}
			catch(Exception e) {}
		}
	}
}
class MemoButtonEvent01 implements ActionListener {
	MemoTest01	main;
	public MemoButtonEvent01() {}
	public MemoButtonEvent01(MemoTest01 m) {
		main = m;
	}
	public void actionPerformed(ActionEvent e) {
		//	할일
		//		어느 단추에서 이벤트가 발생했는지를 알아내자
		JButton	target = (JButton) e.getSource();
		
		//		저장, 불러오기 작업을 진행하자.
		if(target == main.saveB) {
			//	이 클래스는 앞의 클래스와 상관없는 클래스이므로
			//	앞의 클래스의 멤버를 사용할 수 없다.
			//	저장하기 작업
			main.saveProc();
		}
		else {
			//	불러오기 작업
			main.loadProc();
		}
	}
}






