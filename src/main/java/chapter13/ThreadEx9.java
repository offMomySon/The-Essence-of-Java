package chapter13;

public class ThreadEx9 {
  public static void main(String[] args) {
    ThreadGroup main = Thread.currentThread().getThreadGroup();
    ThreadGroup gr1 = new ThreadGroup("gr1");
    ThreadGroup gr2 = new ThreadGroup("gr2");

    ThreadGroup subGr1 = new ThreadGroup(gr1, "subGr1");

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    gr1.setMaxPriority(3);

    new Thread(gr1, r1, "th1").start();
    new Thread(gr2, r1, "th2").start();
    new Thread(subGr1, r1, "th3").start();

    System.out.println(">> List of Thread Group : " + main.getName()
        + ", Active ThreadGroup : " + main.activeGroupCount() + ", Active Thread : " + main.activeCount());

    main.list();

  }
}
