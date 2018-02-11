import java.util.*;
class Point{
	double x,y;
	Point(double x, double y){
			this.x = x;
			this.y = y;
	}
	Point(){
		x = 0;
		y = 0;
	}
	Point(Point obj){
		x = obj.x;
		y = obj.y;
	}
	double find_distance(double x1, double y1){
		return Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
	}
	double find_distance(Point obj){
		return this.find_distance(obj.x,obj.y);
	}
	void display(){
		System.out.printf("(%.2f,%.2f)",x,y);
	}
}
public class PointDemo{
	public static void main(String[] args){
		ArrayList<Point> a = new ArrayList<Point>(5);
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		while(true){
			System.out.print("PROMPT>> ");
			String cmd = s.nextLine().toLowerCase();
			String[] cmds = cmd.split(" ",0);
			switch (cmds[0]){
				case "add": {
					a.add(new Point(Double.parseDouble(cmds[1]),Double.parseDouble(cmds[2])));
					break;
				}
				case "dist":{
					ListIterator<Point> li = a.listIterator();
					Point fi = li.next();
					while(li.hasNext()){
						Point nxt = li.next();
						double dist = fi.find_distance(nxt);
						System.out.printf("Distance between (%f,%f) and (%f,%f) is: %f \t",fi.x,fi.y,nxt.x,nxt.y,dist);
						fi = nxt;
					}
					System.out.printf("\n");
					break;
				}
				case "exit":{
					exit=true;
					break;
				}
				default:{
					System.out.printf("HELP MENU\n\nGENERAL SYNTAX: COMMAND <OPTIONS>\n\nLIST OF COMMANDS\nADD\t-\tTwo Distances X Y\nDIST\t-\tCalculates distance\nEXIT\t-\tQuits the program\nHELP\t-\tDisplays Help Menu\n\n");
				}
			}
			if(exit){
				break;
			}
		}
	}
}
