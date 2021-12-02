package chapter13;

public class ThreadEx16 {
  public static void main(String[] args) {
    ThreadImplEx6 r1 = new ThreadImplEx6();
    ThreadImplEx6 r2 = new ThreadImplEx6();
    ThreadImplEx6 r3 = new ThreadImplEx6();

    new Thread(r1, "*").start();
    new Thread(r2, "**").start();
    ;
    new Thread(r3, "***").start();
    ;

    try {
      Thread.sleep(2000);
      r1.suspend();
      Thread.sleep(2000);
      r2.suspend();
      Thread.sleep(3000);
      r1.resume();
      Thread.sleep(3000);
      r1.stop();
      r2.stop();
      Thread.sleep(2000);
      r3.stop();

    } catch (Exception e) {

    }

  }
}

class ThreadImplEx6 implements Runnable {
  private boolean suspend = false;
  private boolean stopped = false;

  public void suspend() {
    this.suspend = true;
  }

  public void stop() {
    this.stopped = true;
  }

  public void resume() {
    this.suspend = false;
  }

  @Override
  public void run() {
    while (!stopped) {
      if (!suspend) {
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println(" stop - " + Thread.currentThread().getName());
  }
}
