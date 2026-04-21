package CPS_393_Lab.execise14;

public class Q2b {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter();
		Thread[] thread = new Thread[10];

		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.increment();
				}
			});
			thread[i].start();
			thread[i].join();
		}
		System.out.println("Final count: " + counter.getCount());
	}

}
