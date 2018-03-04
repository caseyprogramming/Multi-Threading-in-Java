package demo3;

//This is an example of multi-threading in which you do not have to create separate class to implement it
//CREATED by Gregory Casey 3/4/2018

public class SimpleThreadExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}

			}
		});

		t1.start();
		t2.start();
	}

}
