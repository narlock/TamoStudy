package panels;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	
	//How to use:
	//new MessagePanel(JFrame, message, title, indicator);
	
	public MessagePanel(JComponent parent, String message, String title, int indicator) {
		
		if(indicator == 0) {
			//Display Info
			JOptionPane.showMessageDialog(parent, 
					message, 
					title, 
					JOptionPane.INFORMATION_MESSAGE, 
					new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
		} else if(indicator == 1) { 
			//Display Error
			JOptionPane.showMessageDialog(parent, 
					message, 
					title, 
					JOptionPane.INFORMATION_MESSAGE, 
					new ImageIcon(getClass().getClassLoader().getResource("INFO_ERROR.png")));
		}
	}
	
}
