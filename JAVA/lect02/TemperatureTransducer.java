package lect02;
import java.awt.*;
import javax.swing.*;



public class TemperatureTransducer extends JFrame{
	public TemperatureTransducer() {
		//JFrame 속성지정
		this.setTitle("온도변환기");
		this.setSize(300, 180);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//JPanel 객체상자
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		//Component 추가
		JLabel label1 = new JLabel("화씨 온도 ");
		JTextField text1 = new JTextField("", 15);
		JLabel label2 = new JLabel("섭씨 온도 ");
		JTextField text2 = new JTextField("", 15);
		JButton btn = new JButton("변환");
	
		btn.setSize(20, 20);
		
		panel1.add(label1); //컨테이너에 콤포넌트를 배치
		panel1.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel3.add(btn);
		
		//JFrmae에 JPanel 배치
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
				
		this.setVisible(true);
	}
		public static void main(String[] args) {	
			TemperatureTransducer jft = new TemperatureTransducer();
	}

}
