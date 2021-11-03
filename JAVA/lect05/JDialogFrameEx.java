package lect05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

//JDialog 작성
class MyJDialog extends JDialog{
	//멤버변수
	private JTextField field = new JTextField(10);
	private JButton btnOk = new JButton("OK");
	
	//생성자
	public MyJDialog(JFrame frame, String title) {
		//super(frame, title, true);  //true: JDialog를 Modal 방식으로 열어줌
		super(frame, title); //Modalless방식 작업에 있어서 독립적
		this.setLayout(new FlowLayout());
		this.add(field);
		this.add(btnOk);
		this.setSize(300, 150);
		
		//리스너 연결
		btnOk.addActionListener((ActionEvent e)->{this.setVisible(false);});
	}
	//메서드 : 텍스트필드에 입력된 값을 JFrame에 넘겨주도록
	public String getInput() {
		if(field.getText().length() == 0) return null;
		else return field.getText();
	}
	
}

//JFrame UI작성
public class JDialogFrameEx extends JFrame{	
	//멤버변수
	//생성자
	public JDialogFrameEx() {
		this.setTitle("JDialog Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		//버튼
		JButton btn = new JButton("Open JDialog");
		
		//리스너 연결 --> JDialog Open
		MyJDialog dialog = new MyJDialog(this, "Modal Dialog");
		btn.addActionListener((ActionEvent e)->{
			dialog.setVisible(true);
			
			String text = dialog.getInput();
			if(text == null) return;
			btn.setText(text);
		});
		
		this.add(btn, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JDialogFrameEx();
	}
}
