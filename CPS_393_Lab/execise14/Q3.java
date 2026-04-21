package CPS_393_Lab.execise14;

import java.util.Random;

public class Q3 {
	public static void main(String[] args) {
		int n = 100000;
		int[] arr = new int[n];

		Random ran = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = ran.nextInt(100) + 1;
		}

		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (long) arr[i] * arr[i];
		}
		long endTime = System.nanoTime();

		long duration = endTime - startTime;

		System.out.println("Single thread sum = " + sum);
		System.out.println("Single thread time = " + duration + " ns.");

		/*
		 * with n =100
		 * Single thread sum = 314300
		 * Single thread time = 2000 ns.
		 */

		/*
		 * with n =100000
		 * Single thread sum = 339073782
		 * Single thread time = 170700 ns.
		 */

		/*
		 * with n =100000000
		 * Single thread sum = 338348268025
		 * Single thread time = 34501000 ns.
		 */

	}
}
