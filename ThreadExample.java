package demo1;

// This is an example of multi-threading using the Thread class extension
// CREATED by Gregory Casey 3/4/2018

class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Run: " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner1 = new Runner();
		runner1.start();
		Runner runner2 = new Runner();
		runner2.start();
	}

}
