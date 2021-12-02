package chapter7;

public class SuperTest2 {

  public static void main(String[] args) {
    Parent c = new Child();
    System.out.println(c.x);
    System.out.println(c.getX());
//    c.method();
  }

}

class Parent {

  int x = 10;

  public int getX() {
    return x;
  }
}

class Child extends Parent {

  int x = 20;

  public int getX() {
    return x;
  }

  void method() {
    System.out.println("x = " + x);
    System.out.println("this.x = " + this.x);
    System.out.println("super.x = " + super.x);
  }

}

