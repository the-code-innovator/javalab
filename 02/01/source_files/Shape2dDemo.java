import java.*;

abstract class Shape2d{
	public double a;
	public double b;
	abstract double area();
	abstract void display();
}

class Rectangle extends Shape2d{
	Rectangle(double len, double bre){
		a = len;
		b = bre;
	}
	double area(){
		double res = a * b;
		return res;
	}
	void display(){
		double ar = area();
		System.out.print("\nRectangle : \nLength : " + a + "\nBreadth : " + b + "\n\nArea : " + ar + "\n");
	}
}

class Triangle extends Shape2d{
	Triangle(double hei, double bre){
		a = hei;
		b = bre;
	}
	double area(){
		double res = 0.5 * a * b;
		return res;
	}
	void display(){
		double ar = area();
		System.out.print("\nTriangle : \nHeight : " + a + "\nBreadth : " + b + "\n\nArea : " + ar + "\n");
	}
}

public class Shape2dDemo{
	public static void main(String[] args){
		Rectangle r1 = new Rectangle(3, 4);
		Triangle t1 = new Triangle(4, 3);
		r1.display();
		t1.display();
	}
}