package chating;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameInputDialog extends JDialog implements ActionListener{
	
	private ChatClient client;
	private JTextField tfNick;
	private JButton btConnect;
	
	public NameInputDialog(ChatClient client) {
		this.client = client;
		setTitle("��ȭ���� �Է��ϼ���.");
		setBounds(100, 200, 250, 70);
		
		tfNick = new JTextField(15);
		btConnect = new JButton("�� ��");
		btConnect.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(tfNick);
		pane.add(btConnect);
		
		getContentPane().add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//�Էµ� �̸��� ���̾�α׸� ȣ���� Ŭ������ ��� ������ �����Ѵ�.
		client.setName(tfNick.getText());
		setVisible(false);
		show(false);
		
	}
	
	

}
