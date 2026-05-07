package lab16;

import java.util.Random;

public class TryThreeTimes implements DoNotGiveUp<String> {
	private static final Random ran = new Random();
	
	@Override
	public String execute() {
		for(int i =0;i<3;i++) {
			int num = ran.nextInt(100)+1;
			System.out.println("Try "+(i+1)+ ": rolled "+num);
			if(num>50) {
				return "Successful";
			}
		}
		return "Failed";
	}
}
