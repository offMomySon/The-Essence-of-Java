package chapter8;

public class ExceptionEx12 {

  public static void main(String[] args) throws Exception {
    System.out.println("main start");
    method1();
    System.out.println("main end");
  }

  static void method1() throws Exception, RuntimeException {
    System.out.println("method1 start");
    try {
      method2();
    } catch (Exception e) {
      System.out.println("error happen");
    }
    System.out.println("method1 end");
  }

  static void method2() {
    System.out.println("method2 start");
    throw new RuntimeException();
  }

}
