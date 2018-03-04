
//CREATED by Gregory Casey 3/4/2018

public class SychronizedIncrementing {

	private int count = 0;

	// use SYNCHRONIZED so that you do not run into errors where both threads are
	// incrementing before the other has a chance to be updated,
	// this would cause loss of some of the count++ executions

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		SychronizedIncrementing app = new SychronizedIncrementing();
		app.doWork();

	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		// This waits for the thread to finish running before moving on
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Count is " + count);

	}
}
