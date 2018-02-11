package pkaccount.sb;
import pkbanking.pkinteface.*;
import pkaccount.*;
import pkexception.*;

public class SbAccount extends Account implements Interest,Transaction{
	public SbAccount(int acc, double initbal){
		super(acc,initbal);
	}
	public void deposit(double a) {
		if(a>0){
			balance += a;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void withdraw(double a) throws InsufficientFundsException{
		if(balance >1000 & balance > a){
			balance -= a;
		}
		else{
			double needs = a - balance;
			if (needs < 0){
				needs = 1000 - a;
			}
			throw new InsufficientFundsException(needs);
		}
	}
	public void calc_interest(){
		balance += (( balance * sbrate)/100.0);
	}
}
