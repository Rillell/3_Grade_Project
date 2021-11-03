package chating;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

public class ChatThread implements Runnable{

	private Socket con = null;
	private BufferedReader br = null;
	private Vector conList = null;
	
	public ChatThread(Socket con, Vector conList) {
		this.con = con;
		this.conList = conList;
		
		//클라이언트로부터 전송되 내용을 읽어오기 위한 입력 스트림을 생성한다.
		try {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}catch(Exception e) {
		}
	}
	
	@Override
	public void run() {
		while(true) {
			String str = null;
			try {
				//클라이언트로부터 문자열을 읽어온다.
				str = br.readLine();
			}catch(Exception e) {
				break;
			}
			
			for(int i = 0; i< conList.size(); i++) {
				//읽어온 문자열을 벡터객체에 저장된 각 클라이언트에 전송한다.
				ClientInfo client = (ClientInfo)conList.get(i);
				client.write(str);
			}
		}
		try {
			//예외가 발생하여 while루프가 종료되면 스트림과 Socket를 닫는다.
			br.close();
			con.close();
		}catch(Exception e) {
		}
		
	}

}
