import java.*;

class Point{
	double x;
	double y;
	static int count = 0;
	Point(){
		x = 0.0;
		y = 0.0;
		count++;
	}
	Point(double x1, double y1){
		x = x1;
		y = y1;
		count++;
	}
	Point(Point oldPoint){
		x = oldPoint.x;
		y = oldPoint.y;
		count++;
	}
	int getcount(){
		return count;
	}
	double find_distance(double x1, double y1){
		double d = Math.sqrt( ((x - x1) * (x - x1)) + ((y - y1) * (y - y1)) );
		return d;
	}
	double find_distance(Point p){
		double d = Math.sqrt( ((x - p.x) * (x - p.x)) + ((y - p.y) * (y - p.y)) );
		return d;
	}
	void display(){
		System.out.print(" ( x , y ) : " + "( " + x + " , " + y + " )");
	}
}

public class PointDemo{
	public static void main(String[] args){
		Point p1 = new Point(3.25, 7.89);
		Point p2 = new Point(5.37, 18.12);
		Point p3 = new Point(p2);

		double d1, d2;

		d1 = p1.find_distance(7.9, 16.25);
		d2 = p1.find_distance(p3);

		System.out.print("\nDistance Between p1 & (7.9, 16.25) : " + d1 + "\nDistance Between p1 & p3 : " +  d2);
	}
}
