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
			//���ڷ� ���� Socket�� ���� �Է� ��Ʈ���� �����.
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}catch(Exception e) {
		}
	}

	//�����尡 ���۵Ǹ� run()�޼����� ������ ����ȴ�.
	@Override
	public void run() {
		while(true) {
			//�����κ��� ���� ������ �о� Ŭ���̾�Ʈ�� �ؽ�Ʈ ���� ���´�.
			try {
				frm.writeTextArea(br.readLine());
			}catch(Exception e) {
			}
		}
		
	}

}
