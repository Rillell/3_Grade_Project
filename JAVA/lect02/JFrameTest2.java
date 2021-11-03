package lect02;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

//2. JFrame 상속을 통해서 생성
public class JFrameTest2 extends JFrame{
	public JFrameTest2() {
		//JFrame 속성지정
		this.setTitle("JFrame 상속 Test");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 누를떄 정상종료
		
		//배치관리자 설정
		this.setLayout(new FlowLayout());
		
		//Component 추가
		JButton btn = new JButton("테스트");
		JButton btnC = new JButton("취소");
		JButton btnP = new JButton("이전");
		
		btn.setSize(20, 20);
		btnC.setSize(20, 20);
		btnP.setSize(20, 20);
		
		this.add(btn); //컨테이너에 콤포넌트를 배치
		this.add(btnC);
		this.add(btnP);
			
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrameTest2 jft = new JFrameTest2();
	}
}
