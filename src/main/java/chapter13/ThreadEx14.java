package chapter13;

import java.sql.Time;
import javax.swing.JOptionPane;

public class ThreadEx14 {
  public static void main(String[] args) {
    ThreadEx14_1 t1 = new ThreadEx14_1();
    t1.start();

    String input = JOptionPane.showInputDialog("입력:");
    t1.interrupt();
    System.out.println("isInterrupted() : " + t1.isInterrupted());

  }
}

class ThreadEx14_1 extends Thread {
  @Override
  public void run() {
    int i = 10;

    while (i != 0 && !isInterrupted()) {
      System.out.println(i++);

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        interrupt();
      }

    }
    System.out.println("thread 가 종료되었습니다.");
  }
}
