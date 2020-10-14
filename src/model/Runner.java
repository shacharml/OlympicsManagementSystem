package model;

public class Runner extends Athlete{
	
	private int runningSpeed;
	
	public Runner(int runningSpeed , String name , String country) {
		super(name , country);
		this.runningSpeed = runningSpeed;
		
	}

	public int getRunningSpeed() {
		return runningSpeed;
	}

	public void setRunningSpeed(int runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

	
	
	
}
