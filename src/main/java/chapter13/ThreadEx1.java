package chapter13;

public class ThreadEx1 {
  public static void main(String[] args) {
    Thread t1 = new Thread_Ex1();

    Runnable r1 = new Thread_Ex2();
    Thread t2 = new Thread(r1);

    t1.run();

    t1.start();
    t2.start();

  }

}

class Thread_Ex1 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 500; i++) {
      System.out.println(getName());
    }
  }
}

class Thread_Ex2 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 500; i++) {
      System.out.println(Thread.currentThread().getName());
    }
  }
}
