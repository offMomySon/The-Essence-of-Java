package chapter7;

public class BindingTest {

  public static void main(String[] args) {
    Parent2 parent2 = new Child2();
    Child2 child2 = new Child2();

    System.out.println("p.x = " + parent2.x);
    parent2.method();

    System.out.println("c.x = " + child2.x);
    child2.method();
  }
}

class Parent2 {

  int x = 100;

  void method() {
    System.out.println("Parent Method");
  }
}

class Child2 extends Parent2 {

  int x = 200;

  void method() {
    System.out.println("child Method");
  }
}

