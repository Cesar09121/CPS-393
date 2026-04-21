package CPS_393_Lab.execise14;

public class Counter {

	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
