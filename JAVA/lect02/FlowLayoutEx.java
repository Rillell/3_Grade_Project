package lect02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame{
	
	public FlowLayoutEx() {
		this.setTitle("FlowLayout 예제");
		this.setBounds(50, 50, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배치관리자 JFrame => BorderLayout => FowLayout으로 변경
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		
		//Component 생성 및 배치
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
