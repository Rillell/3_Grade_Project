package chating;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenThread implements Runnable{
	
	private Socket con;
	private ChatClientFrame frm;
	private BufferedReader br;
	
	public ListenThread(Socket con, ChatClientFrame frm) {
		this.con = con;
		this.frm = frm;
		
		try {
			//인자로 받은 Socket에 대한 입력 스트림을 만든다.
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}catch(Exception e) {
		}
	}

	//스레드가 시작되면 run()메서드의 내용이 실행된다.
	@Override
	public void run() {
		while(true) {
			//서버로부터 받은 내용을 읽어 클라이언트의 텍스트 에어리어에 적는다.
			try {
				frm.writeTextArea(br.readLine());
			}catch(Exception e) {
			}
		}
		
	}

}
