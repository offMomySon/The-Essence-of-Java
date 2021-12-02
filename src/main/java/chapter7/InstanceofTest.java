package chapter7;

public class InstanceofTest {

  public static void main(String[] args) {
    FireEngine fe = new FireEngine();

    if (fe instanceof FireEngine) {
      System.out.println("This is a FireEngine instance.");
    }

    if (fe instanceof Car) {
      System.out.println("this is a car instance.");
    }

    if (fe instanceof Object) {
      System.out.println("this is a object instance.");
    }

    System.out.println(fe.getClass().getName());
  }


}
