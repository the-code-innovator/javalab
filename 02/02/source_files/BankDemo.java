import java.io.*;
import java.*;
import java.util.*;

class Account{
	protected int accnumber;
	protected double balance;
	public static int count = 0;

	public Account(int acno, double bal){
		this.accnumber = acno;
		this.balance = bal;
		this.count++;
	}
}

class SBAccount extends Account{
	public SBAccount(int acc, double bal){
		super(acc, bal);
	}
	public void deposit(double depositAmount){
		if(depositAmount >= 0){
			this.balance += depositAmount;
			System.out.print("\nDeposit Amount : " + depositAmount + " has been deposited in the Account Number : " + this.accnumber);
		}
	}
	public void withdraw(double withdrawAmount){
		if((this.balance - withdrawAmount) >= 1000){
			this.balance -= withdrawAmount;
			System.out.print("\nWithdraw Amount : " + withdrawAmount + " has been withdrawn from the Account Number : " + this.accnumber);
		}
		else{
			System.out.print("\nERROR : Insufficient Minimum Balance !");
		}
	}
	public void calc_interest(){
		this.balance += (this.balance * 0.04);
	}
}

class FDAccount extends Account{
	public int period;

	public FDAccount(int acc, int per, double deposit){
		super(acc, deposit);
		this.period = per;
	}
	public double calc_interest(){
		double interest = balance * 0.0825 * period;
		return interest;
	}
	public void close(){
		System.out.print("\nInterest for " + this.balance + " for " + this.period + " is : " + this.calc_interest());
		this.balance += this.calc_interest();
	}
}

class Customer{
	public int cust_id;
	public String name;
	public String address;
	public SBAccount savingsAccount;
	public FDAccount fixedDeposit;
	public int type;

	public Customer(int cid, String cname, String addr, int type){
		this.cust_id = cid;
		this.name = cname;
		this.address = addr;
		this.type = type;
		this.createAccount();
	}
	public void createAccount(){
		Scanner in = new Scanner(System.in);
		if(this.type == 1){
			System.out.print("\nEnter Account Number : ");
			int accnum = in.nextInt();
			System.out.print("\nEnter Opening Balance for the Savings Account : ");
			double startbalance = in.nextDouble();
			this.savingsAccount = new SBAccount(accnum, startbalance);
		}
		if(this.type == 2){
			System.out.print("\nEnter Account Number : ");
			int accnum = in.nextInt();
			System.out.print("\nEnter Period : ");
			int per = in.nextInt();
			System.out.print("\nEnter Deposit Amount for the Fixed Deposit Account : ");
			double depositamt = in.nextDouble();
			this.fixedDeposit = new FDAccount(accnum, per, depositamt);
		}
	}
	public void transaction(){
		if(this.type == 1){
			System.out.print("\nChoose Transaction : \n1.Withdraw\n2.Deposit\n3.Calculate Interest\nEnter : ");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.print("\nEnter Amount to Withdraw : ");
					double wda = in.nextDouble();
					this.savingsAccount.withdraw(wda);
					break;
				case 2:
					System.out.print("\nEnter Amount to Deposit : ");
					double dpa = in.nextDouble();
					this.savingsAccount.deposit(dpa);
					break;
				case 3:
					System.out.print("\nInterest is added to the Balance !");
					this.savingsAccount.calc_interest();
					break;
				default:
					System.out.print("\nInvalid Choice !");
			}
			this.accountStatus(1);
		}
		if(this.type == 2){
			System.out.print("\nClosing Fixed Deposit Account !\nInterest is added to the Balance !");
			this.fixedDeposit.close();
			this.accountStatus(2);
		}
	}
	public void accountStatus(int choice){
		if(choice == 1){
			System.out.print("\nSAVINGS ACCOUNT STATUS\n------- ------- ------");
			System.out.print("\nSavings Account Number : " + this.savingsAccount.accnumber + "\nCustomer ID : " + this.cust_id + "\nCustomer Name : " + this.name + "\nCustomer Address : " + this.address + "\nSavings Account Balance : " + this.savingsAccount.balance);
		}
		if(choice == 2){
			System.out.print("\nFIXED DEPOSIT STATUS\n----- ------- ------");
			System.out.print("\nFixed Deposit Account Number : " + this.fixedDeposit.accnumber + "\nCustomer ID : " + this.cust_id + "\nCustomer Name : " + this.name + "\nCustomer Address : " + this.address + "\nFixed Deposit Account Balance : " + this.fixedDeposit.balance + "\nPeriod : " + this.fixedDeposit.period);
		}
	}
}

public class BankDemo{
	public static void main(String[] args){
		Customer c[] = new Customer[5];
		//Input Details
		for(int i = 0; i < 5; i++){
			Scanner in = new Scanner(System.in);
			System.out.print("\nDetails of Customer ( " + (i+1) + " ) : " + "\n------- -- -------- ");
			System.out.print("\nEnter Customer ID : ");
			int tempCustId = in.nextInt();
			System.out.print("\nEnter Customer Name : ");
			String tempName = in.next();
			System.out.print("\nEnter Customer Address : ");
			String tempAddress = in.next();
			System.out.print("\nEnter Customer Account Type ( 1 => Savings Account, 2=> Fixed Deposit Account ) : ");
			int tempType = in.nextInt();
			c[i] = new Customer(tempCustId, tempName, tempAddress, tempType);
		}
		//Transaction for Customers Account
		for(int i = 0; i < 5; i++){
			System.out.print("\nTransaction for Customer ( " + (i+1) + " ) : " + "\n----------- --- --------");
			c[i].transaction();
		}
		System.out.print("\nNumber of Accounts : " + Account.count);
	}
}
