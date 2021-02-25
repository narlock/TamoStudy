import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener{
	private JFrame frame = new JFrame();

	public GUI() {
		
		createAspects();
		
		setUpFrame();
		
	}
	
	public void createAspects() {
		//Study Button
		JButton studyButton = new JButton("STUDY");
		studyButton.addActionListener(this);
				
		//The panel with button and some text
		JPanel panel = new JPanel();
		panel.add(studyButton);
	}
	
	public void setUpFrame() {
		//Set up the frame and display it
		add(frame);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
