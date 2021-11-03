package week5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneEx extends JFrame{
	public TabbedPaneEx() {
		setTitle("ÅÇÆÒ ¸¸µé±â ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane(); //ÅÇÆÒÀ» »ý¼ºÇÑ´Ù.
		c.add(pane, BorderLayout.CENTER);  //ÅÇÆÒÀ» ÄÁÅÙÆ®ÆØ¿¡ ºÎÂøÇÑ´Ù.
		setSize(250, 250);
		setVisible(true);	
	}
	
	//ÅÇÆÒÀ» »ý¼ºÇÏ°í 3°³ÀÇ ÅÇÀ» »ý¼ºÇÏ¿© ºÎÂøÇÑ´Ù.
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(); //ÅÇÆÒ °´Ã¼¸¦ »ý¼ºÇÑ´Ù.
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg"))); //Ã¹¹øÂ° ÅÇ
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg"))); //µÎ¹øÂ° ÅÇ
		pane.addTab("tab3", new MyPanel());
		return pane;
	} 
	
	//3¹øÂ° ÅÇÀÇ ÄÄÆ÷³ÍÆ®·Î »ç¿ëµÉ ÆÐ³Î
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.yellow);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.blue);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.black);
			g.drawString("tab 3¿¡ µé¾î°¡´Â JPanel ÀÔ´Ï´Ù.", 30, 50);
		}
	}
	
	public static void main(String[] args) {
		new TabbedPaneEx();
	}
}
