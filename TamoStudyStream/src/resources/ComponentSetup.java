package resources;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * ComponentSetup
 * @author antho
 * @brief Contains the details to set up customization for components
 * used for global colors that cannot be changed by the user
 * 
 * Combo boxes, Main buttons (start, break, save changes)
 */
public class ComponentSetup {

	public JLabel createSpaceLabel() {
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		return transparentComponent;
	}
	
	public void setUpJButton(JButton button) {
		if(System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows")) {
			if(button.getText() == "Start Focus")
				button.setBackground(new Color(120,255,120));
			else if(button.getText() == "Break Focus")
				button.setBackground(new Color(255,120,120));
			else
				button.setBackground(Color.WHITE);
		}
			
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setFocusPainted(false);
		button.setBorder(new RoundedBorder(Color.BLACK, 3, 10, 10, true));
	}
	
	public void setUpJComboBox(JComboBox box) {
		box.setFont(new Font("Tahoma", Font.BOLD, 16));
		if(System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows")) {
			box.setBackground(Color.WHITE);
		}
	}
}
