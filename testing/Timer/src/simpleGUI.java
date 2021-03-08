import javax.swing.*;
import java.awt.*;

public class simpleGUI extends JFrame {
		
		//Component Declaration
		private JPanel topPanel, centerPanel, botPanel;
		private JButton studyButton, endStudyButton;

		public simpleGUI() {
			
			setUpFrame();
			
			initVariables();
			
			createAspects();
			
			setUpGUI();
			
			this.setSize(500,500);
			
		}
		
		public void setUpFrame() {
			//Sets up the GUI's frame
			this.setTitle("TamoStudy (version: 0.1)");
			this.setSize(500,500);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public void initVariables() {
			
		}

		public void createAspects() {
			JButton startButton = new JButton("Start");
			JButton quitButton = new JButton("Quit now!");
		}
		
		public void setUpGUI() {
			
		}

	}

