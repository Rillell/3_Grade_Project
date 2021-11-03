package week5;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame{
	private JCheckBox [] fruits = new JCheckBox[3];
	private String[] names = {"사과", "배", "체리"};
	
	private JLabel sumLabel;
	
	public CheckBoxItemEventEx() {
		setTitle("체크박스와 ItenEvent 예제");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("사과  100원, 배 500원, 체리 20000원"));
		
		//3개의 체크박스 컴포넌트 생성, 컴텐트팬에 삽입, Item리스너 들록
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]); //names[] 문자열로 체크박스 생성
			fruits[i].setBorderPainted(true); //체크박스의 외곽선이 보이도록 설정
			c.add(fruits[i]); //컨텐트 팬에 체크박스 삽입
			fruits[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("현재 0원입니다.");
		c.add(sumLabel);
		
		setVisible(true);
	}
	
	//리스너 구현
	class MyItemListener implements ItemListener{
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {  //체크박스가 선택되었을때
				if(e.getItem() == fruits[0])
					sum += 100;
				else if(e.getItem() == fruits[1])
					sum += 500;
				else
					sum += 20000;
			}
			else {
				if(e.getItem() == fruits[0])
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 20000;
			}
			sumLabel.setText("현재 " + sum + "원 입니다.");
			
		}
	}
	public static void main(String args[]) {
		new CheckBoxItemEventEx();
	}

}
