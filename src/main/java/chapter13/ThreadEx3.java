package chapter13;

public class ThreadEx3 {
  public static void main(String[] args) {
    ThreadEx3_1 t1 = new ThreadEx3_1();
    t1.run();
  }
}

class ThreadEx3_1 extends Thread {
  @Override
  public void run() {
    throwException();
  }

  private void throwException() {
    throw new RuntimeException();
  }
}
