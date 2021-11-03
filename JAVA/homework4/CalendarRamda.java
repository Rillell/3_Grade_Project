package homework4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalendarRamda extends JFrame{
	
	private Calendar c; 
	  private int hour, min, second; 
	  private JLabel time; 
	  public CalendarRamda () { 
	    this.setTitle( "람다 디지털 시계"); 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.setLocationRelativeTo(getOwner());                
	    Container ct = getContentPane();                
	    ct.setLayout(null);                
	    time = new JLabel();                
	    time.setFont(new Font("Arial", Font.ITALIC, 80)); 
	    time.setBounds(  35,  30,  400, 100); 
	    ct.add(time);    
	    
	    Thread t = new Thread(r);
	    t.start(); 
	    
	    this.setSize( 400, 200); 
	    this.setVisible( true);      
	   } 
	 
	  Runnable r = ()->{
		  while(true) {      
		    	 c = Calendar.getInstance();     
		    	 hour = c.get(Calendar.HOUR_OF_DAY);     
		    	 min = c.get(Calendar.MINUTE);         
		    	 second = c.get(Calendar.SECOND);       
		    	 String clockText = Integer.toString(hour);     
		    	 clockText = clockText.concat(":");      
		    	 clockText = clockText.concat(Integer.toString(min));      
		    	 clockText = clockText.concat(":");      
		    	 clockText = clockText.concat(Integer.toString(second));           
		    	 time.setText(clockText); 
		    	 
		    	 }         
	  };        
	   

	public static void main(String[] args) {
		new CalendarRamda();

	}

}
