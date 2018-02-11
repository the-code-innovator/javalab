class Factorial extends Thread{
	private int fact,num;
	Factorial(int n){
		num = n;
		fact = 1;

	}
	public void run(){
		while(num!=1){
			fact *= num;
			display();
			num--;
		}
		display();
	}
	void display(){
		System.out.printf("The Factorial Value is : %d\n", fact);
	}
}

class SumOfSeries extends Thread{
	private int sum,num;
	SumOfSeries(int n){
		num = n;
		sum = 0;

	}
	public void run(){
		while(num!=0){
			sum += num;
			num--;
			display();
		}
		display();
	}
	void display(){
		System.out.printf("The sumOfSeries Value is : %d\n", sum);
	}
}

public class Multiple_Threads{
	public static void main(String[] args){
		Thread t1 = new Factorial(12);
		Thread t2 = new SumOfSeries(50);
		t1.start();
		t2.start();

	}
}
