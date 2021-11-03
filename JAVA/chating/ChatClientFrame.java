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
		this.setTitle(strName + "님의 채팅 클라이언트");
		this.setBounds(100, 100, 400, 300);
		
		taChat = new JTextArea();
		taChat.setEditable(false);
		tfChat = new JTextField(25);
		btSubmit = new JButton("전송");
		btSubmit.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(tfChat);
		pane.add(btSubmit);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(taChat, BorderLayout.CENTER);
		getContentPane().add(pane, BorderLayout.SOUTH);
		
		try {
			//서버로부터 문자열을 수신하기 위한 스레드를 생성한다.
			ListenThread listenThread = new ListenThread(con, this);
			Thread t = new Thread(listenThread);
			t.start();
			
			//서버에 문자열을 송신하기 위한 출력 스트림을 생성한다.
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
			//버튼이 클릭되면 텍스트 필드의 내용을 서버에 송신한다.
			bw.write(strName+" : "+tfChat.getText()+"\n");
			bw.flush();
			tfChat.setText("");
		}catch(Exception e) {
			//서버에 문자열을 송신할 수 없으면 스트림과 Socket을 닫고
			//프로그램을 종료한다.
		}try {
			bw.close();
			con.close();
		}catch(IOException ioe) {
		}
		System.exit(0);
		
	}


}
