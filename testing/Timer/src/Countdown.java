import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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


}