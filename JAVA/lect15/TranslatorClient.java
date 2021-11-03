package lect15;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//TCP socket : (1:n통신) ==> Thread로 처리
//Client Socket 생성
public class TranslatorClient extends JFrame{
	//멤버변수
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private JTextField field;
	private JTextArea area;
	
	//생성자
	public TranslatorClient() {
		this.setTitle("단어검색 Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		
		field = new JTextField(50);
		area = new JTextArea(10, 50);
		
		this.add(field, BorderLayout.NORTH);
		this.add(area, BorderLayout.CENTER);
		this.setVisible(true);
		
		//client Socket 생성
		try {
			socket = new Socket("localhost", 9990);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			area.append(in.readLine() + "\n");
			area.append(in.readLine() + "\n");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//field에 ActionListener추가
		field.addActionListener((e) -> {
			out.println(field.getText());
			String response = null;
			
			try {
				response = in.readLine();
				this.area.append(response + "\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
		});
		
	}
	
	public static void main(String[] args) {
		new TranslatorClient();
	}
}
