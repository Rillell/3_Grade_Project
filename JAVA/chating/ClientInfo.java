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
		//SOcket�� ������ Ŭ���̾�Ʈ�� IP������ �����Ѵ�.
		strIP = con.getInetAddress().getHostAddress();
		
		//Ŭ���̾�Ʈ�� ���ڿ��� �����ϱ� ���� ��� ��Ʈ���� �����Ѵ�.
		try {
			bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		}catch(Exception e) {
		}
	}
	
	public boolean write(String str) {
		//���ڷ� ���� ���ڿ��� ��� ��Ʈ���� ����� �����Ѵ�.
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
