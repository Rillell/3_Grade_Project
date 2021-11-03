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
		setTitle("���� ���� �Է� ���̾�α�");
		this.client = client;
		tfIP = new JTextField(15);
		tfPort = new JTextField(15);
		btConnect = new JButton("�Է�");
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
		//�Էµ� ������ ������ ���̾�α׸� ȣ���� Ŭ������ ���
		//������ �����Ѵ�.
		client.setIp(tfIP.getText());
		client.setPort(Integer.parseInt(tfPort.getText()));
		setVisible(false);
		show(false);
		
	}
	
}
