package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;

public class NumericCalculatorInde extends JFrame{	
	private JButton ce, equ;
	private JTextField text, text2;
	
	public NumericCalculatorInde() {
		//JFrame �Ӽ�����
		this.setTitle("���� ��Ģ���� ����");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//JPanel ��ü����
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();		
		panel2.setLayout(new GridLayout(4, 4, 10, 5));	
		
		//Component �߰�
		JLabel cal = new JLabel("���� ");
		text = new JTextField("", 15);
		JLabel result = new JLabel("��� ");
		text2 = new JTextField("", 15);

		//������
		numIndepent li = new numIndepent(this);
		
		for(int i = 0; i<10; i++) {
			String number = Integer.toString(i);
			JButton button = new JButton(number);
			//������ �߰�
			button.addActionListener(li);
			panel2.add(button);
		}
		
		ce = new JButton("CE");
		ce.addActionListener(li);
		equ = new JButton("=");
		equ.addActionListener(li);
		JButton plus = new JButton("+");
		plus.addActionListener(li);
		JButton min = new JButton("-");
		min.addActionListener(li);
		JButton mul = new JButton("X");
		mul.addActionListener(li);
		JButton div = new JButton("/");
		div.addActionListener(li);
		
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
	
	public JButton getCe() {
		return ce;
	}
	public JButton getEqu() {
		return equ;
	}
	public JTextField getText() {
		return text;
	}
	public JTextField getText2() {
		return text2;
	}

	public static void main(String[] args) {
		NumericCalculatorInde jft = new NumericCalculatorInde();

	}
}

//���� ������ �ۼ�


