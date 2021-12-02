package chapter7;

public class InnerEx2 {

  class InstanceInner {

  }

  static class StaticInner {

  }

  InstanceInner iv = new InstanceInner();
  static StaticInner cv = new StaticInner();

  public static void staticMethod() {
//    InstanceInner instanceInner = new InstanceInner();
    StaticInner obj2 = new StaticInner();

    InstanceInner instanceInner = new InnerEx2().new InstanceInner();
  }

  public void instanceMethod() {
    InstanceInner obj1 = new InstanceInner();
    StaticInner obj2 = new StaticInner();

//    LocalInner localInner = new LocalInner();
  }

  void myMethod() {
    class LocalInner {

    }
    LocalInner localInner = new LocalInner();
  }
}
