package pkbanking.pkcustomer;

import java.util.*;
import pkbanking.pkaccount.sb.*;
import pkbanking.pkaccount.fd.*;

public class Customer{
  int cust_id;
  String name;
  String address;
	SBAccount savings[] = new SBAccount[0];
	FDAccount deposits[] = new FDAccount[0];
  public Customer(int cust_id, String name, String address){
    this.cust_id = cust_id;
    this.name = name;
    this.address = address;
  }
  public void createAccount(int type){
    Scanner in = new Scanner(System.in);
    if(type == 1){
      System.out.print("\nEnter Account Number : ");
      int accnumber = in.nextInt();
      System.out.print("\nEnter Opening Balance for the Savings Account : ");
      double balance = in.nextDouble();
      SBAccount temp = new SBAccount(accnumber, balance);
			// this.savings.add(temp);
      this.savings = push(this.savings, temp);
    }
    else if(type == 2){
      System.out.print("\nEnter Account Number : ");
      int accnumber = in.nextInt();
      System.out.print("\nEnter Period : ");
      int period = in.nextInt();
      System.out.print("\nEnter Deposit Amount for the Fixed Deposit Account : ");
      double depositAmount = in.nextDouble();
      FDAccount temp = new FDAccount(accnumber, depositAmount, period);
			// this.deposits.add(temp);
      this.deposits = push(this.deposits, temp);
    }
    else{
      System.out.print("\nERROR 00CE-001: Unable to create Account, type must be either Savings or Fixed Deposit !");
    }
  }
  public void transaction(int type){
    Scanner in = new Scanner(System.in);
    if(type == 1){
      System.out.print("\nEnter the Account Number to do transaction with : ");
      int account = in.nextInt();
      //include a search function of SBAccount type,
      //to search for the account number in the program,
      //to identify the object with which the transaction must be done.
      int index = this.search(this.savings, account);
      if(index != -1){
        this.SBAccount_transaction(index);
        //function to output status of the object.
        //this.savings[index].status();
      }
      else{
        System.out.print("\nERROR 00CE-009: Unable to process transaction, Savings Accounts with this Account Number doesn't Exist !");
      }
    }
    else if(type == 2){
      System.out.print("\nEnter the Account Number to do transaction with : ");
      int account = in.nextInt();
      //include a search function of FDAccount type,
      //to search for the account number in the program,
      //to identify the object with which the transaction must be done.
      int index = this.search(this.deposits, account);
      if(index != -1){
        this.FDAccount_transaction(index);
        //function to output status of the object.
        //this.deposits[index].status();
      }
      else{
        System.out.print("\nERROR 00CE-010: Unable to process transaction, Fixed Deposit Accounts with this Account Number doesn't Exist !");
      }
    }
    else{
      System.out.print("\nERROR 00CE-002: Unable to process transaction, type must be either either Savings or Fixed Deposit !");
    }
    this.status();
  }
  public void status(){
    System.out.print("\nStatus of Customer - " + this.cust_id + " : \nName : " + this.name + "\nAddress : " + this.address);
    if(this.savings != null){
      System.out.print("\n\nSavings Accounts Information : ");
      for(SBAccount i : this.savings){
        i.status();
      }
    }
    if(this.deposits != null){
      System.out.print("\n\nFixed Deposit Accounts Information : ");
      for(FDAccount i : this.deposits){
        i.status();
      }
    }
  }

  //push methods for dynamic array :
  private static SBAccount[] push(SBAccount array[], SBAccount pushedItem){
    SBAccount[] longer = new SBAccount[array.length + 1];
    System.arraycopy(array, 0, longer, 0, array.length);
    longer[array.length] = pushedItem;
    return longer;
  }
  private static FDAccount[] push(FDAccount array[], FDAccount pushedItem){
    FDAccount[] longer = new FDAccount[array.length + 1];
    System.arraycopy(array, 0, longer, 0, array.length);
    longer[array.length] = pushedItem;
    return longer;
  }

