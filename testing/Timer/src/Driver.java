import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the amount of seconds to focus");
		int seconds = input.nextInt();
		
		Countdown test = new Countdown(seconds);
		test.timer.schedule(test.task, 1000, 1000);
	}
}
