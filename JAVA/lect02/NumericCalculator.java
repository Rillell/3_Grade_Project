package lect02;
import java.awt.*;
import javax.swing.*;

public class NumericCalculator extends JFrame{
	public NumericCalculator() {
		//JFrame 속성지정
		this.setTitle("사칙연산 계산기");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//JPanel 객체상자
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();		
		panel2.setLayout(new GridLayout(4, 4, 10, 5));	
		
		//Component 추가
		JLabel cal = new JLabel("수식 ");
		JTextField text = new JTextField("", 15);
		JLabel result = new JLabel("결과 ");
		JTextField text2 = new JTextField("", 15);

		/*JButton zero = new JButton("0");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton thr = new JButton("3");
		JButton four = new JButton("4");
		JButton fiv = new JButton("5");
		JButton six = new JButton("6");
		JButton sev = new JButton("7");
		JButton eig = new JButton("8");
		JButton nin = new JButton("9");*/
		for(int i = 0; i<10; i++) {
			String number = Integer.toString(i);
			JButton button = new JButton(number);
			panel2.add(button);
		}
		JButton ce = new JButton("CE");
		JButton equ = new JButton("=");
		JButton plus = new JButton("+");
		JButton min = new JButton("-");
		JButton mul = new JButton("X");
		JButton div = new JButton("/");
		
		panel1.add(cal);
		panel1.add(text);
		panel1.add(result);
		panel1.add(text2);	
		/*panel2.add(zero); //컨테이너에 콤포넌트를 배치
		panel2.add(one);
		panel2.add(two);
		panel2.add(thr);
		panel2.add(four);
		panel2.add(fiv);
		panel2.add(six);
		panel2.add(sev);
		panel2.add(eig);
		panel2.add(nin);*/
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

	public static void main(String[] args) {
		NumericCalculator jft = new NumericCalculator();

	}

}
