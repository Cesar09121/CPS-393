package lab16;

public class TryForEver implements DoNotGiveUp<String>{
	
	@Override
	public String execute() {
		for(int i =0;i<1000;i++) {
			double num = Math.random();
			System.out.println("Try "+(i+1)+ ": "+num);
			if(num<0.4) {
				return "Successful on try "+(i+1);
			}
		}
		return "Failed";
	}

}
