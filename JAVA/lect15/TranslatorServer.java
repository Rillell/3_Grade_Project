package lect15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

//TCP socket : (1:n통신) ==> Thread로 처리

//Server: 번역기 역할(Client 요청에 대해)

public class TranslatorServer {
	//멤버변수
	ServerSocket listener = null;
	int clientId = 0; //socket 요청이 들어온 client id : 1부터 순차적으로 부여
	static Logger logger = Logger.getLogger("TranslateLog");
	
	//생성자
	public TranslatorServer() {
		logger.getGlobal().info("영어번역기 서버 시작!!");
		
		try {			
			listener = new ServerSocket(9990);	
			logger.info("ServerSocket 생성!");
			while(true) {
				clientId++;
				//client의 요청이 들어올 때 마다 socket을 생성하고 Thread 기동
				//Thread에게 socket객체와 clientId를 넘겨주도록
				Thread th = new Thread(new Translator(listener.accept(), clientId));
				th.start();
			}
			
			
		}catch (IOException e) {
			logger.info("ServerSocket 생성 중 오류!!" + e.getMessage());
		}
		finally {
			try {
				listener.close();
			} catch (IOException e) {
				logger.info("ServerSocket 종료 중 오류!!" + e.getMessage());
			}
		}   
	}
	
	public static void main(String[] args) {
		new TranslatorServer();
	}
}


//client연결 socket으로 client와 스트림으로 송수신
class Translator implements Runnable{
	//멤버변수
	private Socket socket = null;
	private int myId;
	BufferedReader in = null;
	PrintWriter out = null;
	
	//생성자
	public Translator(Socket socket, int myId) {
		this.socket = socket;
		this.myId = myId;
	}
	
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		
			out.println("안녕하세요! 클라이언트 번호는 " + this.myId + "입니다.");
			System.out.println("클라이언트번호:" + this.myId);
			out.println("검색할 단어를 입력하세요!");
			
			String input = "";
			while(true) {
				input = in.readLine();
				if(input ==  null) break;
				System.out.println(this.myId + "가 입력한 단어는 : " + input);
				//단어검색 루틴 :구체화해서 구현할 로직
				if(input.equalsIgnoreCase("java")) {
					out.println("java-> 자바");
				}
				else {
					out.println("너무어려워요...쉬운 단어로....부탁해요!!");
				}
			}					
		} catch (IOException e) {
			Logger.getGlobal().info(this.myId+"Thrad 실행중 오류" + e.getMessage());
		}
		finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				Logger.getGlobal().info(this.myId+"Socket 종료중 오류" + e.getMessage());
			}
		}	
	}	
}









