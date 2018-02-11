package shape2d;

public class Rectangle implements twod{
  protected double length;
  protected double breadth;

  public Rectangle(double len, double bre){
    this.length = len;
    this.breadth = bre;
  }
  public double area(){
    return (this.length * this.breadth);
  }
  public double perimeter(){
    return (2 * (this.length + this.breadth));
  }
}
