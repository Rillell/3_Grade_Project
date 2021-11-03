package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperInde implements ActionListener{
	//멤버변수
	TemperatureInde frame;
	//생성자
	public TemperInde(TemperatureInde frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(frame.getText2().getText().equals("")) {
			double f =Double.parseDouble(frame.getText1().getText());
			double c=(f-32)*5/9;
			frame.getText2().setText(String.format("%4.2f", c));
		}
		else{
			double c2 =Double.parseDouble(frame.getText2().getText());
			double f2= c2*1.8 + 32;
			frame.getText1().setText(String.format("%4.2f", f2));	
		}				
	}

}
