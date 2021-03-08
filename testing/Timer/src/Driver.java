
public class Driver {
	public static void main(String[] args) {
		int seconds = 60;
		
		Countdown test = new Countdown(seconds);
		test.timer.schedule(test.task, 1000, 1000);
	}
}
