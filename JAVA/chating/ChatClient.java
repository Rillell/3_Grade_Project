package chating;

import java.net.Socket;

public class ChatClient {
	private Socket con = null;
	private String strIP = null;
	private int intPort = 0;
	private String strName = null;
	//채틸 클리아언트 초기화
	public void init() {
		//서버의 주소와 포트 번호를 입력받는 다이얼 로그
		ServerInfoDialog serverDig = new ServerInfoDialog(this);
		serverDig.setModal(true);
		serverDig.setVisible(true);
		serverDig.show(true);
		
		//채팅에서 샤용할 이름을 입력받는 다이얼로그
		NameInputDialog nameDig = new NameInputDialog(this);
		nameDig.setModal(true);
		nameDig.setVisible(true);
		nameDig.show(true);
		
		//입력된 서버의 주소와 포트번호로 Socket을 생성한다.
		try {
			con = new Socket(strIP, intPort);
		}catch(Exception e) {
			System.exit(0);
		}
		
		//생성된 Socket과 채팅에서 사용할 이름을 인자로 새로운
		//채팅할 프레임을 생성한다.
		ChatClientFrame mainFrm = new ChatClientFrame(con, strName);
		mainFrm.setVisible(true);
		mainFrm.show(true);
	}

	//초기화 값을 멤버 녓우에 저장하는 set메서드
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






