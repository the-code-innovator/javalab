package pkexception;

public class InsufficientFundsException extends Exception{
	double needs;

	public InsufficientFundsException(double a){
		needs = a;
	}

	public String toString(){
		return new String("ERR: You need more "+ needs + " to withdraw!");
	}
}
