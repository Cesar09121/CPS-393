package CPS_393_Lab.execise14;

public class Q1b {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Lab14Task2 thread = new Lab14Task2();

		thread.start();
		thread.join();
		System.out.println(thread.getResult());

	}

}
