package lect05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//�޴������
public class MenuEx extends JFrame{
	//�������
	private JLabel imgLabel = new JLabel();
	
	//������
	public MenuEx() {
		this.setTitle("Menu����� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		this.add(imgLabel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	//�޴����� �޼���
	public void createMenu() {
		//1. �޴���
		JMenuBar mb = new JMenuBar();
		
		//2. �޴�����
		String[] smenu = {"Screen", "Edit", "Source", "Project", "Run"};
		JMenu[] menu = new JMenu[10];
		for(int i = 0; i<smenu.length; i++) {
			menu[i] = new JMenu(smenu[i]);
			mb.add(menu[i]);
		}
		
		//3. �޴������� ����
		//3.1 Screen�޴��� �޴�������
		String[] ScrItem = {"Load", "Hide", "ReShow", "Exit"};
		JMenuItem[] item = new JMenuItem[4];
		for(int i=0; i<ScrItem.length; i++) {
			item[i] = new JMenuItem(ScrItem[i]);
			//1.�̺�Ʈ �ҽ� : JMenuItem
			//2.�̺�Ʈ ���� : ActionEvent
			//3.������ ���� : ActionListener -> Lamda������ ����
			//4.������ ����
			item[i].addActionListener((ActionEvent e)->{
				String command = e.getActionCommand();
				switch(command) {
				case "Load":
					if(imgLabel.getIcon() != null) return;
					imgLabel.setIcon(new ImageIcon("./images/img.jpg"));
					break;
				case "Hide" :
					imgLabel.setVisible(false);
				case "ReShow" :
					imgLabel.setVisible(true);
					break;
				case "Exit" :
					System.exit(0);
					break;
				}
			});
			
			menu[0].add(item[i]);
		}
		
		this.setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
}
