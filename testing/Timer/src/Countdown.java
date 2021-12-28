import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Countdown {
	private static int seconds = 3600; //milliseconds
	static Timer timer = new Timer();
	
	static TimerTask task = new TimerTask() {
		public void run() {
				seconds--;
				System.out.println("Decrementing by 1 second. Now at " + seconds);
				//send information back to the gui
				
				if(seconds == 0)
					task.cancel();
			} 
		
	};
    
	public Countdown() {
		//Default argument: 60 seconds
		seconds = 3600;

	}
	
	public Countdown(int seconds) {
		this.seconds = seconds;

	}
	

	public int updateSeconds() {
		return seconds;
	}

/*
 * private JPanel northPanel, centerPanel;
	private JPanel mainPanel;
	private JLabel shopImage;
	
	private JPanel changeColorPanel, changeColorNorth, changeColorSouth;
	private JLabel localBackgroundLabel;
	private JButton redButton, blueButton, greenButton, yellowButton, purpleButton, orangeButton, greyButton;
	
	private JPanel bg1Panel, bg2Panel, bg3Panel, bg4Panel, bg5Panel;
	
	private JLabel bg1, bg2, bg3, bg4, bg5;
	private JButton bg1button, bg2button, bg3button, bg4button, bg5button;
	
	private JButton returnToFocus;
 */
	
	
}