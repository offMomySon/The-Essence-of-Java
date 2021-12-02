package chapter7;

public class PointTest {

  public static void main(String[] args) {
    Point3D point3D = new Point3D(1, 2, 3);
    System.out.println(point3D.getLocation());
  }

}

class Point2 {

  public int x, y;

  public Point2(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String getLocation() {
    return "x : " + x + ", y : " + y;
  }

}

class Point3D extends Point2 {

  public int z;

  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  public String getLocation() {
    return super.getLocation() + ", z : " + this.z;
  }

}


