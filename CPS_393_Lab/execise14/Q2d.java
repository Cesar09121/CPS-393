package CPS_393_Lab.execise14;

public class Q2d {

	public static void main(String[] args) throws InterruptedException {

		CounterForQ2d counter = new CounterForQ2d();
		Thread[] thread = new Thread[10];

		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.increment();
				}
			});
			thread[i].start();
		}
		for (int i = 0; i < 10; i++) {
			thread[i].join();
		}
		System.out.println("Final count: " + counter.getCount());
	}
}
