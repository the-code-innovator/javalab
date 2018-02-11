package shape2d;

public class Circle implements twod{
  protected double radius;
  protected final double PI = 3.14159265359;

  public Circle(double rad){
    this.radius = rad;
  }
  public double area(){
    return (this.PI * this.radius * this.radius);
  }
  public double perimeter(){
    return (2 * this.PI * this.radius);
  }
}
