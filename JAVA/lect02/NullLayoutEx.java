package lect02;

import javax.swing.JButton;
import javax.swing.JFrame;  //ctrl shift o

public class NullLayoutEx extends JFrame{
	//멤버변수(속성)
	//메서드
	//생성자
	public NullLayoutEx(){
		this.setTitle("Null 배치관리자 적용");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배치관리자 NULL설정
		this.setLayout(null);
		
		for(int i=1; i<=10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			this.add(btn);
			//배치조정
			btn.setSize(50, 30);
			btn.setLocation(i*30, i*30);
		}
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		NullLayoutEx nl = new NullLayoutEx();
	}

}
