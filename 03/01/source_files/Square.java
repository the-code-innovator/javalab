package shape2d;

public class Square implements twod{
  protected double side;

  public Square(double sd){
    this.side = sd;
  }
  public double area(){
    return (this.side * this.side);
  }
  public double perimeter(){
    return (4 * this.side);
  }
}
