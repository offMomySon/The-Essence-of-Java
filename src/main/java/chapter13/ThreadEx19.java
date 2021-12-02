package chapter13;

public class ThreadEx19 {
  public static void main(String[] args) {
    Thread th1 = new Thread(new ThreadEx19_1());
    Thread th2 = new Thread(new ThreadEx19_2());

    long startTime = System.currentTimeMillis();
    th1.start();
    th2.start();

    try {
      th1.join();
      th2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));

  }
}

class ThreadEx19_1 implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 3000; i++) {
      System.out.println("-");
    }
  }
}

class ThreadEx19_2 implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 3000; i++) {
      System.out.println("|");
    }
  }
}
