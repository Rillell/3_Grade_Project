package lect05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//메뉴만들기
public class MenuFileChooserEx extends JFrame{
	//멤버변수
	private JLabel imgLabel = new JLabel();
	
	//생성자
	public MenuFileChooserEx() {
		this.setTitle("FileChooser 사용 예제");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		this.add(imgLabel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	//메뉴구성 메서드
	public void createMenu() {
		//1. 메뉴바
		JMenuBar mb = new JMenuBar();
		
		//2. 메뉴생성
		String[] smenu = {"Screen", "Edit", "Source", "Project", "Run"};
		JMenu[] menu = new JMenu[10];
		for(int i = 0; i<smenu.length; i++) {
			menu[i] = new JMenu(smenu[i]);
			mb.add(menu[i]);
		}
		
		//3. 메뉴아이템 생성
		//3.1 Screen메뉴의 메뉴아이템
		String[] ScrItem = {"Load", "Hide", "ReShow", "Exit"};
		JMenuItem[] item = new JMenuItem[4];
		//JFileChooser
		JFileChooser chooser = new JFileChooser();
		//filter 설정
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", //파일이름난에 출력될 문자열
				"Jpg", "Gif");  //파일 필터로 사용될 확장자 :.jpg, .gif
		
		chooser.setFileFilter(filter); //filter설정
		
		for(int i=0; i<ScrItem.length; i++) {
			item[i] = new JMenuItem(ScrItem[i]);
			//1.이벤트 소스 : JMenuItem
			//2.이벤트 종류 : ActionEvent
			//3.리스너 구현 : ActionListener -> Lamda식으로 구현
			//4.리스너 연결
			item[i].addActionListener((ActionEvent e)->{
				String command = e.getActionCommand();
				switch(command) {
				case "Load":
					if(imgLabel.getIcon() != null) return;
					//FileChooser 선택창으로 파일 선택하기
					int ret = chooser.showOpenDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file을 선택하지 않았음
						JOptionPane.showMessageDialog(null,
								"파일을 선택하지 않았습니다.", "경고", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					//사용자가 선택한 파일명을 가져옴
					String sFile = chooser.getSelectedFile().getPath();	
					imgLabel.setIcon(new ImageIcon(sFile));
					pack();
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
		new MenuFileChooserEx();
	}
}
