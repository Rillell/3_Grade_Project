package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;


public class NumericCalculatorInner extends JFrame{	
	private JTextField text;
	private JTextField text2;
	private JButton button;
	
	public NumericCalculatorInner() {
		//JFrame 속성지정
		this.setTitle("내부 사칙연산 계산기");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//JPanel 객체상자
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();		
		panel2.setLayout(new GridLayout(4, 4, 10, 5));	
		
		//Component 추가
		JLabel cal = new JLabel("수식 ");
		text = new JTextField("", 15);
		JLabel result = new JLabel("결과 ");
		text2 = new JTextField("", 15);

		//이벤트 리스너
		InnerListener listener = new InnerListener();
		InnerCEListener CE = new InnerCEListener();
		InnerEQListener EQ = new InnerEQListener();
		
		for(int i = 0; i<10; i++) {
			String number = Integer.toString(i);
			button = new JButton(number);
			//리스너 추가
			button.addActionListener(listener);
			panel2.add(button);
		}
		
		JButton ce = new JButton("CE");
		ce.addActionListener(CE);
		JButton equ = new JButton("=");
		equ.addActionListener(EQ);
		JButton plus = new JButton("+");
		plus.addActionListener(listener);
		JButton min = new JButton("-");
		min.addActionListener(listener);
		JButton mul = new JButton("X");
		mul.addActionListener(listener);
		JButton div = new JButton("/");
		div.addActionListener(listener);

		
		panel1.add(cal);
		panel1.add(text);
		panel1.add(result);
		panel1.add(text2);	

		panel2.add(ce);
		panel2.add(equ);
		panel2.add(plus);
		panel2.add(min);
		panel2.add(mul);
		panel2.add(div);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		
		this.setVisible(true);
			
	}
	//내부 리스너 구현
	private class InnerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			text.setText(text.getText()+command);			
		}		
	}
	private class InnerCEListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText("");
			text2.setText("");			
		}
		
	}
	private class InnerEQListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringTokenizer st = new StringTokenizer(text.getText(), "+-X/", true);
			
			int first = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int second = Integer.parseInt(st.nextToken());
			switch(op) {
			case "+" : text2.setText(first + second + ""); break;
			case "-" : text2.setText(first - second + ""); break;
			case "X" : text2.setText(first * second + ""); break;
			case "/" : text2.setText(first / second + ""); break;
			}		
		}		
	}

	public static void main(String[] args) {
		NumericCalculatorInner jft = new NumericCalculatorInner();

	}

}
