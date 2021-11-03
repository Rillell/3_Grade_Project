package lect02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame{
	
	public FlowLayoutEx() {
		this.setTitle("FlowLayout ����");
		this.setBounds(50, 50, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ġ������ JFrame => BorderLayout => FowLayout���� ����
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		
		//Component ���� �� ��ġ
		JButton btnAdd = new JButton("ADD");
		JButton btnSub = new JButton("SUB");
		JButton btnMul = new JButton("MUL");
		JButton btnDiv = new JButton("DIV");
		JButton btnExe = new JButton("EXE");
		
		this.add(btnAdd);
		this.add(btnSub);
		this.add(btnMul);
		this.add(btnDiv);
		this.add(btnExe);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FlowLayoutEx ble = new FlowLayoutEx();
	}

}
