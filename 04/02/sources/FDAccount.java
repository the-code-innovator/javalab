package pkaccount.fd;
import pkbanking.pkinteface.*;
import pkaccount.*;

public class FDAccount extends Account implements Interest{
	private int period;
	public FDAccount(int acno, double bal, int per){
		super(acno,bal);
		period = per;
	}

	public double calc_interest(){
		return ((balance * fdrate)/100.0);
	}
	public void close(){
		balance += calc_interest();
	}
}
