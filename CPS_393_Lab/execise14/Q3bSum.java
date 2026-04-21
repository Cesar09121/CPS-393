package CPS_393_Lab.execise14;

import java.util.Random;

public class Q3bSum implements Runnable {
	private int arr[];
	private int start;
	private int end;
	private long result = 0;

	public Q3bSum(int arr[], int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	public void run() {
		for (int i = start; i < end; i++) {
			result += arr[i] * arr[i];
		}
	}

	public long getResult() {
		return result;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int n = 100000;
		int[] arr = new int[n];

		Random ran = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = ran.nextInt(100) + 1;
		}

		long threadStart = System.nanoTime();

		Q3bSum task1 = new Q3bSum(arr, 0, n / 2);
		Q3bSum task2 = new Q3bSum(arr, n / 2, n);

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		long threadEnd = System.nanoTime();
		long sum = task1.getResult() + task2.getResult();
		long duration = threadEnd - threadStart;

		System.out.println("Double thread sum = " + sum);
		System.out.println("Double thread time = " + duration + " ns.");

		/*
		 * with n=100
		 * Double thread sum = 339648
		 * Double thread time = 431500 ns.
		 */

		/*
		 * with n=100000000
		 * Double thread sum = 338366666910
		 * Double thread time = 32345200 ns.
		 */
	}

}
