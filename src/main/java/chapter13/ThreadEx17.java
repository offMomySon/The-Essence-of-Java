package chapter13;

public class ThreadEx17 {
  public static void main(String[] args) {
    ThreadEx17_1 th1 = new ThreadEx17_1("*");
    ThreadEx17_1 th2 = new ThreadEx17_1("**");
    ThreadEx17_1 th3 = new ThreadEx17_1("***");

    th1.start();
    th2.start();
    th3.start();

    try {
      Thread.sleep(2000);
      th1.suspend();
      Thread.sleep(2000);
      th2.suspend();
      Thread.sleep(3000);
      th1.resume();
      Thread.sleep(3000);
      th1.stop();
      th2.stop();
      Thread.sleep(2000);
      th3.stop();

    } catch (Exception e) {

    }
  }
}

class ThreadEx17_1 implements Runnable {
  private final Thread th;
  private volatile boolean stopped = false;
  private volatile boolean suspended = false;

  ThreadEx17_1(String name) {
    th = new Thread(this, name);
  }

  @Override
  public void run() {
    while (!stopped) {
      if (!suspended) {
        System.out.println(Thread.currentThread().getName());

        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          System.out.println(th.getName() + " - interrupted");
        }
      } else {
        Thread.yield();
      }
    }

    System.out.println(Thread.currentThread().getName() + " - stop.");
  }

  public void start() {
    th.start();
  }

  public void stop() {
    stopped = true;
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by stop()");
  }

  public void suspend() {
    suspended = true;
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by suspend()");
  }

  public void resume() {
    suspended = false;
  }

}
