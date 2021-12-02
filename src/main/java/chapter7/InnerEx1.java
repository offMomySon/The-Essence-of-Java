package chapter7;

public class InnerEx1 {

  class InstanceInner {

    public int iv;
    //    public static int cv = 100;
    static final int CONST = 100;
  }

  static class StaticInner {

    public int iv = 200;
    static int cv = 200;
  }

  void myMethod() {
    class LocalInner {

      int iv = 300;
      //      static int cv = 300;
      static final int CONST = 300;
    }
  }

  public static void main(String[] args) {
    System.out.println(InstanceInner.CONST);
    System.out.println(StaticInner.cv);
  }

}
