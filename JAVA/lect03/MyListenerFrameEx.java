package lect03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//3. Frame을 리스너클래스로 구현
public class MyListenerFrameEx extends JFrame implements ActionListener{
	//멤버변수
	private JButton btn = null;
	private JLabel label;
	//메서드
	
	//생성자
	public MyListenerFrameEx() {
		this.setTitle("프레임 자체 리스너 구현 예제");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		//1) 이벤트 소스결정
		//2)
		btn = new JButton("Action");
		//4) 이벤트 연결
		btn.addActionListener(this);
		label = new JLabel("버튼을 선택해 주세요!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}

	//3)리스너 구현(재정의)
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Action")) {
			btn.setText("확인");
			label.setText("Action버튼이 선택되었습니다.");
		}
		else {
			btn.setText("Action");
			label.setText("액션버튼이 선택되었습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		MyListenerFrameEx me = new MyListenerFrameEx();
	}


}
