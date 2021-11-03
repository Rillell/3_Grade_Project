package lect17;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//UDP통신
//MultiCast통신
class Pen{
	private int type = 0;
	private static Pen p = new Pen();
	private Pen() { }
	//getter, Setter설정
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public static Pen getP() {
		return p;
	}
	public static void setP(Pen p) {
		Pen.p = p;
	}
	
}

class MenuPanel extends JPanel{
	private JButton btnMenu[] = null;
	public MenuPanel(String strMenu[], Pen p) {
		btnMenu = new JButton[strMenu.length];
		
		ActionListener al = (e) -> {
			String strCommand = e.getActionCommand();
			if(strCommand.equals(strMenu[0])) p.setType(0);
			else if(strCommand.equals(strMenu[1])) p.setType(1);
			else if(strCommand.equals(strMenu[2])) p.setType(2);
			else if(strCommand.equals(strMenu[3])) p.setType(3);
			else if(strCommand.equals(strMenu[4])) p.setType(4);
			else if(strCommand.equals(strMenu[5])) p.setType(5);
			else if(strCommand.equals(strMenu[6])) p.setType(6); 
			else if(strCommand.equals(strMenu[7])) p.setType(7);
		};
		
		for(int i = 0; i<strMenu.length; i++) {
			btnMenu[i] = new JButton(strMenu[i]);
			btnMenu[i].addActionListener(al);
			this.add(btnMenu[i]);
		}
		this.setLayout(new GridLayout(strMenu.length, 1));
	}
}

public class MCastBoard extends JFrame{
	//멤버변수
	Pen p = null; //팬객체
	MenuPanel menu = null;
	JPanel cavas = null;
	String sMutiAddress = "";
	int iMutiPort = 0;
	//생성자
	public MCastBoard(String sMutiAddress, int iMutiPort) {
		this.sMutiAddress = sMutiAddress;
		this.iMutiPort = iMutiPort;
		 
		this.setTitle("Multicast WhiteBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] strMenu = {"사각형", "삼각형", "둥근사각형", "동그라미", "부채꼴", "직전", "지우기", "다지우기"};
		
		p= Pen.getP();
		menu = new MenuPanel(strMenu, p);
		cavas = new MCanvas(p, sMutiAddress, iMutiPort);
		
		this.add(BorderLayout.WEST, menu);
		this.add(BorderLayout.CENTER, cavas);
		
		this.setSize(800, 700);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		if(args.length !=2) {
			System.out.println("파라미터 : [멀티캐스트주소] [포트번호]");  //D클래스(224.0.0.0~ 239.255.255.255)
			System.exit(0);
		}
		MCastBoard mcf = new MCastBoard(args[0], Integer.parseInt(args[1]));
	}

}
