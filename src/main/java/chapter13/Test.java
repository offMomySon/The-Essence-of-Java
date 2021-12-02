package chapter13;

public class Test {
  public static void main(String[] args) {
    TestR th1 = new TestR("*");

    th1.start();

    try {
      Thread.sleep(2000);

      th1.interrupt();
      Thread.sleep(2000);
      Thread.sleep(3000);
      Thread.sleep(3000);
      Thread.sleep(2000);
      System.out.println("System end.");
    } catch (Exception e) {

    }
  }
}

class TestR implements Runnable {
  private final Thread th;
  private volatile boolean stopped = false;
  private volatile boolean suspended = false;

  TestR(String name) {
    th = new Thread(this, name);
  }

  @Override
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName());
      for (long x = 0; x < 2500000000L; x++) {
        ;
      }
      for (long x = 0; x < 2500000000L; x++) {
        ;
      }
    }
  }

  public void start() {
    th.start();
  }

  public void interrupt() {
    System.out.println("interrupt!");
    th.interrupt();
  }
}

