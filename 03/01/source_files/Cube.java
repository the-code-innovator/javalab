package shape3d;

import shape2d.*;

public class Cube extends Square implements threed{
  public Cube(double sd){
    super(sd);
  }
  public double volume(){
    return (this.side * this.side * this.side);
  }
  public double surfaceArea(){
    return (6 * this.side * this.side);
  }
}
