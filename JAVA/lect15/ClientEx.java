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

//TCPSocket : (1:1���)
//Client Socket ����
public class ClientEx {
	//�������
	Socket socket = null; //client socket
	BufferedReader in = null;
	BufferedWriter out = null;
	Scanner scanner = new Scanner(System.in);
	Logger logger = Logger.getLogger("ClientLog");
	
	//������
	public ClientEx() {
		//1. server���� socket��û
		try {
			//localhost: 127.0.0.1
			socket = new Socket("localhost", 9999); //serversocket���� accept�� ����
			logger.getGlobal().info("client socket ��û");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String inputMessage;
			String outputMessage;
			while(true) {
				//��½�Ʈ��
				System.out.print("������>>");
				outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
				
				//�Է½�Ʈ��
				inputMessage = in.readLine();
				System.out.println("����:" + inputMessage);
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
