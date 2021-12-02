package chapter13;

public class ThreadEx15 {
  public static void main(String[] args) {
    Runnable r = new RunImplEx15();
    Thread t1 = new Thread(r, "*");
    Thread t2 = new Thread(r, "**");
    Thread t3 = new Thread(r, "***");
    t1.start();
    t2.start();
    t3.start();

    try {
      Thread.sleep(2000);
      t1.suspend();
      Thread.sleep(2000);
      t2.suspend();
      Thread.sleep(3000);
      t1.resume();
      Thread.sleep(3000);
      t1.stop();
      t2.stop();
      Thread.sleep(2000);
      t3.stop();
    } catch (Exception e) {

    }

  }

}

class RunImplEx15 implements Runnable {
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName());
    }
  }
}