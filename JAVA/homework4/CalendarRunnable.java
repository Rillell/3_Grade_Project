package homework4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ClaendarThread implements Runnable {
	
	private JLabel time;
	
	public ClaendarThread(JLabel time) {
		this.time = time;
	}
    public void run() {
        while(true) {
        	Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);
            String clockText = Integer.toString(hour);
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(min));
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(second));
            
            time.setText(clockText);
        }
    }
}


public class CalendarRunnable extends JFrame {
    
    public CalendarRunnable() {
        this.setTitle("µðÁöÅÐ ½Ã°è");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        
        JLabel time = new JLabel();
        time.setFont(new Font("Gothic", Font.ITALIC, 80));
        ct.add(time);
        
        ClaendarThread runnable = new ClaendarThread(time);
        Thread t = new Thread(runnable);
        
        t.start();
        
        
        this.setSize(400, 200);
        this.setVisible(true);
    }
    
 
    public static void main(String[] args) {
        new CalendarRunnable();
    }
}
