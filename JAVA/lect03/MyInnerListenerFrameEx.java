package lect03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//1.내부 리스너 구현
public class MyInnerListenerFrameEx extends JFrame{
	//멤버변수
	private JButton btn = null;
	private JLabel label;
	//메서드
	
	//생성자
	public MyInnerListenerFrameEx() {
		this.setTitle("내부 리스너 구현 예제");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		
		//1)이벤트 소스결정 : JButton --> 
		//2)이벤트 종류 : Action Event -->AXtionListener구현
		btn = new JButton("Action");		
		label = new JLabel("버튼을 선택해 주세요!");
		//4) 이벤트 리스너 연결
		MyInnerListener listener = new MyInnerListener();
		btn.addActionListener(listener);
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	//3)리스너 구현 : 내부 리스너로 구현
	private class MyInnerListener implements ActionListener{

		@Override //컴파일러에게 재정의 메서드임을 알려주는 Annotation
		public void actionPerformed(ActionEvent e) {
			//JButton bt = (JButton)e.getSource();
			//if(bt.getText().equals("Action")) {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("확인");
				label.setText("Action 버튼이 선택되었습니다.");
			}
			else {
				btn.setText("Action");
				label.setText("확인 버튼이 선택되었습니다");
			}			
		}		
	}
	
	public static void main(String[] args) {
		MyInnerListenerFrameEx me = new MyInnerListenerFrameEx();
	}

}
