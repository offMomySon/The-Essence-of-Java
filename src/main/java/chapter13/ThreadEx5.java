package chapter13;

public class ThreadEx5 {
  public static long startTime = 0;

  public static void main(String[] args) {
    ThreadEx5_1 t1 = new ThreadEx5_1();
    t1.start();

    startTime = System.currentTimeMillis();

    for (int i = 0; i < 300; i++) {
      System.out.print(new String("-"));
    }
    System.out.println();

    System.out.println("작업1 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
  }

}

class ThreadEx5_1 extends Thread {
  @Override
  public void run() {

    for (int i = 0; i < 300; i++) {
      System.out.print(new String("|"));
    }

    System.out.println();
    System.out.println("작업2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
  }
}
