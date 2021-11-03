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
		setTitle("대화명을 입력하세요.");
		setBounds(100, 200, 250, 70);
		
		tfNick = new JTextField(15);
		btConnect = new JButton("입 력");
		btConnect.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(tfNick);
		pane.add(btConnect);
		
		getContentPane().add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//입력된 이름을 다이얼로그를 호출한 클래스의 멤버 변수에 저장한다.
		client.setName(tfNick.getText());
		setVisible(false);
		show(false);
		
	}
	
	

}
