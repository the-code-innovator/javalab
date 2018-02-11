import pkcustomer.*;
import java.util.Scanner;
public class BankDemo{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Customer a = new Customer(1,"Jaikanth","Not Available");
		System.out.println("Enter the ac no of SB Account and balance");
		a.createAccount(1,s.nextInt(),s.nextInt());
		System.out.println("Enter the AC No of FDAccount, Balance and Period");
		a.createAccount(2,s.nextInt(),s.nextInt(),s.nextInt());
		System.out.printf("1.Withdraw\n2:Deposit\n3.Calc Interst\n4.Close FD\n 5.Display\n");

		while(true){
			int choice = s.nextInt();
			if(choice > 5){
				break;
			}
			else{
				a.transact(choice);
			}
		}


	}
}
