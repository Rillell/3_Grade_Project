package lect15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

//TCP socket : (1:n���) ==> Thread�� ó��

//Server: ������ ����(Client ��û�� ����)

public class TranslatorServer {
	//�������
	ServerSocket listener = null;
	int clientId = 0; //socket ��û�� ���� client id : 1���� ���������� �ο�
	static Logger logger = Logger.getLogger("TranslateLog");
	
	//������
	public TranslatorServer() {
		logger.getGlobal().info("��������� ���� ����!!");
		
		try {			
			listener = new ServerSocket(9990);	
			logger.info("ServerSocket ����!");
			while(true) {
				clientId++;
				//client�� ��û�� ���� �� ���� socket�� �����ϰ� Thread �⵿
				//Thread���� socket��ü�� clientId�� �Ѱ��ֵ���
				Thread th = new Thread(new Translator(listener.accept(), clientId));
				th.start();
			}
			
			
		}catch (IOException e) {
			logger.info("ServerSocket ���� �� ����!!" + e.getMessage());
		}
		finally {
			try {
				listener.close();
			} catch (IOException e) {
				logger.info("ServerSocket ���� �� ����!!" + e.getMessage());
			}
		}   
	}
	
	public static void main(String[] args) {
		new TranslatorServer();
	}
}


//client���� socket���� client�� ��Ʈ������ �ۼ���
class Translator implements Runnable{
	//�������
	private Socket socket = null;
	private int myId;
	BufferedReader in = null;
	PrintWriter out = null;
	
	//������
	public Translator(Socket socket, int myId) {
		this.socket = socket;
		this.myId = myId;
	}
	
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		
			out.println("�ȳ��ϼ���! Ŭ���̾�Ʈ ��ȣ�� " + this.myId + "�Դϴ�.");
			System.out.println("Ŭ���̾�Ʈ��ȣ:" + this.myId);
			out.println("�˻��� �ܾ �Է��ϼ���!");
			
			String input = "";
			while(true) {
				input = in.readLine();
				if(input ==  null) break;
				System.out.println(this.myId + "�� �Է��� �ܾ�� : " + input);
				//�ܾ�˻� ��ƾ :��üȭ�ؼ� ������ ����
				if(input.equalsIgnoreCase("java")) {
					out.println("java-> �ڹ�");
				}
				else {
					out.println("�ʹ��������...���� �ܾ��....��Ź�ؿ�!!");
				}
			}					
		} catch (IOException e) {
			Logger.getGlobal().info(this.myId+"Thrad ������ ����" + e.getMessage());
		}
		finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				Logger.getGlobal().info(this.myId+"Socket ������ ����" + e.getMessage());
			}
		}	
	}	
}









