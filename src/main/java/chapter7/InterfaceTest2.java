package chapter7;

public class InterfaceTest2 {

  public static void main(String[] args) {
    A a = new A();
    a.autoPlay(new B());
    a.autoPlay(new C());
  }
}

class A {

  void autoPlay(I i) {
    i.play();
  }
}

class B implements I {

  @Override
  public void play() {
    System.out.println("play in B class");
  }
}

class C implements I {

  @Override
  public void play() {
    System.out.println("play in C class");
  }
}

interface I {

  void play();
}
