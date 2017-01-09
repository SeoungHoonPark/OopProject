package P0109;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import GUI.MyJFrame;

/**
 * 위쪽에 콤보상자를 만들고 아래쪽에 텍스트 필드를 만든 후 콤보상자에서 뭔가를
 * 선택하면 선택한 항목에 아래쪽에 출력되도록 하자 
 * 
 */
public class Test01 {
	JComboBox box;
	JTextField field;
	
	public Test01() {
		MyJFrame f = new MyJFrame();
		// 배치전략은 border로 하기로 하고 생략해도 된다.
		
		String[] items = {"김하늘", "김아중", "전지현", "이유정", "아이유"};
		box = new JComboBox(items);
		field = new JTextField();
		
		f.add("North", box);
		f.add("South", field);
		
		f.setSize(400,500);
		f.setVisible(true);
		
		box.addItemListener(new ComboEvnet());
				
	}


	public static void main(String[] args) {
		new Test01();
	}
	
	class ComboEvnet  implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			String item = (String) box.getSelectedItem();
			//이 내용을 아래쪽에 출력한다.
			
			field.setText(item + "이 선택되었습니다.");
			
		}
	}
	
}

