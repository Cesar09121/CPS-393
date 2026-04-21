package CPS_393_Lab.execise14;

public class Lab14Task implements Runnable {

	private long result = 0;

	public void run() {
		for (int i = 1; i <= 100; i++) {
			result += i;
		}
	}

	public long getResult() {
		return result;
	}

}
