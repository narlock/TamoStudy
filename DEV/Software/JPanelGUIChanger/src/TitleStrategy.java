import java.awt.*;
import javax.swing.*;

public class TitleStrategy extends StateStrategy {
	private JLabel title;
	
	@Override
	public void setPanel() {
		this.setBackground(Color.GRAY);
		title = new JLabel("Hello World");
		this.add(title, BorderLayout.CENTER);
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}

}
