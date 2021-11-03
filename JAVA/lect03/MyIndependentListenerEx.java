package lect03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//2. 독립리스너 구현
public class MyIndependentListenerEx extends JFrame{
	//멤버변수
	private JButton btn;
	private JLabel label;
	//메서드
	
	
	//생성자
	public MyIndependentListenerEx() {
		this.setTitle("독립 리스너 구현 예제");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		//1) 이벤트 소스 결정 : JButton
		//2) 이벤트 종류 결정 : ActionEvent -> ActionListener 구현
		btn = new JButton("Action");
		//4) 이벤트 소스에 이벤트리스너 객체 연결
		MyIndependentListener ml = new MyIndependentListener(this);
		btn.addActionListener(ml);
		label = new JLabel("버튼을 선택해 주세요!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public JButton getBtn() {
		return btn;
	}
	public JLabel getLabel() {
		return label;
	}

	public static void main(String[] args) {
		MyIndependentListenerEx me = new MyIndependentListenerEx();
	}

}
