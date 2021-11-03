package lect04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//5. 람다식으로 리스너 구현
public class MyLamdaListenerEx extends JFrame{
	//멤버변수
	private JButton btn = null;
	private JLabel label;
	//메서드
	
	//생성자
	public MyLamdaListenerEx() {
		this.setTitle("리스너 구현 예제 : 람다식으로 구현");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		//1)이벤트 소스 결정 : JButton
		//2)이변트 종류 결정 : ActionEvent ->
		//3)람다식으로 리스너 구현
		/*함수형 interface
		 * interface ActionListener{
		 * public void actionPerformed(ActionEvent e);
		 * }
		 */
		/*ActionListener ll = (ActionEvent e) -> {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("액션");
				label.setText("Action버튼이 선택되었습니다.");
			}
			else {
				btn.setText("Action");
				label.setText("액션버튼이 선택되었습니다.");
			}
		};
		*/
		//4) 리스너 연결
		//btn.addActionListener(ll);
		
		btn.addActionListener((ActionEvent e) -> {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("액션");
				label.setText("Action버튼이 선택되었습니다.");
			}
			else {
				btn.setText("Action");
				label.setText("액션버튼이 선택되었습니다.");
			}
		});
		
		label = new JLabel("버튼을 선택해 주세요!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyLamdaListenerEx me = new MyLamdaListenerEx();
	}

}
