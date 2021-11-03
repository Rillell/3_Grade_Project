package lect15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Logger;

//TCPSocket : (1:1통신)
//Client Socket 생성
public class ClientEx {
	//멤버변수
	Socket socket = null; //client socket
	BufferedReader in = null;
	BufferedWriter out = null;
	Scanner scanner = new Scanner(System.in);
	Logger logger = Logger.getLogger("ClientLog");
	
	//생성자
	public ClientEx() {
		//1. server에게 socket요청
		try {
			//localhost: 127.0.0.1
			socket = new Socket("localhost", 9999); //serversocket에서 accept가 실행
			logger.getGlobal().info("client socket 요청");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String inputMessage;
			String outputMessage;
			while(true) {
				//출력스트림
				System.out.print("보내기>>");
				outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
				
				//입력스트림
				inputMessage = in.readLine();
				System.out.println("서버:" + inputMessage);
			}
			
		} catch (IOException e) {
			logger.info("ClientEx IOException:" + e.getMessage());
		} 
		finally {
			scanner.close();
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				logger.info("close ClientEx IOException:" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		new ClientEx();
	}
}
