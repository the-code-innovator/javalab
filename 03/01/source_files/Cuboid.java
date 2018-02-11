package shape3d;

import shape2d.*;

public class Cuboid extends Rectangle implements threed{
  double height;

  public Cuboid(double len, double bre, double hei){
    super(len, bre);
    this.height = hei;
  }
  public double volume(){
    return (this.length * this.breadth * this.height);
  }
  public double surfaceArea(){
    return (2 * ((this.length * this.breadth) + (this.breadth * this.height) + (this.height * this.length)));
  }
}
