package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;


public class numIndepent implements ActionListener{
	//멤버변수
	NumericCalculatorInde frame;
	//생성자
	public numIndepent(NumericCalculatorInde frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frame.getCe()) {
			frame.getText().setText("");
			frame.getText2().setText("");	
		}
		else if(e.getSource() == frame.getEqu()) {
			StringTokenizer st = new StringTokenizer(frame.getText().getText(), "+-X/", true);
			
			int first = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int second = Integer.parseInt(st.nextToken());
			switch(op) {
			case "+" : frame.getText2().setText(first + second + ""); break;
			case "-" : frame.getText2().setText(first - second + ""); break;
			case "X" : frame.getText2().setText(first * second + ""); break;
			case "/" : frame.getText2().setText(first / second + ""); break;
			}		
		}
		else {
			String command = e.getActionCommand();
			frame.getText().setText(frame.getText().getText()+command);
		}
		
	}
	
}

