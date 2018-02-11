package shape3d;

import shape2d.*;

public class Sphere extends Circle implements threed{
  public Sphere(double rad){
    super(rad);
  }
  public double volume(){
    return (1.33333333333 * this.PI * this.radius * this.radius * this.radius);
  }
  public double surfaceArea(){
    return (4 * this.PI * this.radius * this.radius);
  }
}
