package exceptions;

public class TheWrongTypeJudge extends Exception {
	public TheWrongTypeJudge() {
		super("The Refere doesn't compatible with the competition type");
	}
}
