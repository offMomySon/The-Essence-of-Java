package chapter7;

public class Singleton {

  private static Singleton s = new Singleton();

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (s == null) {
      s = new Singleton();
    }
    return s;
  }
}

class SingleTonTest {

  public static void main(String[] args) {
//    Singleton ss = new Singleton();
    Singleton s = Singleton.getInstance();
  }
}