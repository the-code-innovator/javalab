
package pkaccount;

public class Account{
	protected int accnumber;
	protected double balance;
	public Account(int a,double b ){
		accnumber = a;
		balance = b;
	}
	public void display(){
		System.out.printf("%d has the balance %.2f\n",accnumber,balance);
	}
	
}
