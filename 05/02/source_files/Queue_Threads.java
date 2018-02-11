import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

class Queue{
	boolean full;
	int fr, rear;
	int[] arr;
	Scanner s = new Scanner(System.in);
	Queue(int n){
		arr = new int[n];
		rear=-1;
		fr = 0;
		full = false;
	}
	synchronized int get() throws Exception{
		if(fr<=rear){
			return arr[fr++];
		}
		else{
			fr = 0;
			rear = -1;
			try{
				wait();

			} catch(Exception e){
				System.out.println(e);
			}

			throw new Exception("No Value in Queue!");
		}
		//return -5;
	}
	synchronized void put(){
		System.out.println("Enter the value:");
		try{
			arr[++rear] = s.nextInt();
			notify();
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("Cannot Add further");
		}
	}
}

public class Queue_Threads{
	public static void main(String[] args){
		Queue q = new Queue(100);
		new Thread(){

			public void run(){
				int n = 5;
				while(n-- != 0){
					q.put();
					System.out.println("Value is Entered!");
				}
			}
		}.start();
		new Thread(){

			public void run(){
				this.setPriority(6);
				int n = 5;
				while(n-- != 0){
					try{
						System.out.println("\t\tThe value:" + q.get());
					} catch (Exception e){
						n++;
						//System.out.println(e);
					}

				}
			}
		}.start();
	}
}
