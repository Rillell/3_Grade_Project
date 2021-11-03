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

//TCPSocket : (1:1 ���)
//Server Socket
public class ServerEx {
	//�������
	ServerSocket listener = null;
	Socket socket = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	Scanner scanner = new Scanner(System.in);
	Logger logger = Logger.getLogger("serverlog");
	
	//������
	public ServerEx() {
		//1.�������ϼ����� �ٿ�
		try {
			listener = new ServerSocket(9999);
			logger.getGlobal().info("�������ϼ��� ����");
			//2.client ��û�� ��ٷȴ� ��û�� ������ ���ϻ��� --> Client��  Server�� ����
			socket = listener.accept();
			logger.info("client�� socket ����");
			
			//3.socket�� ���� client�� 1:1��� => ����� ��Ʈ���� ���ؼ� ���
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String inputMessage;
			String outputMessage;
			while(true) {
				//�Է½�Ʈ��ó��
				inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					logger.info("Client���� bye�� ������ �����մϴ�.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ:" + inputMessage);				
				
				//��¿뽺Ʈ��ó��
				System.out.print("������>>");
				outputMessage = scanner.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
				
			}
			
			
		} catch (IOException e) {
			logger.info("�����߻�:" + e.getMessage());
		}
		finally {
			
			try {
				scanner.close();
				in.close();
				out.close();
				socket.close();
				listener.close();
			} catch (IOException e) {
				logger.info("close �����߻�:" + e.getMessage());
			}
			
		}
	}
	

	public static void main(String[] args) {
		new ServerEx();

	}

}
