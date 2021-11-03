package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class TemperatureTransducer extends JFrame{
	public TemperatureTransducer() {
		//JFrame 속성지정
		this.setTitle("온도변환기(익명리스너)");
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
		
		//익명리스너 추가
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			if(text2.getText().equals("")) {
				double f =Double.parseDouble(text1.getText());
				double c=(f-32)*5/9;
				text2.setText(String.format("%4.2f", c));
			}
			else{
				double c2 =Double.parseDouble(text2.getText());
				double f2= c2*1.8 + 32;
				text1.setText(String.format("%4.2f", f2));	
			}
				
			}
			
		});
		
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
