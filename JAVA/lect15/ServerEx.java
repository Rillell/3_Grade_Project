package lect15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

//TCPSocket : (1:1 통신)
//Server Socket
public class ServerEx {
	//멤버변수
	ServerSocket listener = null;
	Socket socket = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	Scanner scanner = new Scanner(System.in);
	Logger logger = Logger.getLogger("serverlog");
	
	//생성자
	public ServerEx() {
		//1.서버소켓소켓을 뛰움
		try {
			listener = new ServerSocket(9999);
			logger.getGlobal().info("서버소켓소켓 연결");
			//2.client 요청을 기다렸다 요청이 들어오면 소켓생성 --> Client와  Server가 연결
			socket = listener.accept();
			logger.info("client와 socket 생성");
			
			//3.socket을 통해 client와 1:1통신 => 입출력 스트림을 통해서 통신
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String inputMessage;
			String outputMessage;
			while(true) {
				//입력스트림처리
				inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					logger.info("Client에서 bye로 연결을 종료합니다.");
					break;
				}
				System.out.println("클라이언트:" + inputMessage);				
				
				//출력용스트림처리
				System.out.print("보내기>>");
				outputMessage = scanner.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
				
			}
			
			
		} catch (IOException e) {
			logger.info("오류발생:" + e.getMessage());
		}
		finally {
			
			try {
				scanner.close();
				in.close();
				out.close();
				socket.close();
				listener.close();
			} catch (IOException e) {
				logger.info("close 오류발생:" + e.getMessage());
			}
			
		}
	}
	

	public static void main(String[] args) {
		new ServerEx();

	}

}
