package lect16;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
//UDP��Ź������ 1:1���
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessengerFrame extends JFrame{
	protected JTextField textField;
	protected JTextArea textArea;
	DatagramPacket packet;
	DatagramSocket socket;
	protected InetAddress address = null;
	protected int inPort; //�۽ſ� ��Ʈ��ȣ
	protected int outPort; //���ſ� ��Ʈ��ȣ
	
	//������
	public MessengerFrame(int inPort, int outPort, String OutIP) {
		this.setTitle("Unicast���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.inPort = inPort;
		this.outPort = outPort;		
		try {
			this.address = InetAddress.getByName(OutIP);
			socket = new DatagramSocket(inPort);
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
		}
		
		textField = new JTextField(30);
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false); //�����۾� �Ұ���
		
		this.add(textField, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		//�۽�
		textField.addActionListener((e) -> {
			String s = textField.getText();
			byte[] buffer = s.getBytes();
			//�۽ſ� packet
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, outPort);
			try {
				socket.send(packet); //�۽�ó��
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			textArea.append("SEND:"+s+"\n");
			textArea.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
			textField.setText("");
		});
		//����
		Runnable rt = () -> {
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length); //���ſ� packet
			try {
				socket.receive(packet);
				textArea.append("RECIVED:" + new String(buf) + "\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		};
		Thread th = new Thread(rt);
		th.start();
		
		
		
		
	}
	
}
