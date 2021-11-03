package week5;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame{
	public RadioButtonEx() {
		this.setTitle("라디오버튼 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 150);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();
		
		//라디오버튼 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);  //배가 선택된 상태
		JRadioButton cherry = new JRadioButton("체리");
		
		//버튼 그룹에 라디오버튼 삽입
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		c.add(apple);    c.add(pear);   c.add(cherry);   //컨텐트팬에 라디오버튼 삽입, 컴텐트팬에 삽입되어야 화면에 출력됨.
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
