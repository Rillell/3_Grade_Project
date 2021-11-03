package chating;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

	public static void main(String[] args) {
		System.out.println("�ڹ� Ŀ��ŰƼ ä�� ���� v1.0");
		ServerSocket server = null;
		Vector conList = null;
		try {
			//9000�� ��Ʈ�� ����ϴ� ���� Socket�� �����Ѵ�.
			server = new ServerSocket(9000);
			conList = new Vector(10);
			
			while(true) {
				//Ŭ���̾�Ʈ�κ��� ���� ��û�� �߻��ϸ� ������ Ŭ���̾�Ʈ ���̿� 
				//���ο� ������ �����Ѵ�.
				Socket con = server.accept();
				
				//Ŭ���̾�Ʈ ������ �����ϴ� ClientInfoŬ������ �����ϰ� ����
				//��ü�� �����Ѵ�.
				ClientInfo client = new ClientInfo(con);
				conList.add(client);
				
				//�� SOcket�� ���� �۾��� ������ �����带 �����Ѵ�.
				ChatThread conThread = new ChatThread(con, conList);
				Thread t = new Thread(conThread);
				t.start();
				
				System.out.println(client.getIP() + "�� �����߽��ϴ�.");
			}
		}catch(Exception e) {
			try {
				//���� Socket�� ���ܰ� �߻��ϸ� Socket�� �ݰ� ���α׷��� �����Ѵ�.
				server.close();
				System.exit(0);
			}catch(Exception ioe) {				
			}
		}
	}
}
