package pkbanking.pkinteface;
import pkexception.*;
public interface Transaction {
	int min_balance = 500;
	public void withdraw(double a) throws InsufficientFundsException;
	public void deposit(double a);
}
