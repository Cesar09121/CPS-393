package CPS_393_Lab.execise14;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Lab14Task task = new Lab14Task();
		Thread thread = new Thread(task);

		thread.start();
		thread.join();
		System.out.println(task.getResult());

	}

}
