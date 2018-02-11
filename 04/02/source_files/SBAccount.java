package pkbanking.pkaccount.sb;

import pkbanking.pkinterface.*;
import pkbanking.pkaccount.*;
import pkbanking.pkexception.*;

public class SBAccount extends Account implements Transaction, InterestRate{
  public SBAccount(int accnumber, double balance){
    super(accnumber, balance);
  }
  public void deposit(double depositAmount){
    if(depositAmount < 0){
			throw (new IllegalArgumentException("ERROR SBAE-001: Unable to Process Deposit, Deposit Amount should be Positive !"));
      //System.out.print("\nERROR SBAE-001: Unable to Process Deposit, Deposit Amount should be Positive !");
    }
    else{
      this.balance += depositAmount;
      System.out.print("\nAmount : " + depositAmount + " has been deposited successfully !");
    }
    System.out.print("\nCurrent Balance : " + this.balance);
  }
  public void withdraw(double withdrawAmount){
    if(this.balance - withdrawAmount <= this.min_balance){
			throw new InsufficientFundsException("ERROR SBAE-002: Unable to Process Withdraw, Minimum Balance Required !");
			//System.out.print("\nERROR SBAE-002: Unable to Process Withdraw, Minimum Balance Required !");
    }
    else{
      this.balance -= withdrawAmount;
      System.out.print("\nAmount : " + withdrawAmount + " has been withdrawn successfully !");
    }
    System.out.print("\nCurrent Balance : " + this.balance);
  }
  public void calc_interest(){
    double interest = this.balance * this.sbrate;
    if(interest < 0){
      System.out.print("\nERROR SBAE-003: Unable to Process Interest, Account Balance should be Positive !");
    }
    else{
      this.balance += interest;
      System.out.print("\nInterest : " + interest + " has been credited to the Account successfully !");
    }
    System.out.print("\nCurrent Balance : " + this.balance);
  }
  public void status(){
    System.out.print("\nStatus of Account - " + this.accnumber + " : \nCurrent Balance : " + this.balance);
  }
}
