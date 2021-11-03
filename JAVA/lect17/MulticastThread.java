package lect17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastThread implements Runnable{
	//멤버변수
	private DatagramPacket recvPacket = null; //수신용
	private DatagramPacket sendPacket = null; //송신용
	private MulticastSocket socket = null;
	private InetAddress address = null;
	private int ttl = 3;
	private int port = 0;
	
	private MCanvas canvas = null;
	
	public MulticastThread(String sip, int port, MCanvas c) {
		this.canvas = c;
		this.port = port;
		
		try {
			address = InetAddress.getByName(sip);
			if(!address.isMulticastAddress()) {
				System.out.println("Mutocast 주소를 사용해주세요!!");
				System.exit(0);
			}
		} catch (UnknownHostException e) {			
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			socket = new MulticastSocket(port);
			socket.setTimeToLive(ttl);
			socket.joinGroup(address);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void run() {
		while(true) {
			recvPacket = new DatagramPacket(new byte[255], 255);
			try {
				socket.receive(recvPacket);
				String str = new String(recvPacket.getData());
				String[] strs = str.split(":");
				
				int xp = Integer.parseInt(strs[0]);
				int yp = Integer.parseInt(strs[1]);
				int xr = Integer.parseInt(strs[2]);
				int yr = Integer.parseInt(strs[3]);
				int penType = Integer.parseInt(strs[4]);
				
				canvas.draw(xp, yp, xr, yr, penType);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void send(int xp, int yp, int xr, int yr, int pentype) {
		String str = xp + ":" + yp + ":" + xr + ":" + yr + ":" + pentype + ":";
		byte[] buf = str.getBytes();
		
		sendPacket = new DatagramPacket(buf, buf.length, address, port); //송신용
		
		try {
			socket.send(sendPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
