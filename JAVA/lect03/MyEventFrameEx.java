package lect03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyEventFrameEx extends JFrame{
	//멤버변수
	private JButton btn = null;
	private JLabel label;
	//메서드
	
	//생성자
	public MyEventFrameEx() {
		this.setTitle("리스너 구현 예제");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		label = new JLabel("버튼을 선택해 주세요!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyEventFrameEx me = new MyEventFrameEx();
	}

}
