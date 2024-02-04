package components.panel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.Theme;

public class LongBreakSetPanel extends JPanel {
	
	private static final long serialVersionUID = 2942049508629442065L;
	private JLabel longBreakTitle;
	
	public LongBreakSetPanel(Theme theme, Map<Integer, Integer> sessions) {
		longBreakTitle = new JLabel("Select Session for Long Break");
		longBreakTitle.setForeground(Color.WHITE);
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		this.setLayout(new GridBagLayout());
		
		this.add(longBreakTitle, gbcv);
		for(int i = 1; i < sessions.size(); i++) {
			final int index = i;
			
			JCheckBox longBreakCheckBox = new JCheckBox("" + i);
			longBreakCheckBox.setForeground(Color.WHITE);
			longBreakCheckBox.setBackground(theme.mainColor);
			longBreakCheckBox.setSelected(sessions.get(index) == 1);
			longBreakCheckBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(longBreakCheckBox.isSelected()) {
						sessions.put(index, 1);
					} else {
						sessions.put(index, 0);
					}
				}
			});
			this.add(longBreakCheckBox, gbcv);
		}
	}
}
