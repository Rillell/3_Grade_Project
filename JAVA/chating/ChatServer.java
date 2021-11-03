package chating;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

	public static void main(String[] args) {
		System.out.println("자바 커뮤키티 채팅 서버 v1.0");
		ServerSocket server = null;
		Vector conList = null;
		try {
			//9000번 포트를 사용하는 서버 Socket을 생성한다.
			server = new ServerSocket(9000);
			conList = new Vector(10);
			
			while(true) {
				//클라이언트로부터 접속 요청이 발생하면 서버와 클라이언트 사이에 
				//새로운 소켓을 생성한다.
				Socket con = server.accept();
				
				//클라이언트 정보를 저장하는 ClientInfo클래스를 생성하고 백터
				//객체에 저장한다.
				ClientInfo client = new ClientInfo(con);
				conList.add(client);
				
				//각 SOcket에 대한 작업을 수행할 쓰레드를 생성한다.
				ChatThread conThread = new ChatThread(con, conList);
				Thread t = new Thread(conThread);
				t.start();
				
				System.out.println(client.getIP() + "가 접속했습니다.");
			}
		}catch(Exception e) {
			try {
				//서버 Socket에 예외가 발생하면 Socket을 닫고 프로그램을 종료한다.
				server.close();
				System.exit(0);
			}catch(Exception ioe) {				
			}
		}
	}
}
