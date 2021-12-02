package chapter13;

import javax.swing.JOptionPane;

public class ThreadEx13 {
  public static void main(String[] args) {
    ThreadEx13_1 t1 = new ThreadEx13_1();
    t1.start();

    String input = JOptionPane.showInputDialog("입력:");
    t1.interrupt();
    System.out.println("isInterrupted() : " + t1.isInterrupted());

  }
}

class ThreadEx13_1 extends Thread {
  @Override
  public void run() {
    int i = 10;

    while (i != 0 && !isInterrupted()) {
      System.out.println(i++);
      for (int j = 0; j < 200000000L; j++) {
        ;
      }
    }
    System.out.println("thread 가 종료되었습니다.");
  }
}
