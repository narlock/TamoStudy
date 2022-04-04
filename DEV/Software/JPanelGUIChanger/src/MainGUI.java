import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * MainGUI
 * @author Anthony Narlock
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	/**
	 * MainGUI the "Context"
	 */
	
	private boolean openedSideBar;
	private JPanel sidePanel;
	private JPanel openSidePanel;
	private StateStrategy strategy;

	public MainGUI() {
		strategy = new StudyFocusStrategy();
		openedSideBar = true;
		
		initFrame();
		initSidePanels();
		initComponentsToFrame();
	}
	
	public void recall(StateStrategy newStrategy) {
		System.out.println("TEST");
		this.remove(strategy);
		strategy = newStrategy;
		this.add(strategy, BorderLayout.CENTER);
		this.repaint();
	}
	
	public void initFrame() {
		this.setTitle("Hello World");
		this.setVisible(true);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void initSidePanels() {
		
		/**
		 * Setting up the Side Panel
		 */
		sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(15,1));
		JLabel sideLabel = new JLabel("TamoStudy Menu");
		JButton testButton = new JButton("Title");
		
		testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
				
				StateStrategy newStrategy = new TitleStrategy();
				
				recall(newStrategy);
				
			}
		});
		
		JButton otherStateButton = new JButton("New State");
		otherStateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
				
				StateStrategy newStrategy = new StudyFocusStrategy();
				
				recall(newStrategy);
				
			}
		});
		
		sidePanel.add(sideLabel);
		sidePanel.add(testButton);
		sidePanel.add(otherStateButton);
		
		
		/**
		 * Setting up openSidePanel
		 */
		openSidePanel = new JPanel();
		JButton openSideLabel = new JButton("...");
		openSideLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
			}
		});
		openSidePanel.add(openSideLabel);
	}
	
	public void initComponentsToFrame() {
		this.add(openSidePanel, BorderLayout.NORTH);
		this.add(sidePanel, BorderLayout.WEST);
		this.add(strategy, BorderLayout.CENTER);
	}
	
	public void updateSideBar() {
		if (this.openedSideBar) {
			//Close the side bar
			this.openedSideBar = false;
			this.sidePanel.setVisible(false);
		} else {
			//Open the side bar
			this.openedSideBar = true;
			this.sidePanel.setVisible(true);
		}
	}
}
