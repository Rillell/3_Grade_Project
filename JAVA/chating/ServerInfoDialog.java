package chating;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerInfoDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField tfIP;
	private JTextField tfPort;
	private JButton btConnect;
	private ChatClient client;
	
	public ServerInfoDialog(ChatClient client) {
		setTitle("서버 정보 입력 다이얼로그");
		this.client = client;
		tfIP = new JTextField(15);
		tfPort = new JTextField(15);
		btConnect = new JButton("입력");
		btConnect.addActionListener(this);
		
		JPanel ipPane = new JPanel();
		JPanel portPane = new JPanel();
		JPanel buttonPane = new JPanel();
		ipPane.add(new JLabel("I    P : "));
		ipPane.add(tfIP);
		portPane.add(new JLabel("Port : "));
		portPane.add(tfPort);
		buttonPane.add(btConnect);
		
		setBounds(100, 100, 240, 130);
		getContentPane().setLayout(new GridLayout(3, 1));
		getContentPane().add(ipPane);
		getContentPane().add(portPane);
		getContentPane().add(buttonPane);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//입력된 서버의 정보를 다이얼로그를 호출한 클래스의 멤버
		//변수에 저장한다.
		client.setIp(tfIP.getText());
		client.setPort(Integer.parseInt(tfPort.getText()));
		setVisible(false);
		show(false);
		
	}
	
}
