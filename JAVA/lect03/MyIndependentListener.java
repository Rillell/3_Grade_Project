package lect03;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//2. 독립 리스너 클래스 구현

//3)리스너 클래스 구현
public class MyIndependentListener implements ActionListener{
	//멤버변수
	MyIndependentListenerEx frame;
	//생성자
	public MyIndependentListener(MyIndependentListenerEx frame) {
		this.frame = frame;
	}
	
	//메서드
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("Action")){
		frame.getBtn().setText("액션");
		frame.getLabel().setText("Action버튼이 선택되었습니다");
	}
		else {
			frame.getBtn().setText("Action");
			frame.getLabel().setText("액션 버튼이 선택되었습니다.");		
	}
}
}