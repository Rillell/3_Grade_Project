package lect14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//캔버스에 그리기 지정 -> JPanel
class canvas extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //초기화
		g.drawRect(10, 10, 50, 50);
		g.drawRoundRect(10, 70, 50, 50, 20, 20);
		g.drawOval(10, 130, 50, 50);
		g.drawArc(10, 190, 50, 50, 0, 270);
		int[] x = { 30, 10, 30, 60 }; //x좌표 모음
		int[] y = { 250, 275, 300, 275};
		g.drawPolygon(x, y, 4);
		
		//색상 채우기
		g.setColor(Color.red);
		
		g.fillRect(150, 10, 50, 50);
		g.fillRoundRect(150, 70, 50, 50, 20, 20);
		g.fillOval(150, 130, 50, 50);
		g.fillArc(150, 190, 50, 50, 0, 270);
		int[] xx = { 160, 160, 180, 210 };
		
		g.fillPolygon(xx, y, 4);
		
	}
}




public class GraphicsEx extends JFrame{
	public GraphicsEx() {
		this.setTitle("도형 그리기 기본예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas can = new canvas();
		this.add(can);
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GraphicsEx();
	}

}
