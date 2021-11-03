package week5;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class ToolTipDeave extends JFrame{
	public ToolTipDeave() {
		setTitle("툴팁 지연 기산 제어 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//체리 이미지 레이블 생성
		JLabel cherryLabel = new JLabel(new ImageIcon("./images/cherry.jpg"));
		cherryLabel.setToolTipText("체리 이미지 어떄요");  //툴팁달기
		
		//사과 이미지 레이블 생성
		JLabel appleLabel = new JLabel(new ImageIcon("./images/apple.jpg"));
		appleLabel.setToolTipText("사과 이미지 어때요");
		
		c.add(cherryLabel);
		c.add(appleLabel);
		
		//툴팁 매니저 객체
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);  //초기 튤팁 출력 지연 시간 0초
		m.setDismissDelay(10000);  // 튤팁 지속 시간 10초
		
		setSize(400, 220);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ToolTipDeave();
	}
}
