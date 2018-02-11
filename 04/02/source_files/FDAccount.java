package pkbanking.pkaccount.fd;

import pkbanking.pkinterface.*;
import pkbanking.pkaccount.*;

public class FDAccount extends Account implements InterestRate{
  public int period;
  public boolean isClosed = false;

  public FDAccount(int accnumber, double balance, int period){
    super(accnumber, balance);
    if(period <= 0){
      System.out.print("\nERROR FDAE-001: Unable to Assign Period, Period must be Positive !");
    }
    else{
      this.period = period;
    }
  }
  public double calc_interest(){
    return (this.balance * this.fdrate * this.period);
  }
  public void close(){
    if(this.calc_interest() < 0){
      System.out.print("\nERROR FDAE-002: Unable to close Fixed Deposit Account, Balance must be Positive !");
    }
    else if(this.calc_interest() == 0){
      System.out.print("\nERROR FDAE-003: Unable to close Fixed Deposit Account, Balance must not be ZERO !");
    }
    else{
      this.balance += this.calc_interest();
      System.out.print("\nInterest : " + this.calc_interest() + " has been credited to the Account successfully !");
      this.isClosed = true;
    }
    System.out.print("\nCurrent Balance : " + this.balance);
  }
  public void status(){
    System.out.print("\nStatus of Account - " + this.accnumber + " : \nCurrent Balance : " + this.balance + "\nPeriod : " + this.period);
    if(this.isClosed){
      System.out.print("\nClosed : Yes");
    }
    else{
      System.out.print("\nClosed : No");
    }
  }
}
