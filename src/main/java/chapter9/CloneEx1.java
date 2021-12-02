package chapter9;

public class CloneEx1 {
  public static void main(String[] args) {
    Point original = new Point(3, 5);
    Point copy = (Point) original.clone();

    System.out.println(original.toString());
    System.out.println(copy.toString());

    System.out.println(original.equals(copy));

    System.out.println(original.hashCode());
    System.out.println(original.hashCode());

  }
}

class Point implements Cloneable {
  int x, y;

  public Point() {
    this(10, 10);
  }

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }

  @Override
  public Point clone() {
    Object obj;

    try {
      obj = super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }

    return (Point) obj;
  }
}
