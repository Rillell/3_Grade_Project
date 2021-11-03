package homework4;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

 

public class DigitalClockFrame extends JFrame{
	public DigitalClockFrame() {  
		setTitle("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyLabel());
		setSize(300, 300);
		setVisible(true);  
 }
 
	class MyLabel extends JLabel implements Runnable, MouseListener{
		private boolean mPaused = false;
		private Thread timerThread = null;
		public MyLabel() {
//   	setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			addMouseListener(this);
   
			timerThread = new Thread(this);
			timerThread.start();
}
  
	public String makeClockText(){
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		String clockText = hour + " : " + min + " : " + second;
   
		return clockText;
}
   @Override
   public void run() {
	   synchronized (this) {
		   while(true){
			   synchronized (this) {
				   try {
					   if(mPaused) {
						   wait();
					   }
       
					   setText(makeClockText());
					   Thread.sleep(1000);
				   } catch (InterruptedException e) {
					   return;
				   }
			   }
		   }
	   }
   
   }
  
  @Override
  public void mousePressed(MouseEvent e) {
	  int action = e.getButton();
   
	  if(action == MouseEvent.BUTTON1){
		  if(mPaused == true){
			  synchronized (this) {
				  notify();
				  mPaused = false;
			  }
		  }
	  }
   else if(action == MouseEvent.BUTTON3){
	   if(mPaused == false){
		   mPaused = true;
	   }
   	}
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
   // TODO Auto-generated method stub
   
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
   // TODO Auto-generated method stub
   
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
   // TODO Auto-generated method stub
   
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
   // TODO Auto-generated method stub
   
  }
 }
 public static void main(String[] args) {
	 new DigitalClockFrame();
 }
}
