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
		
		//Ŭ���̾�Ʈ�κ��� ���۵� ������ �о���� ���� �Է� ��Ʈ���� �����Ѵ�.
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
				//Ŭ���̾�Ʈ�κ��� ���ڿ��� �о�´�.
				str = br.readLine();
			}catch(Exception e) {
				break;
			}
			
			for(int i = 0; i< conList.size(); i++) {
				//�о�� ���ڿ��� ���Ͱ�ü�� ����� �� Ŭ���̾�Ʈ�� �����Ѵ�.
				ClientInfo client = (ClientInfo)conList.get(i);
				client.write(str);
			}
		}
		try {
			//���ܰ� �߻��Ͽ� while������ ����Ǹ� ��Ʈ���� Socket�� �ݴ´�.
			br.close();
			con.close();
		}catch(Exception e) {
		}
		
	}

}
