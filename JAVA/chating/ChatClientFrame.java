package chating;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame implements ActionListener{
	private static final long serialVeraionUID = 1L;
	private Socket con;
	private String strName;
	private BufferedWriter bw;
	private JTextArea taChat;
	private JTextField tfChat;
	private JButton btSubmit;
	
	public ChatClientFrame(Socket con, String strName) {
		this.con = con;
		this.strName = strName;
		this.setTitle(strName + "���� ä�� Ŭ���̾�Ʈ");
		this.setBounds(100, 100, 400, 300);
		
		taChat = new JTextArea();
		taChat.setEditable(false);
		tfChat = new JTextField(25);
		btSubmit = new JButton("����");
		btSubmit.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(tfChat);
		pane.add(btSubmit);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(taChat, BorderLayout.CENTER);
		getContentPane().add(pane, BorderLayout.SOUTH);
		
		try {
			//�����κ��� ���ڿ��� �����ϱ� ���� �����带 �����Ѵ�.
			ListenThread listenThread = new ListenThread(con, this);
			Thread t = new Thread(listenThread);
			t.start();
			
			//������ ���ڿ��� �۽��ϱ� ���� ��� ��Ʈ���� �����Ѵ�.
			bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		}catch(Exception e) {		
		}
	}
	
	public void writeTextArea(String str) {
		taChat.append(str + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			//��ư�� Ŭ���Ǹ� �ؽ�Ʈ �ʵ��� ������ ������ �۽��Ѵ�.
			bw.write(strName+" : "+tfChat.getText()+"\n");
			bw.flush();
			tfChat.setText("");
		}catch(Exception e) {
			//������ ���ڿ��� �۽��� �� ������ ��Ʈ���� Socket�� �ݰ�
			//���α׷��� �����Ѵ�.
		}try {
			bw.close();
			con.close();
		}catch(IOException ioe) {
		}
		System.exit(0);
		
	}


}
