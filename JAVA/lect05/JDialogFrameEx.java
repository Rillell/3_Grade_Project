package lect05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

//JDialog �ۼ�
class MyJDialog extends JDialog{
	//�������
	private JTextField field = new JTextField(10);
	private JButton btnOk = new JButton("OK");
	
	//������
	public MyJDialog(JFrame frame, String title) {
		//super(frame, title, true);  //true: JDialog�� Modal ������� ������
		super(frame, title); //Modalless��� �۾��� �־ ������
		this.setLayout(new FlowLayout());
		this.add(field);
		this.add(btnOk);
		this.setSize(300, 150);
		
		//������ ����
		btnOk.addActionListener((ActionEvent e)->{this.setVisible(false);});
	}
	//�޼��� : �ؽ�Ʈ�ʵ忡 �Էµ� ���� JFrame�� �Ѱ��ֵ���
	public String getInput() {
		if(field.getText().length() == 0) return null;
		else return field.getText();
	}
	
}

//JFrame UI�ۼ�
public class JDialogFrameEx extends JFrame{	
	//�������
	//������
	public JDialogFrameEx() {
		this.setTitle("JDialog Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		//��ư
		JButton btn = new JButton("Open JDialog");
		
		//������ ���� --> JDialog Open
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
