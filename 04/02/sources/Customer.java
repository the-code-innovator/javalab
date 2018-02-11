package pkcustomer;
import pkaccount.fd.*;
import pkaccount.sb.*;
import java.util.Scanner;
import pkexception.*;

public class Customer{
	int custid;
	String name,addr;
	SbAccount accSb;
	FDAccount accFd;

	public Customer(int id, String name, String ad){
		custid = id;
		name = name;
		addr = ad;
	}

	public  void createAccount(int type, int acno, double bal){
		if(type == 1){
			accSb = new SbAccount(acno,bal);
		}

	}
	public  void createAccount(int type, int acno, double bal, int per){
		if(type == 2){
			accFd = new FDAccount(acno,bal,per);
		}
	}


	public void transact(int type){
		Scanner s  = new Scanner(System.in);
		try{
			switch (type){
				case 1:
					System.out.println("Enter The amount to Withdraw");
					double wamt = s.nextDouble();
					accSb.withdraw(wamt);
					break;
				case 2:
					System.out.println("Enter amount to deposit");
					double damt = s.nextDouble();
					accSb.deposit(damt);
					break;
				case 3:
					accSb.calc_interest();
					break;
				case 4:
					accFd.close();
					break;
				case 5:
					if(accFd != null){
						accFd.display();
					}
					if(accSb != null){
						accSb.display();
					}
					break;
				default:
					System.out.print("\nWrong Choice !");

					break;

			}

		} catch (InsufficientFundsException e){
			System.out.println(e);
		} catch (IllegalArgumentException e){
			System.out.println(e);
		}

	}
}
