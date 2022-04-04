import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudyFocusStrategy extends StateStrategy {
	private JButton button;
	private boolean changed;
	
	@Override
	public void setPanel() {
		this.setBackground(Color.LIGHT_GRAY);
		changed = false;
		button = new JButton("Hello World");
		this.add(button, BorderLayout.CENTER);
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(changed == false) {
					changed = true;
					changeBackgroundColor("red");
				} else {
					changed = false;
					changeBackgroundColor("gray");
				}
				
			}
			
		});
		
	}
	
	public void changeBackgroundColor(String color) {
		if(color.equals("gray")) {
			this.setBackground(Color.LIGHT_GRAY);
		} else {
			this.setBackground(Color.RED);
		}
	}

}
