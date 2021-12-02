package chapter13;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
  public static void main(String[] args) {
    ThreadEx_11 t1 = new ThreadEx_11("Thraed1");
    ThreadEx11_2 t2 = new ThreadEx11_2("Thraed1");

    t1.start();
    t2.start();

  }

}


class ThreadEx_11 extends Thread {
  public ThreadEx_11(String name) {
    super(name);
  }

  @Override
  public void run() {
    try {
      sleep(5 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ThreadEx11_2 extends Thread {
  public ThreadEx11_2(String name) {
    super(name);
  }

  @Override
  public void run() {
    Map map = getAllStackTraces();
    Iterator iterator = map.keySet().iterator();

    int x = 0;
    while (iterator.hasNext()) {
      Thread next = (Thread) iterator.next();
      StackTraceElement[] stackTraceElement = (StackTraceElement[]) map.get(next);

      System.out.println("[" + ++x + "] name : " + next.getName() + ", group: " + next.getThreadGroup().getName() + ", daeMon : " + next.isDaemon());

      for (int i = 0; i < stackTraceElement.length; i++) {
        System.out.println(stackTraceElement[i]);
      }
      System.out.println();
    }

  }


}

