package chapter7;

public class InterfaceTest3 {

  public static void main(String[] args) {
    A2 a2 = new A2();
    a2.methodA();
  }
}

class A2 {

  void methodA() {
    I2 i2 = InstanceManager.getInstance();

    i2.methodI();
    System.out.println(i2.toString());
  }
}

interface I2 {

  void methodI();
}

class B2 implements I2 {

  @Override
  public void methodI() {
    System.out.println("methodB in B class");
  }

  public String toString() {
    return "class B";
  }
}

class InstanceManager {

  public static I2 getInstance() {
    return new B2();
  }
}