package State;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThemeStrategy extends StateStrategy {

	private JLabel themeHeaderLabel, themeHeaderClassicLabel;
	private JPanel themePanel, themePanel2, themePanel3, themePanel4;
	private JPanel[] themes;
	
	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(subColor);
		
		themeHeaderLabel = new JLabel("Themes");
		setUpLabelComponent(themeHeaderLabel);
		this.add(themeHeaderLabel);
		
		themePanel = new JPanel();
			themePanel.setBackground(subColor);
			
		themePanel.add(themePanel("Dark Mode", "DARK_MODE.png"));
		themePanel.add(themePanel("Light Mode", "LIGHT_MODE.png"));
		
		this.add(themePanel);
		
		themeHeaderClassicLabel = new JLabel("Classic Themes");
		setUpLabelComponent(themeHeaderClassicLabel);
		this.add(themeHeaderClassicLabel);
		
		themePanel2 = new JPanel();
		themePanel2.setBackground(subColor);
		
		themePanel2.add(themePanel("Classic Mode", "CLASSIC_MODE.png"));
		themePanel2.add(themePanel("Classic Blue", "CLASSIC_BLUE_MODE.png"));
		
		this.add(themePanel2);
		
		themePanel3 = new JPanel();
		themePanel3.setBackground(subColor);
		
		themePanel3.add(themePanel("Classic Green", "CLASSIC_GREEN_MODE.png"));
		themePanel3.add(themePanel("Classic Yellow", "CLASSIC_YELLOW_MODE.png"));
		
		this.add(themePanel3);
		
		themePanel4 = new JPanel();
		themePanel4.setBackground(subColor);
		
		themePanel4.add(themePanel("PLACEHOLDER", "DARK_MODE.png"));
		themePanel4.add(themePanel("PLACEHOLDER", "DARK_MODE.png"));
		
		this.add(themePanel4);
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel themePanel(String name, String imageUrl) {
		JPanel panel = new JPanel();
			panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		JLabel nameLabel = new JLabel(name);
		JLabel imgLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		JButton select = new JButton("Select");
		
		panel.add(nameLabel);
		panel.add(imgLabel);
		panel.add(select);
		
		return panel;
	}
	
	public void setUpLabelComponent(JLabel label) {
		label.setForeground(textColor);
		label.setFont(fontBoldReg);
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	}

}