  //search methods for arrays :
  private static int search(SBAccount array[], int accnumber){
    int l = 0;
    int r = array.length - 1;
    while(l <= r){
      int m = ((l + r) / 2);
      if(array[m].showAccountNumber() == accnumber){
        return m;
      }
      if(array[m].showAccountNumber() < accnumber){
        l = m + 1;
      }
      else{
        r = m - 1;
      }
    }
    return -1;
  }
  private static int search(FDAccount array[], int accnumber){
    int l = 0;
    int r = array.length - 1;
    while(l <= r){
      int m = ((l + r) / 2);
      if(array[m].showAccountNumber() == accnumber){
        return m;
      }
      if(array[m].showAccountNumber() < accnumber){
        l = m + 1;
      }
      else{
        r = m - 1;
      }
    }
    return -1;
  }

  //account type specific transaction methods :
  private void SBAccount_transaction(int index){
    Scanner in = new Scanner(System.in);
    System.out.print("\nSavings Account Transaction Menu : \n1.Deposit.\n2.Withdraw.\n3.Calculate Interest.\nEnter your choice : ");
    int choice = in.nextInt();
    char confirm;
    switch(choice){
      case 1 :
        System.out.print("\nCurrent Balance : " + this.savings[index].showBalance());
        System.out.print("\nEnter Amount to Deposit into Account - " + this.savings[index].showAccountNumber() + " : ");
        double depositAmount = in.nextDouble();
        System.out.print("\nEnter 'Y' to confirm Deposit : ");
        confirm = in.next().charAt(0);
        if(confirm == 'Y' || confirm == 'y'){
          this.savings[index].deposit(depositAmount);
        }
        else{
          System.out.print("\nERROR 00CE-003: Unable to process deposit, Confirmation Ignored !");
        }
        break;
      case 2 :
        System.out.print("\nCurrent Balance : " + this.savings[index].showBalance());
        System.out.print("\nEnter Amount to Withdraw from Account - " + this.savings[index].showAccountNumber() + " : ");
        double withdrawAmount = in.nextDouble();
        System.out.print("\nEnter 'Y' to confirm Withdrawal : ");
        confirm = in.next().charAt(0);
        if(confirm == 'Y' || confirm == 'y'){
          this.savings[index].withdraw(withdrawAmount);
        }
        else{
          System.out.print("\nERROR 00CE-004: Unable to process withdraw, Confirmation Ignored !");
        }
        break;
      case 3 :
        System.out.print("\nCurrent Balance : " + this.savings[index].showBalance());
        System.out.print("\nEnter 'Y' to confirm Credit of Interest into Account - " + this.savings[index].showAccountNumber() + " : ");
        confirm = in.next().charAt(0);
        if(confirm == 'Y' || confirm == 'y'){
          this.savings[index].calc_interest();
        }
        else{
          System.out.print("\nERROR 00CE-005: Unable to credit interest, Confirmation Ignored !");
        }
        break;
      default :
        System.out.print("\nERROR 00CE-006: Unable to process transaction, Invalid Choice, Choice must be 1 (or) 2 (or) 3 !");
    }
  }
  private void FDAccount_transaction(int index){
    Scanner in = new Scanner(System.in);
    System.out.print("\nFixed Deposit Account Transaction Menu : \n1.Close Fixed Deposit Account.\n2.Calculate Interest for the Account.\nEnter your choice : ");
    int choice = in.nextInt();
    switch(choice){
      case 1 :
        System.out.print("\nCurrent Balance : " + this.deposits[index].showBalance());
        System.out.print("\nEnter 'Y' to close Fixed Deposit Account - " + this.deposits[index].showAccountNumber() + " : ");
        char confirm = in.next().charAt(0);
        if(confirm == 'Y' || confirm == 'y'){
          this.deposits[index].close();
        }
        else{
          System.out.print("\nERROR 00CE-007: Unable to Close Fixed Deposit Account, Confirmation Ignored !");
        }
        break;
      case 2 :
        System.out.print("\nCurrent Balance : " + this.deposits[index].showBalance());
        System.out.print("\nInterest for the Account - " + this.deposits[index].showAccountNumber() + " : ");
        this.deposits[index].calc_interest();
        break;
      default :
        System.out.print("\nERROR 00CE-008: Unable to process transaction, Invalid Choice, Choice must be 1 (or) 2 !");
    }
  }
}
