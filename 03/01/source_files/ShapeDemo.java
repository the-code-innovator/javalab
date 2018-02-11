import shape2d.*;
import shape3d.*;

public class ShapeDemo{
	public static void main(String[] args){
		Cube a = new Cube(5);
		Cuboid b = new Cuboid(2, 3, 4);
		Sphere c = new Sphere(7);

		Square d = new Square(4);
		Rectangle e = new Rectangle(5, 10);
		Circle f = new Circle(7);

		System.out.print("Cube : \nVolume : " + a.volume() + "\nSurface Area : " + a.surfaceArea());
		System.out.print("\nCuboid : \nVolume : " + b.volume() + "\nSurface Area : " + b.surfaceArea());
		System.out.print("\nSphere : \nVolume : " + c.volume() + "\nSurface Area : " + c.surfaceArea());

		System.out.print("\nSquare : \nArea : " + d.area() + "\nPerimeter : " + d.perimeter());
		System.out.print("\nRectangle : \nArea : " + e.area() + "\nPerimeter : " + e.perimeter());
		System.out.print("\nCircle : \nArea : " + f.area() + "\nPerimeter : " + f.perimeter());
	}
}
