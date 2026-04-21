package CPS_393_Lab.execise14;

public class Lab14Task2 extends Thread {
	private long result = 0;

	public void run() {
		for (int i = 0; i <= 100; i++) {
			result += i;
		}
	}

	public long getResult() {
		return result;
	}
}
