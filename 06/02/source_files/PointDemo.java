import java.util.*;

class Point{
	int index;
	double x;
	double y;
	Point(){
		this.x = 0.0;
		this.y = 0.0;
	}
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	Point(Point oldPoint){
		this.x = oldPoint.x;
		this.y = oldPoint.y;
	}
	double findDistance(double x, double y){
		return (Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2)));
	}
	double findDistance(Point oldPoint){
		return this.findDistance(oldPoint.x, oldPoint.y);
	}
	void display(){
		System.out.printf("%.2f, %.2f", this.x, this.y);
	}
}

public class PointDemo{
	public static void main(String[] args){
		ArrayList<Point> pointList = new ArrayList<Point>();
		Scanner in = new Scanner(System.in);
		boolean exitProgram = false;
		while(! exitProgram){
			System.out.print("POINT $ ");
			String[] arguments = in.nextLine().toLowerCase().split(" ", 0);
			switch (arguments[0]){
				case "addpoint":
					pointList.add(new Point(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2])));
					break;
				case "distance":
					System.out.println("Points :");
					for(int i = 0; i < pointList.size(); i++){
						System.out.print("Point ( " + (i + 1) + " ) : ");
						pointList.get(i).display();
						System.out.print("\n");
					}
					for(int i = 0; i < pointList.size(); i++)
						for(int j = i + 1; j < pointList.size(); j++){
							System.out.print("Distance Between : ");
							pointList.get(i).display();
							System.out.print(" & ");
							pointList.get(j).display();
							System.out.print(" = " + pointList.get(i).findDistance(pointList.get(j)));
							System.out.print("\n");
						}
					break;
				case "exitprogram":
					exitProgram = true;
					break;
				case "helpmenu":
				default:
					System.out.println(
						"Help Menu :" +
						"\nGeneral Syntax :" +
						"\n   command <arguments>" +
						"\nList of Commands :" +
						"\n1. ADDPOINT" +
						"\n   example command: addpoint 3.45 4.56" +
						"\n   This command adds the point<3.45, 4.56> into the declared ArrayList<Point>." +
						"\n2. DISTANCE" +
						"\n   example command: distance" +
						"\n   This command finds the distance between every two points in the ArrayList<Point>." +
						"\n3. EXITPROGRAM" +
						"\n   example command: exitprogram" +
						"\n		This command exits the program." +
						"\n4. HELPMENU" +
						"\n   example command: helpmenu" +
						"\n   This command provides this Help Menu."
					);
			}
		}
	}
}
