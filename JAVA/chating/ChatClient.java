package chating;

import java.net.Socket;

public class ChatClient {
	private Socket con = null;
	private String strIP = null;
	private int intPort = 0;
	private String strName = null;
	//äƿ Ŭ���ƾ�Ʈ �ʱ�ȭ
	public void init() {
		//������ �ּҿ� ��Ʈ ��ȣ�� �Է¹޴� ���̾� �α�
		ServerInfoDialog serverDig = new ServerInfoDialog(this);
		serverDig.setModal(true);
		serverDig.setVisible(true);
		serverDig.show(true);
		
		//ä�ÿ��� ������ �̸��� �Է¹޴� ���̾�α�
		NameInputDialog nameDig = new NameInputDialog(this);
		nameDig.setModal(true);
		nameDig.setVisible(true);
		nameDig.show(true);
		
		//�Էµ� ������ �ּҿ� ��Ʈ��ȣ�� Socket�� �����Ѵ�.
		try {
			con = new Socket(strIP, intPort);
		}catch(Exception e) {
			System.exit(0);
		}
		
		//������ Socket�� ä�ÿ��� ����� �̸��� ���ڷ� ���ο�
		//ä���� �������� �����Ѵ�.
		ChatClientFrame mainFrm = new ChatClientFrame(con, strName);
		mainFrm.setVisible(true);
		mainFrm.show(true);
	}

	//�ʱ�ȭ ���� ��� �ǿ쿡 �����ϴ� set�޼���
	public void setIp(String strIP) {
		this.strIP = strIP;
	}
	public void setPort(int intPort) {
		this.intPort = intPort;
	}
	public void setName(String strName) {
		this.strName = strName;
	}
		
	
	public static void main(String args[]) {
		ChatClient client = new ChatClient();
		client.init();
	}
}






