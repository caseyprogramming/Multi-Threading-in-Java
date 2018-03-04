import java.util.Scanner;


// Volatile Variable guarantees that all threads can see the current state of the variable 
//CREATED by Gregory Casey 3/4/2018

class Processor extends Thread {

	// Use volatile to ensure that each thread checks the variable each time it runs
	private volatile boolean run = true;

	public void run() {
		// press enter to stop this loop
		while (run) {
			System.out.println("I'm Infinite!!!");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

	public void shutdown() {
		run = false;
		System.out.println("You stopped me :(");
	}
}

public class VolatileExample {
	public static void main(String[] args) {
		Processor p1 = new Processor();

		// DONT USE p1.run() here or it will continue running
		p1.start();

		System.out.println("press enter key to stop");
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		p1.shutdown();
	}
}
