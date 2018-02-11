//initializing package pkbanking.pkinterface and nesting interface Transaction in it :
package pkbanking.pkinterface;

//importing pkbanking.pkexception.* for handling exceptions defined in the package pkbanking.pkexception :
import pkbanking.pkexception.*;

//interface Transaction definition :
public interface Transaction{
	//minimum balance for Transaction to proceed ;
  public final double min_balance = 500;

	//method to deposit funds into Account :
  public void deposit(double depositAmount);

	//method to withdraw funds from Account :
  public void withdraw(double withdrawAmount)throws InsufficientFundsException;
}
//interface Transaction end ...
