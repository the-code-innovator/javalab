//initializing package pkbanking.pkexception and nesting exception class InsufficientFundsException in it :
package pkbanking.pkexception;

//importing java.io.* for exceptions :
import java.io.*;

//class InsufficientFundsException definition :
public class InsufficientFundsException extends Exception {
	//description of Exception :
	public String named;

	//Default Constructor for Exception InsufficientFundsException :
	public InsufficientFundsException(){
		this.named = new String("Insufficient funds for Transaction !");
	}

	//Constructor for Exception InsufficientFundsException :
	public InsufficientFundsException(String a){
    named = a;
  }

	//toString() :: Exception method Overriding :
	public String toString(){
		return ("ERROR IFE-001: " + this.named);
	}
}
//class InsufficientFundsException end ...
