package chating;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientInfo {

	private Socket con;
	private String strIP;
	private BufferedWriter bw;
	
	public ClientInfo(Socket con) {
		this.con = con;
		//SOcket을 연결한 클라이엌트의 IP정보를 저장한다.
		strIP = con.getInetAddress().getHostAddress();
		
		//클라이언트에 문자열을 전송하기 위한 출력 스트림을 생성한다.
		try {
			bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		}catch(Exception e) {
		}
	}
	
	public boolean write(String str) {
		//인자로 받은 문자열을 출력 스트림을 사용한 전송한다.
		try {
			bw.write(str + "\n");
			bw.flush();
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public String getIP() {
		return strIP;
	}
}
